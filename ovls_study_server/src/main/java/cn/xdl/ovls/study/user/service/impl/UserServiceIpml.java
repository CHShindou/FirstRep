package cn.xdl.ovls.study.user.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xdl.ovls.study.entity.ResponseEntity;
import cn.xdl.ovls.study.user.bean.LoginHistory;
import cn.xdl.ovls.study.user.bean.User;
import cn.xdl.ovls.study.user.dao.UserMapper;
import cn.xdl.ovls.study.user.service.LoginHistoryService;
import cn.xdl.ovls.study.user.service.UserService;
import cn.xdl.ovls.study.util.Md5Util;
import cn.xdl.ovls.study.util.SaltUtil;
import cn.xdl.ovls.study.util.TokenManager;

@Service
public class UserServiceIpml implements UserService{
	
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private TokenManager tokenManager;
	@Autowired
	private LoginHistoryService loginService;

	@Override
	public ResponseEntity userLogin(String username, String password,String ipv4) {
		//user.getPassword()是加密之后的密码  password是明文密码
		//需要将明文密码加密之后与加密密码对比
		ResponseEntity response = new ResponseEntity();
		User user = userMapper.selectByName(username);
		if(user == null){
			//用户名错误
			response.setStatus(1);
			response.setMsg("用户名错误");
		}else{ 
			//将明文密码加密
			String md5Password = Md5Util.md5(password+user.getSalt());
			if(!md5Password.equals(user.getPassword())){
				//密码错误
				response.setStatus(2);
				response.setMsg("密码错误");
			}else{
				//登录成功
				response.setStatus(0);
				response.setMsg("登录成功");
				//获取token并返回给客户端
				String token = tokenManager.createToken(user.getId());
				response.setData(token);
				//登陆成功之后开个线程用于将和该用户有关的信息加载进redis中
				//没研究好
				//添加用户登录信息
				LoginHistory record = new LoginHistory();
				record.setUserId(user.getId());
				record.setIp(ipv4);
				loginService.addLoginHistory(record);
			}
		}
		return response;
	}

	@Override
	public ResponseEntity userRegist(User user) {
		ResponseEntity response = new ResponseEntity();
		user.setRegtime(new Date());
		//获取盐salt
		String salt = SaltUtil.createSalt();
		//将前端传来的明文密码加密之后再存入数据库中
		user.setPassword(Md5Util.md5(user.getPassword()+salt));
		user.setSalt(salt);
		//设置默认头像
		user.setImage("paopao.jpg");
		//设置默认的昵称就是用户名
		user.setNickName(user.getName());
		int flag = userMapper.insert(user);
		if(flag>0){
			//注册成功
			response.setStatus(0);
			response.setMsg("注册成功");
		}else{
			//注册失败
			response.setStatus(0);
			response.setMsg("注册失败");
		}
		return response;
	}

	@Override
	public ResponseEntity ckeckUserName(String username) {
		ResponseEntity response = new ResponseEntity();
		User user = userMapper.selectByName(username);
		if(user == null){
			//用户名不存在（可以注册）
			response.setStatus(0);
			response.setMsg("用户名不存在");
		}else{
			//用户名已存在
			response.setStatus(1);
			response.setMsg("用户名已存在");
		}
		return response;
	}

	@Override
	public ResponseEntity loadUserById(int id) {
		ResponseEntity response = new ResponseEntity();
		User user = userMapper.selectByPrimaryKey(id);
		if(user == null){
			response.setStatus(1);
			response.setMsg("未找到该用户");
		}else{
			//找到用户，将用户名传送给前端
			response.setStatus(0);
			response.setMsg("找到用户");
			response.setData(user);
		}
		return response;
	}

	@Override
	public ResponseEntity logoutUser(String token) {
		ResponseEntity response = new ResponseEntity();
		boolean ok = tokenManager.clearToken(token);
		if(ok){
			//token删除成功
			response.setStatus(0);
			response.setMsg("token删除成功");
		}
		else{
			//删除失败
			response.setStatus(1);
			response.setMsg("token删除失败");
		}
		return response;
	}

	@Override
	public ResponseEntity updateUserInfo(User user) {
		ResponseEntity response = new ResponseEntity();
		int i = userMapper.updateByPrimaryKeySelective(user);
		if(i>0){
			//修改成功
			response.setStatus(0);
			response.setMsg("修改成功");
			response.setData(user);
		}else{
			//修改失败
			response.setStatus(1);
			response.setMsg("修改失败");
		}
		return response;
	}

	@Override
	public ResponseEntity updateUserPassword(String name,String old_pass,String new_pass) {
		ResponseEntity response = new ResponseEntity();
		//首先通过用户名和旧密码查询数据库，看看该用户名或密码是否正确
		//原本打算直接使用之前的登录方法判断，不过登录的时候没有返回user信息，所以就重新写了
		User user = userMapper.selectByName(name);
		if(user==null){
			//未查询到该用户(用户名错误)
			response.setStatus(1);
			response.setMsg("用户名错误");
		}else{
			//查询到该用户,获取该用户加密后的密码的值
			//将old_pass加密，然后跟数据库中的密码对比
			if(!Md5Util.md5(old_pass+user.getSalt()).equals(user.getPassword())){
				//old_pass与数据库中的密码不一致，输入的密码错误
				response.setStatus(2);
				response.setMsg("原密码错误");
			}else{
				//用户名和原密码都正确，可以进行修改密码的操作
				//将新密码加密,并存入user中
				user.setPassword(Md5Util.md5(new_pass+user.getSalt()));
				int i = userMapper.updateByPrimaryKeySelective(user);
				if(i>0){
					//密码修改成功
					response.setStatus(0);
					response.setMsg("修改成功");
				}else{
					//密码修改失败，一般不会出现
					response.setStatus(3);
					response.setMsg("修改失败");
				}
			}
			
		}
		return response;
	}

	@Override
	public ResponseEntity updateUserImage(String imgData, String imgPath,String token) {
		ResponseEntity response = new ResponseEntity();
		response.setStatus(1);
		response.setMsg("上传失败");
		//获取一个随机的文件名(偷懒了，直接用之前生成盐的方法来生成一个文件名)
		String imgname = SaltUtil.createSalt()+".jpg";
		 // 将dataURL开头的非base64字符删除
        String base64 = imgData.substring(imgData.indexOf(",") + 1);
        
        String fileName = imgPath +"/"+ imgname;
        System.out.println(base64);
        System.out.println(fileName);
		try {
			//将头像存入到目的文件中
			FileOutputStream write = new FileOutputStream(new File(fileName));
	        byte[] decoderBytes = new Base64().decode(base64);
	        write.write(decoderBytes);
	        write.close();
	        //修改用户的头像
	        int id = Integer.parseInt(token.split("_")[0]);
	        User user = new User();
	        user.setId(id);
	        user.setImage(imgname);
	        userMapper.updateByPrimaryKeySelective(user);
	        response.setStatus(0);
	        response.setMsg("上传成功");
	        response.setData(imgname);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return response;
	}

}
