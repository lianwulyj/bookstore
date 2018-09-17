package com.hxzy.bookstore.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.hxzy.bookstore.dao.OrderDao;
import com.hxzy.bookstore.domain.Order;
import com.hxzy.bookstore.domain.OrderItem;
import com.hxzy.bookstore.domain.Product;
import com.hxzy.bookstore.utils.C3P0Util;

public class OrderDaoImpl implements OrderDao{

	@Override
	public void addOrder(Order o) {
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		try {
			qr.update("insert into orders values(?,?,?,?,?,?,?,?)",o.getId(),o.getMoney(),o.getReceiverAddress(),o.getReceiverName(),o.getReceiverPhone(),o.getPaystate(),o.getOrderTime(),o.getUser().getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Order> findOrdersByUserId(int id) {
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		List<Order> list=new ArrayList<Order>();
		try {
			list=qr.query("select * from orders where user_id=?", new BeanListHandler<Order>(Order.class),id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Order findOrdersByOrderId(String id) {
		//通过id查询订单表
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		Order order=null;
		try {
			order=qr.query("select * from orders where id=?", new BeanHandler<Order>(Order.class),id);
		    List<OrderItem> orderItems=qr.query("select * from orderitem o,products p where o.product_id =p.id and order_id=?", new ResultSetHandler<List<OrderItem>>(){
		    	public List<OrderItem> handle(ResultSet rs) throws SQLException {
		    		List<OrderItem> orderItemss=new ArrayList<OrderItem>();
		    		while(rs.next()){
		    			OrderItem o=new OrderItem();
		    			o.setBuynum(rs.getInt("buynum"));
		    			Product p=new Product();
		    			p.setName(rs.getString("name"));
		    			p.setPrice(rs.getDouble("price"));
		    			o.setProduct(p);
		    			orderItemss.add(o);
		    		}
					return orderItemss;
				}
		    },id);
		    order.setOrderItems(orderItems);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return order;
	}

}
