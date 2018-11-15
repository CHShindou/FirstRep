package cn.xdl.ovls.study.course.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.xdl.ovls.study.course.bean.Course;
import cn.xdl.ovls.study.course.dao.CourseMapper;
import cn.xdl.ovls.study.course.dao.DirectionMapper;
import cn.xdl.ovls.study.course.dao.SubjectMapper;
import cn.xdl.ovls.study.course.service.CourseService;
import cn.xdl.ovls.study.entity.ResponseEntity;


@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseMapper courseMapper;
	
	@Autowired
	private SubjectMapper subjectMapper;
	@Autowired
	private DirectionMapper directionMapper;

	@Override
	public ResponseEntity loadFreeCourse(int pagetop) {
		//分页查询，取出所有数据的前pagetop个用于展示
		PageHelper.startPage(1, pagetop);
		List<Course> list = courseMapper.selectByPrice();
		ResponseEntity response = new ResponseEntity();
		if(list.isEmpty()){
			response.setStatus(1);
			response.setMsg("未找到记录");
		}else{
			response.setStatus(0);
			response.setMsg("找到记录");
			response.setData(list);
		}
		return response;
	}

	@Override
	public ResponseEntity loadGoodCourse(int pagetop) {
		//分页查询，取出所有数据的前pagetop个用于展示
		PageHelper.startPage(1, pagetop);
		List<Course> list = courseMapper.selectOrderByScore();
		ResponseEntity response = new ResponseEntity();
		if(list.isEmpty()){
			response.setStatus(1);
			response.setMsg("未找到记录");
		}else{
			response.setStatus(0);
			response.setMsg("找到记录");
			response.setData(list);
		}
		return response;
	}

	@Override
	public ResponseEntity loadCourseById(int id) {
		Course course = courseMapper.selectByPrimaryKey(id);
		ResponseEntity response = new ResponseEntity();
		if(course==null){
			response.setStatus(1);
			response.setMsg("未找到记录");
		}else{
			course.setDirection(directionMapper.selectByPrimaryKey(course.getDirectionId()));
			course.setSubject(subjectMapper.selectByPrimaryKey(course.getSubjectId()));
			response.setStatus(0);
			response.setMsg("找到记录");
			response.setData(course);
		}
		return response;
	}

	@Override
	public ResponseEntity loadCourseBySubject(int subject_id) {
		ResponseEntity response = new ResponseEntity();
		List<Course> list = courseMapper.selectBySubjectId(subject_id);
		if(list.isEmpty()){
			response.setStatus(1);
			response.setMsg("未找到记录");
		}else{
			response.setStatus(0);
			response.setMsg("找到记录");
			response.setData(list);
		}
		return response;
	}

	@Override
	public ResponseEntity LoadSearchCourse(String search) {
		ResponseEntity response = new ResponseEntity();
		List<Course> courses = courseMapper.searchByNameOrIntro("%"+search+"%");
		if(courses.isEmpty()){
			//未查询到数据
			response.setStatus(1);
			response.setMsg("未找到记录");
		}else{
			//查询到数据
			response.setStatus(0);
			response.setMsg("找到记录");
			response.setData(courses);
		}
		return response;
	}

}
