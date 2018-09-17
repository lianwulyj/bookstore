package com.hxzy.bookstore.dao;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import com.hxzy.bookstore.domain.Order;
import com.hxzy.bookstore.utils.C3P0Util;

public interface OrderDao {
	
	public void addOrder(Order o);
	public List<Order>  findOrdersByUserId(int id);
	public Order findOrdersByOrderId(String id);

}
