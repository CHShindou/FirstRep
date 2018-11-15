package cn.xdl.ovls.study.video.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.xdl.ovls.study.entity.ResponseEntity;
import cn.xdl.ovls.study.video.bean.Issue;
import cn.xdl.ovls.study.video.service.IssueService;

@RestController
public class IssueController {

	@Autowired
	private IssueService issueService;
	
	/**
	 * 用户发表一个提问
	 * */
	@RequestMapping(value="/user/{id}/issue",method=RequestMethod.POST)
	public ResponseEntity addIssueInfo(@PathVariable("id")int user_id,Issue issue){
		issue.setPublishTime(new Date());
		issue.setUserId(user_id);
		issue.setAnswerCount(0);
		issue.setBrowseCount(0);
		return issueService.addIssue(issue);
	}
	
	/**
	 * 显示某一个视频下面的所有提问，分页显示
	 * @param video_id:视频ID,
	 * @param page:当前需要显示第几页
	 * @param top:当前页需要显示的个数
	 * */
	@RequestMapping(value="/video/{id}/issue",method=RequestMethod.GET)
	public ResponseEntity loadIssueByVideo(@PathVariable("id")int video_id,int page,int top){
		return issueService.loadIssueByVideo(video_id,page,top);
	}
}
