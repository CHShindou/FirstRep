package cn.xdl.ovls.study.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.xdl.ovls.study.entity.ResponseEntity;
import cn.xdl.ovls.study.user.service.LoginHistoryService;
import cn.xdl.ovls.study.util.Authorization;

@RestController
public class LoginHistoryController {

	@Autowired
	private LoginHistoryService loginService;
	
	/**
	 * 加载用户的登录历史记录
	 * */
	@Authorization
	@RequestMapping(value="/user/loginrecord",method=RequestMethod.GET)
	public ResponseEntity loadLoginHistory(String access_token){
		int user_id = Integer.parseInt(access_token.split("_")[0]);
		return loginService.loadLoginHistory(user_id);
	}
}
