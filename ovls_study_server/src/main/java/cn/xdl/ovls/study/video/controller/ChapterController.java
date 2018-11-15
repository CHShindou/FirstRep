package cn.xdl.ovls.study.video.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.xdl.ovls.study.entity.ResponseEntity;
import cn.xdl.ovls.study.video.service.ChapterService;

@RestController
public class ChapterController {

	@Autowired
	private ChapterService chapterService;
	
	@RequestMapping(value="/course/{id}/chapter",method=RequestMethod.GET)
	public ResponseEntity loadChapterAndVideos(@PathVariable("id")int id){
		return chapterService.loadChapterAndVideo(id);
	}
}
