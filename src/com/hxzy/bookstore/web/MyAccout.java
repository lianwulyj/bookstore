package com.hxzy.bookstore.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hxzy.bookstore.domain.User;
import com.hxzy.bookstore.serivice.impl.UserServiceImpl;
import com.hxzy.bookstore.service.UserService;

public class MyAccout extends HttpServlet{
	
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	//从sesssion获取对象
    	User user=(User)req.getSession().getAttribute("user");
    	//对象不为空,跳到用户帐户界面
    	if(user!=null){
    		req.getRequestDispatcher("/myAccount.jsp").forward(req,resp);
    	}else{
    		
    		resp.sendRedirect(req.getContextPath()+"/login.jsp");
    	}
    	//对象为空,没有登录,跳到登录页面
	}
   
   
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
  
}
