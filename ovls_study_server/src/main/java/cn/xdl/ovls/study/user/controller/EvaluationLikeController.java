package cn.xdl.ovls.study.user.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.xdl.ovls.study.entity.ResponseEntity;
import cn.xdl.ovls.study.user.bean.EvaluationLike;
import cn.xdl.ovls.study.user.service.EvaluationLikeService;
import cn.xdl.ovls.study.util.Authorization;

/**
 * 对于评论点赞功能的所有操作<br/>
 * 所有操作都和笔记点赞功能相同<br/>
 * 不解释
 * */

@RestController
public class EvaluationLikeController {

	@Autowired
	private EvaluationLikeService evalLikeService;
	
	@Authorization
	@RequestMapping(value="/user/{userId}/addEvalLike",method=RequestMethod.POST)
	public ResponseEntity addEvaluationLike(@PathVariable("userId")int userId,int evalId){
		EvaluationLike record = new EvaluationLike();
		record.setEvaluationId(evalId);
		record.setUserId(userId);
		record.setLikeTime(new Date());
		return evalLikeService.addEvalLike(record);
	}
	
	@Authorization
	@RequestMapping(value="/user/{userId}/loadEvalLike",method=RequestMethod.GET)
	public ResponseEntity loadUserEvalLike(@PathVariable("userId")int userId){
		return evalLikeService.loadEvalLikeByUser(userId);
	}
}
