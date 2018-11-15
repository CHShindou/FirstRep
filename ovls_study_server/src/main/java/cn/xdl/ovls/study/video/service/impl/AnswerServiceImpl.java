package cn.xdl.ovls.study.video.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xdl.ovls.study.entity.ResponseEntity;
import cn.xdl.ovls.study.video.bean.Answer;
import cn.xdl.ovls.study.video.dao.AnswerMapper;
import cn.xdl.ovls.study.video.service.AnswerService;

@Service
public class AnswerServiceImpl implements AnswerService{

	@Autowired
	private AnswerMapper answerMapper;
	
	@Override
	public ResponseEntity addAnswer(Answer answer) {
		ResponseEntity response = new ResponseEntity();
		int i = answerMapper.insert(answer);
		if(i>0){
			//添加回答成功
			response.setStatus(0);
			response.setMsg("回答成功");
			response.setData(answer);
		}else{
			response.setStatus(1);
			response.setMsg("回答失败");
		}
		return response;
	}

}
