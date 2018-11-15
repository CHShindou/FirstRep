package cn.xdl.ovls.study.course.service;

import cn.xdl.ovls.study.entity.ResponseEntity;

public interface CourseService {
	
	/**
	 * 加载免费课程
	 * */
	ResponseEntity loadFreeCourse(int pagetop);
	
	/**
	 * 加载推荐课程
	 * */
	ResponseEntity loadGoodCourse(int pagetop);
	
	/**
	 * 通过id加载课程的详细信息
	 * */
	ResponseEntity loadCourseById(int id);
	
	/**
	 * 查找某个subject中的所有课程信息
	 * */
	ResponseEntity loadCourseBySubject(int subject_id);
	
	/**
	 * 通过关键字搜索课程
	 * */
	ResponseEntity LoadSearchCourse(String search);
}
