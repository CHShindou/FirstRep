package cn.xdl.ovls.study.video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.xdl.ovls.study.entity.ResponseEntity;
import cn.xdl.ovls.study.video.bean.Evaluate;
import cn.xdl.ovls.study.video.dao.EvaluateMapper;
import cn.xdl.ovls.study.video.service.EvaluateService;

@Service
public class EvaluateServiceImpl implements EvaluateService {

	@Autowired
	private EvaluateMapper evaluateMapper;
	
	@Override
	public ResponseEntity loadEvaluateForCourse(int courseId,int page,int top) {
		ResponseEntity response = new ResponseEntity();
		PageHelper.startPage(page, top);
		List<Evaluate> list = evaluateMapper.selectByCourse(courseId);
		if(list.isEmpty()){
			//未找到数据
			response.setStatus(1);
			response.setMsg("未找到数据");
		}else{
			//找到数据
			response.setStatus(0);
			response.setMsg("找到数据");
			response.setData(list);
		}
		return response;
	}

	@Override
	public ResponseEntity addEvaluate(Evaluate eval) {
		ResponseEntity response = new ResponseEntity();
		int i = evaluateMapper.insert(eval);
		if(i>0){
			response.setStatus(0);
			response.setMsg("评论成功");
			response.setData(eval);
		}else{
			response.setStatus(1);
			response.setMsg("评论失败");
		}
		return response;
	}

	@Override
	public ResponseEntity loadEvaluateByVideo(int video_id,int page,int top) {
		ResponseEntity response = new ResponseEntity();
		//获取所有的评论信息
		List<Evaluate> lists = evaluateMapper.selectByVideo(video_id);
		if(lists.isEmpty()){
			response.setStatus(1);
			response.setMsg("未找到数据");
		}else{
			int pages = 1;
			if(lists.size()%top == 0){
				pages = lists.size()/top;
			}else{
				pages = lists.size()/top + 1;
			}
			PageHelper.startPage(page, top);
			lists = evaluateMapper.selectByVideo(video_id);
			response.setStatus(0);
			response.setMsg(pages+"");
			response.setData(lists);
		}
		return response;
	}

}
