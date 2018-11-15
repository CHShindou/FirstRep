package cn.xdl.ovls.study.user.service;

import cn.xdl.ovls.study.entity.ResponseEntity;
import cn.xdl.ovls.study.user.bean.NoteLike;

public interface NoteLikeService {
	
	/**
	 * 添加一条笔记点赞信息
	 * */
	ResponseEntity addNoteLike(NoteLike record);
	
	/**
	 * 通过user 查找一组笔记点赞信息
	 * */
	ResponseEntity loadNoteLikeByUser(int user_id);

}
