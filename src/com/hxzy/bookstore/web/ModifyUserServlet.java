package com.hxzy.bookstore.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.hxzy.bookstore.domain.User;
import com.hxzy.bookstore.serivice.impl.UserServiceImpl;
import com.hxzy.bookstore.service.UserService;

public class ModifyUserServlet extends HttpServlet{
	

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		//获取页面的数据
		User user=new User();
		try {
			BeanUtils.populate(user, request.getParameterMap());
			//调用业务层进行修改
			UserService userService =new UserServiceImpl();
			userService.modifyUser(user);
			//重新登陆
			//注销用户
			request.getSession().invalidate();
			response.sendRedirect(request.getContextPath()+"/modifyUserInfoSuccess.jsp");
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		
	}
	
	
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 
	
	}
   
   
  
}
