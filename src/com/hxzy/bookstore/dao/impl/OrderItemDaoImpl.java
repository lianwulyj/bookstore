package com.hxzy.bookstore.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import com.hxzy.bookstore.dao.OrderItemDao;
import com.hxzy.bookstore.domain.Order;
import com.hxzy.bookstore.domain.OrderItem;
import com.hxzy.bookstore.utils.C3P0Util;

public class OrderItemDaoImpl implements OrderItemDao{

	
	public void addOrderItem(Order o) {
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		List<OrderItem> orderItems=o.getOrderItems();
		Object[][] params=new Object[orderItems.size()][];
		for(int i=0;i<params.length;i++){
			params[i]=new Object[]{o.getId(),orderItems.get(i).getProduct().getId(),orderItems.get(i).getBuynum()};
		}
		try {
			qr.batch("insert into orderitem values(?,?,?)", params);
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}

}
