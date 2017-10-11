package com.zhiyou100.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhiyou100.vo.ResponseVo;

public class LoginsFilter extends HandlerInterceptorAdapter {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		
		Object telephone = session.getAttribute("telephone");
		
		if (telephone == null) {
			
			ResponseVo<String> vo = new ResponseVo<String>(-1000,"你需要登录",null);
			
			ObjectMapper om = new ObjectMapper();
			
			String json = om.writeValueAsString(vo);
			
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().print(json);
			
			return false;
		}else {
			
		}
		
		// true 放行，false 打回去
		return true;
	}

}
