package com.hxzy.bookstore.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hxzy.bookstore.serivice.impl.UserServiceImpl;
import com.hxzy.bookstore.service.UserService;

public class ActiveServlet extends HttpServlet{
	
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
	   String activeCode=req.getParameter("activeCode");   
	   UserService userService=new UserServiceImpl();
	   userService.activeUser(activeCode);
	}
   
   
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		
	}
  
}
