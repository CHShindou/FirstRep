package cn.xdl.ovls.study.user.service;

import cn.xdl.ovls.study.entity.ResponseEntity;


public interface BrowsingHistoryService {

	
	/**
	 * 添加用户的浏览记录
	 * 如果该用户浏览的课程已经存在，那么久更新记录，否则就新增
	 * */
	
	ResponseEntity addUserBrowCourse(String token,int videoId);
	
	/**
	 * 通过用户Id加载改用户的所有浏览记录，只取出前6条吧，不取那么多了
	 * 不做分页了  累。
	 * */
	ResponseEntity loadUserBrowsing(String token);
	
}
