package cn.xdl.ovls.study.user.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.xdl.ovls.study.entity.ResponseEntity;
import cn.xdl.ovls.study.user.bean.User;
import cn.xdl.ovls.study.user.service.UserService;
import cn.xdl.ovls.study.util.Authorization;


@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	
	/**
	 * 用户登录功能
	 * @param username:用户名;password:用户密码(明文);ipv4:用户登录的IP
	 * */
	@RequestMapping(value="/user/token",method=RequestMethod.POST)
	public ResponseEntity login(String username,String password,String ipv4){
		return userService.userLogin(username, password,ipv4);
	}
	
	/**
	 * 用户注册功能
	 * */
	@RequestMapping(value="/user/regist",method=RequestMethod.POST)
	public ResponseEntity regist(String username,String password){
		User user = new User();
		user.setName(username);
		user.setPassword(password);
		return userService.userRegist(user);
	}
	
	/**
	 * 检测用户名是否重复 <br/>
	 * 用于用户注册时，检测用户名是否已经被注册
	 * */
	@RequestMapping(value="/user/checkName",method=RequestMethod.GET)
	public ResponseEntity ckeckUserName(String username){
		return userService.ckeckUserName(username);
	}
	
	/**
	 * 通过ID获取用户的详细信息
	 * */
	@Authorization
	@RequestMapping(value="/checkuser/userid",method=RequestMethod.GET)
	public ResponseEntity loadUser(String access_token){
		//从token中获取用户的ID
		int id = Integer.parseInt(access_token.split("_")[0]);
		return userService.loadUserById(id);
	}
	
	/**
	 * 用户退出登录
	 * @param  令牌;
	 * */
	@Authorization
	@RequestMapping(value="/user/logout",method=RequestMethod.GET)
	public ResponseEntity logoutUser(String access_token){
		return userService.logoutUser(access_token);
	}
	
	/**
	 * 修改用户的详细信息(不包括修改密码)
	 * */
	@Authorization
	@RequestMapping(value="/user/edit",method=RequestMethod.POST)
	public ResponseEntity editUserInfo(User user,String access_token){
		int id = Integer.parseInt(access_token.split("_")[0]);
		user.setId(id);
		return userService.updateUserInfo(user);
	}
	
	/**
	 * 用户修改密码
	 * */
	@Authorization
	@RequestMapping(value="/user/password",method=RequestMethod.POST)
	public ResponseEntity updateUserPass(String name,String old_pass,String new_pass){
		return userService.updateUserPassword(name, old_pass, new_pass);
	}
	
	/**
	 * 用户修改头像
	 * @param imgData:已urlData格式保存的头像数据;
	 * @param imgPath:需要将头像数据保存的地址
	 * */
	@Authorization
	@RequestMapping(value="/user/image",method=RequestMethod.POST)
	public ResponseEntity updateUserImage(String imgData,String imgPath,String access_token){
		//获取请求的绝对路径
		//String imgPath = request.getServletContext().getRealPath("/userImg");
		//System.out.println(imgPath);
		return userService.updateUserImage(imgData, imgPath,access_token);
	}
}
