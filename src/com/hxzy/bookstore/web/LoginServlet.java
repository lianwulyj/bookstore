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

public class LoginServlet extends HttpServlet{
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
	    //获取用户名 密码
		String username=request.getParameter("username");
		String password=request.getParameter("password");
	    //用户名和密码数据查询
		UserService userService=new UserServiceImpl();
		User user=userService.findUserByUserNameAndPassWord(username, password);
		request.getSession().setAttribute("user", user);
		try {
			request.getRequestDispatcher("/index.jsp").forward(request,response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//用户为空 用户名和密码错误
		//用户不为空,state为0,用户伟激活
		
	
	}
	
   
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	 doPost(req,resp);
    }
}
