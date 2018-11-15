package cn.xdl.ovls.study.user.service;

import cn.xdl.ovls.study.entity.ResponseEntity;
import cn.xdl.ovls.study.user.bean.User;

public interface UserService {
	
	/**
	 * 用户登录功能
	 * @param 传入参数用户名和密码
	 * @return 返回值是处理的结果
	 * */
	ResponseEntity userLogin(String username,String password,String ipv4);
	
	
	/**
	 * 用户注册功能
	 *
	 * */
	ResponseEntity userRegist(User user);
	
	/**
	 * 检测用户名是否重复
	 * */
	ResponseEntity ckeckUserName(String username);
	
	/**
	 * 通过id查询user信息
	 * */
	ResponseEntity loadUserById(int id);
	
	
	/**
	 * 用户退出登录状态
	 * */
	ResponseEntity logoutUser(String token);
	
	
	/**
	 * 更新用户信息(除了密码) 
	 * */
	ResponseEntity updateUserInfo(User user);
	
	
	/**
	 * 用户修改密码
	 * */
	ResponseEntity updateUserPassword(String name,String old_pass,String new_pass);
	
	
	/**
	 * 修改用户头像
	 * */
	ResponseEntity updateUserImage(String imgData,String imgPath,String token);
}
