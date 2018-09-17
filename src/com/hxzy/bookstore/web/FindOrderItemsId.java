package com.hxzy.bookstore.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hxzy.bookstore.domain.Order;
import com.hxzy.bookstore.serivice.impl.OrderServiceImpl;
import com.hxzy.bookstore.serivice.impl.UserServiceImpl;
import com.hxzy.bookstore.service.OrderService;
import com.hxzy.bookstore.service.UserService;

public class FindOrderItemsId extends HttpServlet{
	
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
    	 //获取订单id
    	String id=req.getParameter("orderid");
    	 //查询订单
    	OrderService o=new OrderServiceImpl();
    	Order order=o.findOrdersByOrderId(id);
    	req.setAttribute("order", order);
    	req.getRequestDispatcher("/orderInfo.jsp").forward(req, resp);
    
	}
   
   
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		
	}
  
}
