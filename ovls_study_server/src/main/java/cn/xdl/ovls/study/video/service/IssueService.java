package cn.xdl.ovls.study.video.service;

import cn.xdl.ovls.study.entity.ResponseEntity;
import cn.xdl.ovls.study.video.bean.Issue;

public interface IssueService {

	/**
	 * 添加一个提问
	 * */
	ResponseEntity addIssue(Issue issue);
	
	/**
	 * 加载一个视频中的所有提问
	 *  @param page表示显示哪一页，top表示每页显示的个数
	 * */
	ResponseEntity loadIssueByVideo(int video_id,int page,int top);
}
