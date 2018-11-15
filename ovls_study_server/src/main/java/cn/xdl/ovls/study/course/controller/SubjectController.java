package cn.xdl.ovls.study.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.xdl.ovls.study.course.service.SubjectService;
import cn.xdl.ovls.study.entity.ResponseEntity;

@RestController
public class SubjectController {

	@Autowired
	private SubjectService subjectService;
	
	@RequestMapping(value="/subjectname/{id}",method=RequestMethod.GET)
	public ResponseEntity findSubject(@PathVariable("id")int id){
		return subjectService.findSubjectById(id);
	}
	
	@RequestMapping(value="/subject",method=RequestMethod.GET)
	public ResponseEntity findAllSubjects(){
		return subjectService.findAllSubject();
	}
}
