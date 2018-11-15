package cn.xdl.ovls.study.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xdl.ovls.study.entity.ResponseEntity;
import cn.xdl.ovls.study.user.bean.EvaluationLike;
import cn.xdl.ovls.study.user.dao.EvaluationLikeMapper;
import cn.xdl.ovls.study.user.service.EvaluationLikeService;
import cn.xdl.ovls.study.video.bean.Evaluate;
import cn.xdl.ovls.study.video.dao.EvaluateMapper;

@Service
public class EvaluationLikeServiceImpl implements EvaluationLikeService {

	@Autowired
	private EvaluationLikeMapper evalLikeMapper;
	@Autowired
	private EvaluateMapper evalMapper;
	
	@Override
	public ResponseEntity addEvalLike(EvaluationLike record) {
		ResponseEntity response = new ResponseEntity();
		int i = evalLikeMapper.insert(record);
		if(i>0){
			response.setStatus(0);
			response.setMsg("点赞成功");
			//将评论表中该评论的点赞次数+1
			Evaluate eval = evalMapper.selectByPrimaryKey(record.getEvaluationId());
			eval.setLikeCount(eval.getLikeCount()+1);
			evalMapper.updateByPrimaryKey(eval);
		}else{
			response.setStatus(1);
			response.setMsg("点赞失败");
		}
		return response;
	}

	@Override
	public ResponseEntity loadEvalLikeByUser(int userId) {
		ResponseEntity response = new ResponseEntity();
		List<EvaluationLike> list = evalLikeMapper.selectByUser(userId);
		if(list.isEmpty()){
			//未查询到数据
			response.setStatus(1);
			response.setMsg("未查询到数据");
		}else{
			//查询到数据
			response.setStatus(0);
			response.setMsg("查询到数据");
			response.setData(list);
		}
		return response;
	}

}
