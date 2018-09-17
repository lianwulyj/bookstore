package com.hxzy.bookstore.service;

import java.util.List;

import com.hxzy.bookstore.domain.Order;
import com.hxzy.bookstore.domain.OrderItem;

public interface OrderService {
	
	public void    addOrder(Order o) ;
	public List<Order>  findOrdersByUserId(int id);
	
	public Order findOrdersByOrderId(String id);

}
