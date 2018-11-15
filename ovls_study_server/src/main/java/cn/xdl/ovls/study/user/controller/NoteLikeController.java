package cn.xdl.ovls.study.user.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.xdl.ovls.study.entity.ResponseEntity;
import cn.xdl.ovls.study.user.bean.NoteLike;
import cn.xdl.ovls.study.user.service.NoteLikeService;
import cn.xdl.ovls.study.util.Authorization;

@RestController
public class NoteLikeController {

	@Autowired
	private NoteLikeService noteLikeService;
	
	/**
	 * 用户给某条笔记点赞
	 * */
	@Authorization
	@RequestMapping(value="/user/{userId}/addNoteLike",method=RequestMethod.POST)
	public ResponseEntity addNoteLike(@PathVariable("userId")int userId,int noteId){
		NoteLike record = new NoteLike();
		record.setLikeTime(new Date());
		record.setNoteId(noteId);
		record.setUserId(userId);
		return noteLikeService.addNoteLike(record);
	}
	
	
	/**
	 * 加载某用户的所有笔记点赞信息<br/>
	 * 应该是只需要先显示某个学科或视频下的点赞状态即可,不过还是查出来所有的记录，在前端检索显示.
	 * */
	@Authorization
	@RequestMapping(value="/user/{userId}/loadNoteLike",method=RequestMethod.GET)
	public ResponseEntity loadUserEvalLike(@PathVariable("userId")int userId){
		return noteLikeService.loadNoteLikeByUser(userId);
	}
}
