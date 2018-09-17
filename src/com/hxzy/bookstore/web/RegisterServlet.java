package com.hxzy.bookstore.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.hxzy.bookstore.domain.User;
import com.hxzy.bookstore.serivice.impl.UserServiceImpl;
import com.hxzy.bookstore.service.UserService;

public class RegisterServlet extends HttpServlet{
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
	 
		User user=new User();
	    try {
		BeanUtils.populate(user, request.getParameterMap());
		user.setActivecode(UUID.randomUUID().toString());
		//调用业务逻辑 服务层 注册方法
		UserService userService =new UserServiceImpl();
		userService.regist(user);
		//
		//request.getSession().setAttribute("user1", user);
		request.getRequestDispatcher("/registersuccess.jsp").forward(request,response);
		} catch (Exception e) {
		  e.printStackTrace();
		}
		
	}
	
     @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	 doPost(req,resp);
    }
}
