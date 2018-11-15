package cn.xdl.ovls.study.user.service;

import cn.xdl.ovls.study.entity.ResponseEntity;
import cn.xdl.ovls.study.user.bean.CollectNote;

public interface CollectNoteService {

	/**
	 * 添加一条用户收藏信息
	 * */
	ResponseEntity addCollectNote(CollectNote record);
	
	/**
	 * 通过userId查找一组笔记收藏数据(不包含笔记和视频详情)
	 * */
	ResponseEntity loadCollectNoteByUser(int userId);
	
	/**
	 * 通过userId查找一组笔记收藏详情(包含了笔记和视频详情)
	 * 
	 * */
	ResponseEntity loadAllCollectNoteByUser(int userId);
}
