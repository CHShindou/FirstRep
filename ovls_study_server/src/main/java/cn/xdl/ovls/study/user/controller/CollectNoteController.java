package cn.xdl.ovls.study.user.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.xdl.ovls.study.entity.ResponseEntity;
import cn.xdl.ovls.study.user.bean.CollectNote;
import cn.xdl.ovls.study.user.service.CollectNoteService;
import cn.xdl.ovls.study.util.Authorization;

@RestController
public class CollectNoteController {

	@Autowired
	private CollectNoteService collectNoteService;
	
	@Authorization
	@RequestMapping(value="/user/{userId}/addCollectNote",method=RequestMethod.POST)
	public ResponseEntity addCollectNoteInfo(@PathVariable("userId")int userId,int noteId){
		CollectNote record = new CollectNote();
		record.setCollectTime(new Date());
		record.setUserId(userId);
		record.setNoteId(noteId);
		return collectNoteService.addCollectNote(record);
	}
	
	@Authorization
	@RequestMapping(value="/user/{userId}/checkCollectNote",method=RequestMethod.GET)
	public ResponseEntity checkCollectNotoInfo(@PathVariable("userId")int userId){
		return collectNoteService.loadCollectNoteByUser(userId);
	}
	
	//@Authorization
	@RequestMapping(value="/user/{userId}/showCollectNote",method=RequestMethod.GET)
	public ResponseEntity loadCollectNotoInfo(@PathVariable("userId")int userId){
		return collectNoteService.loadAllCollectNoteByUser(userId);
	}
}
