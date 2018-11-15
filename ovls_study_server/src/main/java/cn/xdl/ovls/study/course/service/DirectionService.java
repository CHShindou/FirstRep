package cn.xdl.ovls.study.course.service;

import cn.xdl.ovls.study.entity.ResponseEntity;

public interface DirectionService {

	/**
	 * 加载所有的方向信息，并同时加载每个方向所包含的学科和推荐课程
	 * @param 参数是显示的推荐课程的数量
	 * */
	ResponseEntity loadDirectionsAndSubjects(int pagetop);
	
	/**
	 * 通过ID查询该方向的信息
	 * */
	ResponseEntity loadDirectionById(int id);
}
