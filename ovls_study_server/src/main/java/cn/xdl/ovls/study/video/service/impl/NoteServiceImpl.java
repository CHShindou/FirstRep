package cn.xdl.ovls.study.video.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import cn.xdl.ovls.study.entity.ResponseEntity;
import cn.xdl.ovls.study.video.bean.Note;
import cn.xdl.ovls.study.video.dao.NoteMapper;
import cn.xdl.ovls.study.video.service.NoteService;


@Service
public class NoteServiceImpl implements NoteService {

	@Autowired
	private NoteMapper noteMapper;
	@Autowired
	private RedisTemplate<Object,Object> redisTemplate;
	
	@Override
	public ResponseEntity loadNoteBycourse(int courseId) {
		ResponseEntity response = new ResponseEntity();
		List<Note> list = noteMapper.selectByCourse(courseId);
		if(list.isEmpty()){
			//未找到数据
			response.setStatus(1);
			response.setMsg("未查询到数据");
		}else{
			response.setStatus(0);
			response.setMsg("查询到数据");
			response.setData(list);
		}
		return response;
	}


	@Override
	public ResponseEntity addNote(Note note) {
		ResponseEntity response = new ResponseEntity();
		noteMapper.insert(note);
		response.setStatus(0);
		response.setMsg("笔记添加成功");
		response.setData(note);
		//每次添加笔记之后 都清空一下redis中的笔记信息
		redisTemplate.delete(note.getVideoId()+"_note");
		redisTemplate.delete(note.getVideoId()+"_"+note.getUserId()+"_note");
		return response;
	}


	@Override
	public ResponseEntity loadNoteByVideo(int video_id,int page,int top) {
		ResponseEntity response = new ResponseEntity();
		List<Note> list = (List<Note>) redisTemplate.opsForValue().get(video_id+"_note");
		if(list==null){
			list = noteMapper.selectByVideo(video_id);
			if(list.isEmpty()){
				response.setStatus(1);
				response.setMsg("未查询到数据");
				return response;
			}else{
				redisTemplate.opsForValue().set(video_id+"_note", list, 1800, TimeUnit.SECONDS);
			}
		}
		//截取需要显示的数据
		int i = (page-1)*top;
		List<Note> notes = new ArrayList<Note>();
		for(int j=0;j<top;j++){
			try{
				notes.add(list.get(i+j));
			}catch(Exception e){
				//不处理,结束循环
				//System.out.println("Index异常");
				break;
			}
		}
		int pages = list.size()/top;
		if(list.size()%top != 0){
			pages = pages+1;
		}
		response.setStatus(0);
		response.setMsg(pages+"");
		response.setData(notes);
		return response;
	}


	@Override
	public ResponseEntity LoadNoteByVideoAndUser(int video_id, int user_id, int page, int top) {
		ResponseEntity response = new ResponseEntity();
		List<Note> list = (List<Note>) redisTemplate.opsForValue().get(video_id+"_"+user_id+"_note");
		if(list==null){
			list = noteMapper.selectByVideoAndUser(video_id, user_id);
			if(list.isEmpty()){
				response.setStatus(1);
				response.setMsg("未查询到数据");
				return response;
			}else{
				redisTemplate.opsForValue().set(video_id+"_"+user_id+"_note", list, 1800, TimeUnit.SECONDS);
			}
		}
		//截取需要显示的数据
		int i = (page-1)*top;
		List<Note> notes = new ArrayList<Note>();
		for(int j=0;j<top;j++){
			try{
				notes.add(list.get(i+j));
			}catch(Exception e){
				//不处理,结束循环
				//System.out.println("Index异常");
				break;
			}
		}
		int pages = list.size()/top;
		if(list.size()%top != 0){
			pages = pages+1;
		}
		response.setStatus(0);
		response.setMsg(pages+"");
		response.setData(notes);
		return response;
	}


}
