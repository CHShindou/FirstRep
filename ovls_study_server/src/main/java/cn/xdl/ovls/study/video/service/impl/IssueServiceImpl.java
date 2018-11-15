package cn.xdl.ovls.study.video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.xdl.ovls.study.entity.ResponseEntity;
import cn.xdl.ovls.study.video.bean.Issue;
import cn.xdl.ovls.study.video.dao.IssueMapper;
import cn.xdl.ovls.study.video.service.IssueService;

@Service
public class IssueServiceImpl implements IssueService {

	@Autowired
	private IssueMapper issueMapper;
	
	@Override
	public ResponseEntity addIssue(Issue issue) {
		ResponseEntity response = new ResponseEntity();
		int i = issueMapper.insert(issue);
		if(i>0){
			response.setStatus(0);
			response.setMsg("提问成功");
			response.setData(issue);
		}else{
			response.setStatus(1);
			response.setMsg("提问失败");
		}
		return response;
	}

	@Override
	public ResponseEntity loadIssueByVideo(int video_id, int page, int top) {
		ResponseEntity response = new ResponseEntity();
		int count = issueMapper.selectCountByVideo(video_id);
		if(count>0){
			//查询到数据
			//计算总共需要显示的页数
			int pages = count/top;
			if(count%top != 0){
				pages ++;
			}
			PageHelper.startPage(page, top);
			List<Issue> list = issueMapper.selectByVideo(video_id);
			response.setStatus(0);
			response.setMsg(pages+"");
			response.setData(list);
		}else{
			//无数据
			response.setStatus(1);
			response.setMsg("未查询到数据");
		}
		return response;
	}

}
