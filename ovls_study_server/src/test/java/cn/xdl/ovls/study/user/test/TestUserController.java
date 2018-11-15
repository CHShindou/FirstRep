package cn.xdl.ovls.study.user.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import cn.xdl.ovls.study.OvlsStudyServerApplication;
import cn.xdl.ovls.study.user.controller.UserController;


@RunWith(SpringRunner.class)
@SpringBootTest(classes={OvlsStudyServerApplication.class})
@WebAppConfiguration   //启动tomcat
public class TestUserController {
	
	@Autowired
	private UserController userController;
	

	
	@Test
	public void test1() throws Exception{
		MockMvc mockMvc = 
				MockMvcBuilders.standaloneSetup(userController).build();
		//创建一个post请求
		MockHttpServletRequestBuilder postRequest = MockMvcRequestBuilders.post("/user/token")
		.param("username", "scott")
		.param("password", "123");
		//发送请求
		MvcResult result = mockMvc.perform(postRequest).andReturn();
		//获取返回结果内容
		String body = result.getResponse().getContentAsString();
		System.out.println(body);
	}
	

}
