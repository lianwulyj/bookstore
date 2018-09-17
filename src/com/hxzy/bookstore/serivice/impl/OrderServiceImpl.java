package com.hxzy.bookstore.serivice.impl;

import java.util.List;

import com.hxzy.bookstore.dao.OrderDao;
import com.hxzy.bookstore.dao.OrderItemDao;
import com.hxzy.bookstore.dao.ProductDao;
import com.hxzy.bookstore.dao.impl.OrderDaoImpl;
import com.hxzy.bookstore.dao.impl.OrderItemDaoImpl;
import com.hxzy.bookstore.dao.impl.ProductDaoImpl;
import com.hxzy.bookstore.domain.Order;
import com.hxzy.bookstore.domain.OrderItem;
import com.hxzy.bookstore.service.OrderService;

public class OrderServiceImpl implements OrderService {

	public OrderDao orderDao=new OrderDaoImpl();
	public OrderItemDao orderItemDao=new OrderItemDaoImpl();
	public ProductDao productDao=new ProductDaoImpl();
	
	@Override
	public void addOrder(Order o) {
		//第一个插入订单表order
		orderDao.addOrder(o);
		
		//第二个插入订单明细表orderitem
		orderItemDao.addOrderItem(o);
		
		//第三减少商品的数量
		productDao.updateProductNum(o);
	}

	@Override
	public List<Order> findOrdersByUserId(int id) {
		
		return orderDao.findOrdersByUserId(id);
	}

	@Override
	public Order findOrdersByOrderId(String id) {
	
		return orderDao.findOrdersByOrderId(id);
	}

}
