package cn.xdl.ovls.study.user.service;

import cn.xdl.ovls.study.entity.ResponseEntity;

public interface CollectCourseService {

	/**
	 * 通过userId和courseId 查询收藏记录是否存在
	 * */
	ResponseEntity checkCollectCourseByUserAndCourse(int userId,int courseId);
	
	
	/**
	 * 添加一条收藏记录
	 * */
	ResponseEntity addCollectCourse(int courseId,String token);
	
	/**
	 * 删除一条收藏记录
	 * */
	ResponseEntity deleteCollectByUserAndCourse(String token,int courseId);
	
	/**
	 * 加载某用户的所有收藏记录
	 * @param userId:用户id; page:指定查询的页数;top:每页显示的数量
	 * */
	ResponseEntity loadCollectCourse(int userId,int page,int top);
}
