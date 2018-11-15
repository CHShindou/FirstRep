package cn.xdl.ovls.study.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xdl.ovls.study.entity.ResponseEntity;
import cn.xdl.ovls.study.user.bean.NoteLike;
import cn.xdl.ovls.study.user.dao.NoteLikeMapper;
import cn.xdl.ovls.study.user.service.NoteLikeService;
import cn.xdl.ovls.study.video.bean.Note;
import cn.xdl.ovls.study.video.dao.NoteMapper;

@Service
public class NoteLikeServiceImpl implements NoteLikeService {
	
	@Autowired
	private NoteLikeMapper noteLikeMapper;
	@Autowired
	private NoteMapper noteMapper;

	@Override
	public ResponseEntity addNoteLike(NoteLike record) {
		ResponseEntity response = new ResponseEntity();
		int i = noteLikeMapper.insert(record);
		if(i>0){
			//添加成功
			response.setStatus(0);
			response.setMsg("点赞成功");
			//将note表中的like数据+1
			Note note = noteMapper.selectByPrimaryKey(record.getNoteId());
			note.setLikeCount(note.getLikeCount()+1);
			noteMapper.updateByPrimaryKey(note);
		}else{
			//添加失败
			response.setStatus(1);
			response.setMsg("点赞失败");
		}
		return response;
	}

	@Override
	public ResponseEntity loadNoteLikeByUser(int user_id) {
		ResponseEntity response = new ResponseEntity();
		List<NoteLike> list = noteLikeMapper.selectByUser(user_id);
		if(list.isEmpty()){
			//未查询到数据
			response.setStatus(1);
			response.setMsg("未查询到数据");
		}else{
			//查询到数据
			response.setStatus(0);
			response.setMsg("查询到数据");
			response.setData(list);
		}
		return response;
	}

}
