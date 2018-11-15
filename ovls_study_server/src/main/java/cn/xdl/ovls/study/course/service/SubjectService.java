package cn.xdl.ovls.study.course.service;

import cn.xdl.ovls.study.entity.ResponseEntity;

public interface SubjectService {

	/**
	 * 通过id查询学科信息
	 * */
	ResponseEntity findSubjectById(int id);
	
	
	/**
	 * 查询所有的学科
	 * */
	ResponseEntity findAllSubject();
}
