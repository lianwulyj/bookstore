package com.hxzy.bookstore.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hxzy.bookstore.domain.User;
import com.hxzy.bookstore.serivice.impl.UserServiceImpl;
import com.hxzy.bookstore.service.UserService;

public class FindUserById extends HttpServlet{
	
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   //1通过页面获取的Id
	   String userid=req.getParameter("id");
	   //2id到数据库查询用户信息
	   UserServiceImpl userService =new UserServiceImpl();
	   User user= userService.findUserById(userid);
	   //3显示用户信息 
	   req.setAttribute("u", user);
	   req.getRequestDispatcher("/modifyuserinfo.jsp").forward(req,resp);
	
	}
   
   
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		
	}
  
}
