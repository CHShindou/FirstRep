package cn.xdl.ovls.study.user.service;

import cn.xdl.ovls.study.entity.ResponseEntity;
import cn.xdl.ovls.study.user.bean.LoginHistory;

public interface LoginHistoryService {
	
	
	/**
	 * 添加用户的登录记录
	 * @return 
	 * */
	void addLoginHistory(LoginHistory record);
	
	
	/**
	 * 查询用户的所有登录记录 取前10条
	 * */
	ResponseEntity loadLoginHistory(int user_id);

}
