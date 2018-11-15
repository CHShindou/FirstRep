package cn.xdl.ovls.study.video.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.xdl.ovls.study.entity.ResponseEntity;
import cn.xdl.ovls.study.util.Authorization;
import cn.xdl.ovls.study.video.bean.Note;
import cn.xdl.ovls.study.video.service.NoteService;

@RestController
public class NoteController {

	@Autowired
	private NoteService noteService;
	
	@RequestMapping(value="/course/{id}/note", method=RequestMethod.GET)
	public ResponseEntity loadNoteFromCourse(@PathVariable("id")int id){
		return noteService.loadNoteBycourse(id);
	}
	
	@RequestMapping(value="/user/{id}/note",method=RequestMethod.POST)
	public ResponseEntity addNoteInfo(@PathVariable("id")int user_id,Note note){
		note.setUserId(user_id);
		note.setPublishTime(new Date());
		note.setTitle(note.getContext());
		note.setLikeCount(0);
		return noteService.addNote(note);
	}
	
	@RequestMapping(value="/video/{id}/note", method=RequestMethod.GET)
	public ResponseEntity loadNoteByVideo(@PathVariable("id")int id,int page,int top){
		return noteService.loadNoteByVideo(id,page,top);
	}
	
	@Authorization
	@RequestMapping(value="/video/{id}/user/note", method=RequestMethod.GET)
	public ResponseEntity loadNoteByVideoAndUser(@PathVariable("id")int id,String access_token,int page,int top){
		int user_id = Integer.parseInt(access_token.split("_")[0]);
		return noteService.LoadNoteByVideoAndUser(id,user_id,page,top);
	}
	
}
