package cn.xdl.ovls.study.video.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.xdl.ovls.study.entity.ResponseEntity;
import cn.xdl.ovls.study.util.Authorization;
import cn.xdl.ovls.study.video.service.VideoService;

@RestController
public class VideoController {

	@Autowired
	private VideoService videoService;
	
	@Authorization
	@RequestMapping(value="/video/{id}",method=RequestMethod.GET)
	public ResponseEntity findVideoInfo(@PathVariable("id")int id){
		return videoService.findVideoById(id);
	}
}
