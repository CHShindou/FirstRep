package cn.xdl.ovls.study.user.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xdl.ovls.study.course.dao.CourseMapper;
import cn.xdl.ovls.study.entity.ResponseEntity;
import cn.xdl.ovls.study.user.bean.BrowsingHistory;
import cn.xdl.ovls.study.user.dao.BrowsingHistoryMapper;
import cn.xdl.ovls.study.user.service.BrowsingHistoryService;
import cn.xdl.ovls.study.video.bean.Chapter;
import cn.xdl.ovls.study.video.bean.Video;
import cn.xdl.ovls.study.video.dao.ChapterMapper;
import cn.xdl.ovls.study.video.dao.IssueMapper;
import cn.xdl.ovls.study.video.dao.NoteMapper;
import cn.xdl.ovls.study.video.dao.VideoMapper;

@Service
public class BrowsingHistoryServiceImpl implements BrowsingHistoryService {

	@Autowired
	private BrowsingHistoryMapper browsingHistoryMapper;
	
	@Autowired
	private CourseMapper courseMapper;
	@Autowired
	private VideoMapper videoMapper;
	@Autowired
	private ChapterMapper chapterMapper;
	@Autowired
	private NoteMapper noteMapper;
	@Autowired
	private IssueMapper issueMapper;
	
	@Override
	public ResponseEntity addUserBrowCourse(String token, int videoId) {
		int userId = Integer.parseInt(token.split("_")[0]);
		//System.out.println(userId);
		Video video = videoMapper.selectByPrimaryKey(videoId);
		Chapter chapter = chapterMapper.selectByPrimaryKey(video.getChapterId());
		BrowsingHistory brow = browsingHistoryMapper.selectByUserAndCourse(userId, videoId);
		ResponseEntity response = new ResponseEntity();
		if(brow==null){
			//该条浏览记录之前并不存在,需要新增
			brow = new BrowsingHistory();
			brow.setUseId(userId);
			brow.setBrowseTime(new Date());
			brow.setCourseId(chapter.getCourseId());
			brow.setVideoId(videoId);
			browsingHistoryMapper.insert(brow);
		}else{
			//之前存在该浏览记录，更新记录
			brow.setBrowseTime(new Date());
			browsingHistoryMapper.updateByPrimaryKey(brow);
		}
		response.setStatus(0);
		response.setMsg("添加成功");
		return response;
	}

	@Override
	public ResponseEntity loadUserBrowsing(String token) {
		ResponseEntity response = new ResponseEntity();
		int userId = Integer.parseInt(token.split("_")[0]);
		List<BrowsingHistory> list = browsingHistoryMapper.selectByUser(userId);
		if(list.isEmpty()){
			//未查询到数据
			response.setStatus(1);
			response.setMsg("未查询到数据");
		}else{
			//查询到数据
			response.setStatus(0);
			response.setMsg("查询到数据");
			for(BrowsingHistory brow:list){
				//添加所在学科的详细信息
				brow.setCourse(courseMapper.selectByPrimaryKey(brow.getCourseId()));
				//添加浏览视频的详细信息
				brow.setVideo(videoMapper.selectByPrimaryKey(brow.getVideoId()));
				//添加视频所有笔记的数量
				brow.setNoteCount(noteMapper.selectCountByVideo(brow.getVideoId()));
				//添加视频所有问题的数量
				brow.setIssueCount(issueMapper.selectCountByVideo(brow.getVideoId()));
			}
			response.setData(list);
		}
		return response;
	}

}
