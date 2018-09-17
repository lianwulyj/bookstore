package com.hxzy.bookstore.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.hxzy.bookstore.domain.Order;
import com.hxzy.bookstore.domain.OrderItem;
import com.hxzy.bookstore.domain.Product;
import com.hxzy.bookstore.domain.User;
import com.hxzy.bookstore.serivice.impl.OrderServiceImpl;
import com.hxzy.bookstore.serivice.impl.ProductServiceImpl;
import com.hxzy.bookstore.serivice.impl.UserServiceImpl;
import com.hxzy.bookstore.service.OrderService;
import com.hxzy.bookstore.service.ProductService;
import com.hxzy.bookstore.service.UserService;

public class CreateOrderServlet extends HttpServlet{
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//新建一个order 对象
		Order order =new Order();
		try {
			BeanUtils.populate(order, request.getParameterMap());
			order.setId(UUID.randomUUID().toString());
			order.setUser((User)(request.getSession().getAttribute("user")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//获取session map
		HttpSession session=request.getSession();
		Map<Product,String> cart=(Map<Product,String>)session.getAttribute("map");
		//遍历cart,添加到orderItem
		List<OrderItem> list=new ArrayList<OrderItem>();
		for(Product p:cart.keySet()){
			OrderItem o=new OrderItem();
			o.setOrder(order);
			o.setProduct(p);
			o.setBuynum(Integer.parseInt(cart.get(p)));
			list.add(o);
		}
		
		order.setOrderItems(list);
		
		//调用页面方法保存order
		OrderService o=new OrderServiceImpl();
		o.addOrder(order);
		
		
		try {
			request.getRequestDispatcher("/pay.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
   
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    }
}
