package cn.xdl.ovls.study.course.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.xdl.ovls.study.course.bean.Course;
import cn.xdl.ovls.study.course.bean.Direction;
import cn.xdl.ovls.study.course.dao.CourseMapper;
import cn.xdl.ovls.study.course.dao.DirectionMapper;
import cn.xdl.ovls.study.course.service.DirectionService;
import cn.xdl.ovls.study.entity.ResponseEntity;

@Service
public class DirectionServiceImpl implements DirectionService {

	@Autowired
	private DirectionMapper directionMapper;
	
	@Autowired
	private CourseMapper courseMapper;
	
	@Override
	public ResponseEntity loadDirectionsAndSubjects(int pagetop) {
		List<Direction> directions = directionMapper.selectAllJoinSubject();
		ResponseEntity response = new ResponseEntity();
		if(directions.isEmpty()){
			response.setStatus(1);
			response.setMsg("未查到数据");
		}else{
			for(Direction d:directions){
				//通过方向id查找course表，并取出前pagetop条数据传给Direction结果集中
				PageHelper.startPage(1, pagetop);
				List<Course> courses = courseMapper.selectByDirectionId(d.getId());
				d.setCourses(courses);
			}
			response.setStatus(0);
			response.setMsg("查询到数据");
			response.setData(directions);
		}
		return response;
	}

	@Override
	public ResponseEntity loadDirectionById(int id) {
		ResponseEntity response = new ResponseEntity();
		Direction direction = directionMapper.selectByPrimaryKey(id);
		if(direction == null){
			response.setStatus(1);
			response.setMsg("未找到数据");
		}else{
			response.setStatus(0);
			response.setMsg("找到数据");
			response.setData(direction);
		}
		return response;
	}

}
