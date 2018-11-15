package cn.xdl.ovls.study.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class TokenInterceptorConfig extends WebMvcConfigurerAdapter{
	
	@Autowired
	private TokenInterceptor tokenInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry){
		registry.addInterceptor(tokenInterceptor).addPathPatterns("/**");
	}
	

}
