package cn.xdl.ovls.study.user.service;

import cn.xdl.ovls.study.entity.ResponseEntity;
import cn.xdl.ovls.study.user.bean.EvaluationLike;

public interface EvaluationLikeService {

	
	/**
	 * 添加一条评论点赞信息
	 * */
	ResponseEntity addEvalLike(EvaluationLike record);
	
	/**
	 * 通过UserId查询一组点赞信息
	 * */
	ResponseEntity loadEvalLikeByUser(int userId);
}
