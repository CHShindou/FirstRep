package cn.xdl.ovls.study.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.xdl.ovls.study.entity.ResponseEntity;
import cn.xdl.ovls.study.user.service.BrowsingHistoryService;
import cn.xdl.ovls.study.util.Authorization;

@RestController
public class BrowsingHistoryController {

	@Autowired
	private BrowsingHistoryService browHistoryService;
	
	@Authorization
	@RequestMapping(value="/video/brower",method=RequestMethod.POST)
	public ResponseEntity addUserBrowsCourse(String access_token,int videoId){
		return browHistoryService.addUserBrowCourse(access_token, videoId);
	}
	
	@Authorization
	@RequestMapping(value="/user/browsing",method=RequestMethod.GET)
	public ResponseEntity loadBrowsingByUser(String access_token){
		return browHistoryService.loadUserBrowsing(access_token);
	}
}
