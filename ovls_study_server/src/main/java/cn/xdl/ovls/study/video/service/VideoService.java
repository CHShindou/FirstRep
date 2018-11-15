package cn.xdl.ovls.study.video.service;

import cn.xdl.ovls.study.entity.ResponseEntity;

public interface VideoService {

	/**
	 * 通过id获取一个video的详细信息
	 * */
	ResponseEntity findVideoById(int id);
}
