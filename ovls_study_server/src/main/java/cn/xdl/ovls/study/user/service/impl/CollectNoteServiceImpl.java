package cn.xdl.ovls.study.user.service.impl;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import cn.xdl.ovls.study.entity.ResponseEntity;
import cn.xdl.ovls.study.user.bean.CollectNote;
import cn.xdl.ovls.study.user.dao.CollectNoteMapper;
import cn.xdl.ovls.study.user.service.CollectNoteService;
import cn.xdl.ovls.study.util.Constants;

@Service
public class CollectNoteServiceImpl implements CollectNoteService {
	
	@Autowired
	private CollectNoteMapper collectNoteMapper;
	
	@Autowired
	private RedisTemplate<Object, Object> redisTemplate;

	@Override
	public ResponseEntity addCollectNote(CollectNote record) {
		ResponseEntity response = new ResponseEntity();
		int i = collectNoteMapper.insert(record);
		//有数据改动的话，redis中的数据也需要修改，这里采用直接删除redis缓存的方式
		redisTemplate.delete(record.getUserId()+"_collectNote");
		if(i>0){
			response.setStatus(0);
			response.setMsg("收藏成功");
		}else{
			response.setStatus(1);
			response.setMsg("收藏失败");
		}
		return response;
	}

	@Override
	public ResponseEntity loadCollectNoteByUser(int userId) {
		ResponseEntity response = new ResponseEntity();
		List<CollectNote> list = collectNoteMapper.selectByUser(userId);
		if(list.isEmpty()){
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
	public ResponseEntity loadAllCollectNoteByUser(int userId) {
		ResponseEntity response = new ResponseEntity();
		//从redis中读取笔记收藏信息
		String key = userId+"_collectNote";
		List<CollectNote> list = (List<CollectNote>) redisTemplate.opsForValue().get(key);
		if(list==null){
			//redis中不存在,从数据库中读取
			list = collectNoteMapper.selectAllByUser(userId);
			if(list.isEmpty()){
				//未查询到数据
				response.setStatus(1);
				response.setMsg("未查询到数据");
				return response;
			}else{
				//查询到数据
				//将数据存入redis中
				redisTemplate.opsForValue().set(key, list, Constants.TOKEN_EXPRIE_HOUR, TimeUnit.HOURS);
			}
		}
		response.setStatus(0);
		response.setMsg("查询到数据");
		response.setData(list);
		return response;
	}

}
