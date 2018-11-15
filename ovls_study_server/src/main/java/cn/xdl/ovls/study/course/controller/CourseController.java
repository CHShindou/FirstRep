package cn.xdl.ovls.study.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.xdl.ovls.study.course.service.CourseService;
import cn.xdl.ovls.study.entity.ResponseEntity;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@RequestMapping(value="/course/free",method=RequestMethod.GET)
	public ResponseEntity loadFreeCourse
		(@RequestParam(value="pagetop",required=false,defaultValue="5")int pagetop){
		return courseService.loadFreeCourse(pagetop);
	}
	
	@RequestMapping(value="/course/good",method=RequestMethod.GET)
	public ResponseEntity loadGoodCourse(
			@RequestParam(value="pagetop",required=false,defaultValue="5")int pagetop){
		return courseService.loadGoodCourse(pagetop);
	}
	
	@RequestMapping(value="/course/{id}",method=RequestMethod.GET)
	public ResponseEntity loadCourse(@PathVariable("id")int id){
		return courseService.loadCourseById(id);
	}
	
	
	@RequestMapping(value="/subject/{id}",method=RequestMethod.GET)
	public ResponseEntity loadCourseBySubjectId(@PathVariable("id")int id){
		return courseService.loadCourseBySubject(id);
	}
	
	@RequestMapping(value="/search",method=RequestMethod.GET)
	public ResponseEntity loadSearchCourses(String search_value){
		return courseService.LoadSearchCourse(search_value);
	}
}
