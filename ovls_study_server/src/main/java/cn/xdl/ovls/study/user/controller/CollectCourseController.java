package cn.xdl.ovls.study.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.xdl.ovls.study.entity.ResponseEntity;
import cn.xdl.ovls.study.user.service.CollectCourseService;
import cn.xdl.ovls.study.util.Authorization;

@RestController
public class CollectCourseController {

	@Autowired
	private CollectCourseService collectCourseService;
	
	@Authorization
	@RequestMapping(value="/checkCollectCourse/{userId}",method=RequestMethod.GET)
	public ResponseEntity checkCollectCourse(@PathVariable("userId")int userId,int courseId){
		return collectCourseService.checkCollectCourseByUserAndCourse(userId, courseId);
	}
	
	@Authorization
	@RequestMapping(value="/user/collectcourse",method=RequestMethod.POST)
	public ResponseEntity addCollectCourse(int courseId,String access_token){
		return collectCourseService.addCollectCourse(courseId, access_token);
	}
	
	@Authorization
	@RequestMapping(value="/user/removecourse",method=RequestMethod.POST)
	public ResponseEntity deleteCollectCourseByUserAndCourse(String access_token,int courseId){
		return collectCourseService.deleteCollectByUserAndCourse(access_token, courseId);
	}
	
	@Authorization
	@RequestMapping(value="/user/showCollectCourse",method=RequestMethod.GET)
	public ResponseEntity loadCollectCourse(String access_token,int page,int top){
		int userId = Integer.parseInt(access_token.split("_")[0]);
		return collectCourseService.loadCollectCourse(userId, page, top);
	}
}
