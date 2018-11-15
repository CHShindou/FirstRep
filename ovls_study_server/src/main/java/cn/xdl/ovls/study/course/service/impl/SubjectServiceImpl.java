package cn.xdl.ovls.study.course.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xdl.ovls.study.course.bean.Subject;
import cn.xdl.ovls.study.course.dao.SubjectMapper;
import cn.xdl.ovls.study.course.service.SubjectService;
import cn.xdl.ovls.study.entity.ResponseEntity;

@Service
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	private SubjectMapper subjectMapper;
	
	@Override
	public ResponseEntity findSubjectById(int id) {
		ResponseEntity response = new ResponseEntity();
		Subject subject = subjectMapper.selectByPrimaryKey(id);
		if(subject == null){
			response.setStatus(1);
			response.setMsg("未找到数据");
		}else{
			response.setStatus(0);
			response.setMsg("找到数据");
			response.setData(subject);
		}
		return response;
	}

	@Override
	public ResponseEntity findAllSubject() {
		ResponseEntity response = new ResponseEntity();
		List<Subject> subjects = subjectMapper.selectAllSubject();
		if(subjects.isEmpty()){
			response.setStatus(1);
			response.setMsg("未找到数据");
		}else{
			response.setStatus(0);
			response.setMsg("找到数据");
			response.setData(subjects);
		}
		return response;
	}

}
