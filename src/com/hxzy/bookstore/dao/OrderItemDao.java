package com.hxzy.bookstore.dao;

import java.util.List;

import com.hxzy.bookstore.domain.Order;
import com.hxzy.bookstore.domain.OrderItem;

public interface OrderItemDao {
	
	public void addOrderItem(Order o);

}
