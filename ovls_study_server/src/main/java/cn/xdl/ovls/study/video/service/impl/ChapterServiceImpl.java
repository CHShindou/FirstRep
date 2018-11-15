package cn.xdl.ovls.study.video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xdl.ovls.study.entity.ResponseEntity;
import cn.xdl.ovls.study.video.bean.Chapter;
import cn.xdl.ovls.study.video.dao.ChapterMapper;
import cn.xdl.ovls.study.video.service.ChapterService;

@Service
public class ChapterServiceImpl implements ChapterService {
	@Autowired
	private ChapterMapper chapterMapper;

	@Override
	public ResponseEntity loadChapterAndVideo(int id) {
		List<Chapter> chapters = chapterMapper.selectByCourseId(id);
		ResponseEntity response = new ResponseEntity();
		if(chapters.isEmpty()){
			response.setStatus(1);
			response.setMsg("未查询到数据");
		}else{
			response.setStatus(0);
			response.setMsg("查询到数据");
			response.setData(chapters);
		}
		return response;
	}

}
