package cn.xdl.ovls.study.video.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.xdl.ovls.study.entity.ResponseEntity;
import cn.xdl.ovls.study.util.Authorization;
import cn.xdl.ovls.study.video.bean.Answer;
import cn.xdl.ovls.study.video.service.AnswerService;

@RestController
public class AnswerController {

	@Autowired
	private AnswerService answerService;
	
	
	/**
	 * 用户在视频的提问中发表一个回答;
	 * @param issue_id:问题ID;context:回答的内容;
	 * */
	@Authorization
	@RequestMapping(value="/issue/answer",method=RequestMethod.POST)
	public ResponseEntity insertAnswer(int issue_id,String context,String access_token){
		int user_id = Integer.parseInt(access_token.split("_")[0]);
		Answer answer = new Answer();
		answer.setContext(context);
		answer.setIssueId(issue_id);
		answer.setPublishTime(new Date());
		answer.setUserId(user_id);
		return answerService.addAnswer(answer);
	}
	
}
