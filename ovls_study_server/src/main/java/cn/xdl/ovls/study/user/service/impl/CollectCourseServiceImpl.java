package cn.xdl.ovls.study.user.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.xdl.ovls.study.entity.ResponseEntity;
import cn.xdl.ovls.study.user.bean.CollectCourse;
import cn.xdl.ovls.study.user.dao.CollectCourseMapper;
import cn.xdl.ovls.study.user.service.CollectCourseService;

@Service
public class CollectCourseServiceImpl implements CollectCourseService {

	@Autowired
	private CollectCourseMapper collectCourseMapper;
	
	@Override
	public ResponseEntity checkCollectCourseByUserAndCourse(int userId, int courseId) {
		ResponseEntity response = new ResponseEntity();
		CollectCourse collect = collectCourseMapper.selectByUserAndCourse(userId, courseId);
		if(collect == null){
			//未查询到数据  此课程未被收藏
			response.setStatus(1);
			response.setMsg("此课程未被收藏");
		}else{
			//查询到数据，此课程已被收藏
			response.setStatus(0);
			response.setMsg("此课程已被收藏");
		}
		return response;
	}

	@Override
	public ResponseEntity addCollectCourse(int courseId, String token) {
		ResponseEntity response = new ResponseEntity();
		int userId = Integer.parseInt(token.split("_")[0]);
		CollectCourse collect = new CollectCourse();
		collect.setUserId(userId);
		collect.setCourseId(courseId);
		collect.setCollectTime(new Date());
		int i = collectCourseMapper.insert(collect);
		if(i>0){
			//添加成功
			response.setStatus(0);
			response.setMsg("收藏成功");
		}else{
			//添加失败
			response.setStatus(1);
			response.setMsg("收藏失败");
		}
		return response;
	}

	@Override
	public ResponseEntity loadCollectCourse(int userId, int page, int top) {
		ResponseEntity response = new ResponseEntity();
		PageHelper.startPage(page, top);
		List<CollectCourse> list = collectCourseMapper.selectByUser(userId);
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

	@Override
	public ResponseEntity deleteCollectByUserAndCourse(String token, int courseId) {
		int userId = Integer.parseInt(token.split("_")[0]);
		ResponseEntity response = new ResponseEntity();
		int i = collectCourseMapper.deleteByCourseAndUser(userId, courseId);
		if(i>0){
			//删除成功
			response.setStatus(0);
			response.setMsg("取消收藏成功");
		}else{
			//删除失败
			response.setStatus(1);
			response.setMsg("取消收藏失败");
		}
		return response;
	}

}
