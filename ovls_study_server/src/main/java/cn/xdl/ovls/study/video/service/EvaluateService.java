package cn.xdl.ovls.study.video.service;

import cn.xdl.ovls.study.entity.ResponseEntity;
import cn.xdl.ovls.study.video.bean.Evaluate;

public interface EvaluateService {
	
	/**
	 * 加载某一个学科所有视频的所有评论
	 * */
	ResponseEntity loadEvaluateForCourse(int courseId,int page,int top);
	
	/**
	 * 添加评论信息
	 * */
	ResponseEntity addEvaluate(Evaluate eval);
	
	/**
	 * 加载某一个视频的所有评论信息
	 * @param video_id:视频ID; page:查询哪一页; top:每页显示的个数
	 * */
	ResponseEntity loadEvaluateByVideo(int video_id,int page,int top);

}
