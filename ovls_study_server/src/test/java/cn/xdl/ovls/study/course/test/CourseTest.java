package cn.xdl.ovls.study.course.test;

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
import cn.xdl.ovls.study.course.controller.CourseController;
import cn.xdl.ovls.study.course.controller.DirectionController;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={OvlsStudyServerApplication.class})
@WebAppConfiguration
public class CourseTest {

	@Autowired
	private CourseController courseController;
	
	@Autowired
	private DirectionController directionController;
	
	@Test
	public void test1() throws Exception{
		MockMvc mockMvc = 
				MockMvcBuilders.standaloneSetup(courseController).build();
		//创建一个post请求
		MockHttpServletRequestBuilder postRequest = MockMvcRequestBuilders.get("/course/free")
		.param("pagetop", "5");
		//发送请求
		MvcResult result = mockMvc.perform(postRequest).andReturn();
		//获取返回结果内容
		String body = result.getResponse().getContentAsString();
		System.out.println(body);
	}
	
	@Test
	public void test2() throws Exception{
		MockMvc mockMvc = 
				MockMvcBuilders.standaloneSetup(directionController).build();
		//创建一个post请求
		MockHttpServletRequestBuilder postRequest = MockMvcRequestBuilders.get("/course/direction")
		.param("pagetop", "3");
		//发送请求
		MvcResult result = mockMvc.perform(postRequest).andReturn();
		//获取返回结果内容
		String body = result.getResponse().getContentAsString();
		System.out.println(body);
	}
}
