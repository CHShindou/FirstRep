package cn.xdl.ovls.study.video.service;

import cn.xdl.ovls.study.entity.ResponseEntity;

public interface ChapterService {

	/**
	 * 通过课程ID加载章节信息，并加载该章节包含的视频信息
	 * */
	ResponseEntity loadChapterAndVideo(int id);
}
