package cn.xdl.ovls.study.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.xdl.ovls.study.course.service.DirectionService;
import cn.xdl.ovls.study.entity.ResponseEntity;

@RestController
public class DirectionController {

	@Autowired
	private DirectionService directionService;
	
	@RequestMapping(value="/course/direction",method=RequestMethod.GET)
	public ResponseEntity loadDirections(
			@RequestParam(value="pagetop",required=false,defaultValue="3")int pagetop){
		return directionService.loadDirectionsAndSubjects(pagetop);
	}
	
	@RequestMapping(value="/directionName/{id}",method=RequestMethod.GET)
	public ResponseEntity loadDirectionById(@PathVariable("id")int id){
		return directionService.loadDirectionById(id);
	}
}
