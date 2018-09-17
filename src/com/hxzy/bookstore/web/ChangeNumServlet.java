package com.hxzy.bookstore.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.hxzy.bookstore.domain.Product;
import com.hxzy.bookstore.domain.User;
import com.hxzy.bookstore.serivice.impl.ProductServiceImpl;
import com.hxzy.bookstore.serivice.impl.UserServiceImpl;
import com.hxzy.bookstore.service.ProductService;
import com.hxzy.bookstore.service.UserService;

public class ChangeNumServlet extends HttpServlet{
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		 doPost(request,response);
	}
	
   
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//获取 id num
    	String id=request.getParameter("id");
    	String num=request.getParameter("num");
    	Product p=new Product();
    	p.setId(id);
    	
    	HttpSession session=request.getSession();
    	Map<Product,String> map1=(Map<Product,String>)session.getAttribute("map");
    	if("0".equals(num)){
    		map1.remove(p);
    	}
    	if(map1.containsKey(p)){
    		map1.put(p, num);
    	}
    	response.sendRedirect(request.getContextPath()+"/cart.jsp");
    	
    	
    	
    }
}
