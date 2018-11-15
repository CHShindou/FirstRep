package cn.xdl.ovls.study.video.service;

import cn.xdl.ovls.study.entity.ResponseEntity;
import cn.xdl.ovls.study.video.bean.Answer;

public interface AnswerService {

	/**
	 * 添加一个问题的回答
	 * */
	ResponseEntity addAnswer(Answer answer);
}
