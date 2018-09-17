package com.hxzy.bookstore.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hxzy.bookstore.domain.Order;
import com.hxzy.bookstore.domain.User;
import com.hxzy.bookstore.serivice.impl.OrderServiceImpl;
import com.hxzy.bookstore.serivice.impl.UserServiceImpl;
import com.hxzy.bookstore.service.OrderService;
import com.hxzy.bookstore.service.UserService;

public class FindOrderByUserId extends HttpServlet{
	
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 //获取id
      User user=(User)req.getSession().getAttribute("user");
     //调用业务层方法进行查询
      OrderService os=new OrderServiceImpl();
      List<Order> orders=os.findOrdersByUserId(user.getId());
      req.setAttribute("orders", orders);
      req.setAttribute("count", orders.size());
      
      req.getRequestDispatcher("/orderlist.jsp").forward(req, resp);
    	
    	
	}
   
   
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		
	}
  
}
