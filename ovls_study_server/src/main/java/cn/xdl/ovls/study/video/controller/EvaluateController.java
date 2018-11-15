package cn.xdl.ovls.study.video.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.xdl.ovls.study.entity.ResponseEntity;
import cn.xdl.ovls.study.util.Authorization;
import cn.xdl.ovls.study.video.bean.Evaluate;
import cn.xdl.ovls.study.video.service.EvaluateService;

@RestController
public class EvaluateController {

	@Autowired
	private EvaluateService evaluateService;
	
	@RequestMapping(value="/course/{id}/eval",method=RequestMethod.GET)
	public ResponseEntity loadEvaluateByCourse(@PathVariable("id")int id,int page,int top){
		return evaluateService.loadEvaluateForCourse(id,page,top);
	}
	
	@Authorization
	@RequestMapping(value="/user/{id}/eval",method=RequestMethod.POST)
	public ResponseEntity addEvaluateInfo(@PathVariable("id")int userId,Evaluate eval){
		eval.setUseId(userId);
		eval.setPublishTime(new Date());
		eval.setLikeCount(0);
		return evaluateService.addEvaluate(eval);
	}
	
	@RequestMapping(value="/video/{id}/eval",method=RequestMethod.GET)
	public ResponseEntity loadEvaluateByVideo(@PathVariable("id")int video_id,int page,int top){
		return evaluateService.loadEvaluateByVideo(video_id,page,top);
	}
}
