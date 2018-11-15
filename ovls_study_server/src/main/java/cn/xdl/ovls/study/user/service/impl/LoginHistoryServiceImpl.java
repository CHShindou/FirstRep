package cn.xdl.ovls.study.user.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.xdl.ovls.study.entity.ResponseEntity;
import cn.xdl.ovls.study.user.bean.LoginHistory;
import cn.xdl.ovls.study.user.dao.LoginHistoryMapper;
import cn.xdl.ovls.study.user.service.LoginHistoryService;
import cn.xdl.ovls.study.util.AddressUtil;

@Service
public class LoginHistoryServiceImpl implements LoginHistoryService {

	@Autowired
	private LoginHistoryMapper loginMapper;
	
	@Override
	public void addLoginHistory(LoginHistory record) {
		//添加登录时间
		record.setLoginTime(new Date());
		//添加当前登录的ip
		String ip = record.getIp();
		//使用ipUtil获取该ip对应的地址
		try {
			String address = AddressUtil.getAddresses("ip="+ip, "utf-8");
			JSONObject json = new JSONObject(address);
			//System.out.println(address);
			String country = (new JSONObject(json.get("data").toString())).get("country").toString();
			String region = (new JSONObject(json.get("data").toString())).get("region").toString();
			String city = (new JSONObject(json.get("data").toString())).get("city").toString();
			//地址格式为  国家-省份-城市
			record.setCity(country+"-"+region+"-"+city);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loginMapper.insert(record);
	}

	@Override
	public ResponseEntity loadLoginHistory(int user_id) {
		ResponseEntity response = new ResponseEntity();
		PageHelper.startPage(1, 10);
		List<LoginHistory> list = loginMapper.selectByUser(user_id);
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
