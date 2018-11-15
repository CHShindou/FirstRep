package cn.xdl.ovls.study.video.service;

import cn.xdl.ovls.study.entity.ResponseEntity;
import cn.xdl.ovls.study.video.bean.Note;

public interface NoteService {

	/**
	 * 通过学科ID加载该学科所有视屏中的笔记
	 * */
	ResponseEntity loadNoteBycourse(int courseId);
	
	/**
	 * 添加笔记
	 * */
	ResponseEntity addNote(Note note);
	
	/**
	 * 通过videoid查询笔记
	 * @param page表示显示哪一页，top表示每页显示的个数
	 * */
	ResponseEntity loadNoteByVideo(int video_id,int page,int top);
	
	
	/**
	 * 通过video和user查询笔记。并分页显示
	 * */
	ResponseEntity LoadNoteByVideoAndUser(int video_id,int user_id,int page,int top);
}
