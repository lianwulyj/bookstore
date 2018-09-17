package com.hxzy.bookstore.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hxzy.bookstore.domain.Product;
import com.hxzy.bookstore.domain.User;
import com.hxzy.bookstore.serivice.impl.ProductServiceImpl;
import com.hxzy.bookstore.serivice.impl.UserServiceImpl;
import com.hxzy.bookstore.service.ProductService;
import com.hxzy.bookstore.service.UserService;

public class FindBookInfoServlet extends HttpServlet{
	
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 //第一步获取id
     String id=req.getParameter("id");
    	
     //通过id得到product
     ProductService productService=new ProductServiceImpl();
     Product product=  productService.findBookById(id);
     //放到request,页面
	 req.setAttribute("book", product);
	 req.getRequestDispatcher("/product_info.jsp").forward(req, resp);
	}
   
   
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		
	}
  
}
