package cn.xdl.ovls.study.video.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xdl.ovls.study.entity.ResponseEntity;
import cn.xdl.ovls.study.video.bean.Video;
import cn.xdl.ovls.study.video.dao.VideoMapper;
import cn.xdl.ovls.study.video.service.VideoService;


@Service
public class VideoServiceImpl implements VideoService {

	@Autowired
	private VideoMapper videoMapper;
	
	@Override
	public ResponseEntity findVideoById(int id) {
		Video video = videoMapper.selectByPrimaryKey(id);
		ResponseEntity response = new ResponseEntity();
		if(video == null){
			response.setStatus(1);
			response.setMsg("未查询到数据");
		}else{
			response.setStatus(0);
			response.setMsg("查询到数据");
			response.setData(video);
		}
		return response;
	}

}
