package com.hxzy.bookstore.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hxzy.bookstore.domain.PageBean;
import com.hxzy.bookstore.serivice.impl.ProductServiceImpl;
import com.hxzy.bookstore.serivice.impl.UserServiceImpl;
import com.hxzy.bookstore.service.ProductService;
import com.hxzy.bookstore.service.UserService;

public class PageServlet extends HttpServlet{
	
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	  String category= req.getParameter("category");
	  if(category==null){
		  category="";
	  }
	  //每页显示的记录数
	  int pageSize=4;
	  int currentPage=1;//当前页
	  //从上一页或下一页得到的数据
	  String currPage=req.getParameter("currentPage");//currentPage=1 currentPage=2
	  //调用服务层方法进行查询
	  if(currPage!=null&&!"".equals(currPage)){
		  currentPage=Integer.parseInt(currPage);
	  }
		  
      ProductService productService=new ProductServiceImpl();
      try {
		PageBean pb= productService.findBooksPage(currentPage, pageSize, category);
		
		req.setAttribute("pb", pb);
		req.getRequestDispatcher("/product_list.jsp").forward(req, resp);
	  } catch (Exception e) {
		e.printStackTrace();
	}
	 
	  
	  
	   
	}
   
   
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		
	}
  
}
