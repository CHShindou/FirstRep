package cn.xdl.ovls.study.util;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class TokenInterceptor implements HandlerInterceptor{
	
	@Autowired
	private TokenManager tokenManager;

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(
			HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		//判断方法前是否存在@Authorization标记
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		Method method = handlerMethod.getMethod();
		Authorization author = method.getAnnotation(Authorization.class);
		if(author==null){
			//没有@Authorization标记，直接放行不检查
			return true;
		}
		//没有标记，需要检查
		String token = request.getParameter("access_token");
		//System.out.println(token);
		if(token != null){
			//token的格式需要是userid_uuid
			boolean ok = tokenManager.checkToken(token);
			if(ok){
				//检测通过，放行
				return true;
			}
		}
		
		response.setContentType("application/json;charset=UTF-8");
		response.setStatus(200);
		response.getWriter().write("{\"status\":100,\"msg\":\"未获得权限\"}");
		return false;
	}

}
