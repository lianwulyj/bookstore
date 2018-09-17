package com.hxzy.bookstore.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.hxzy.bookstore.dao.ProductDao;
import com.hxzy.bookstore.domain.Order;
import com.hxzy.bookstore.domain.OrderItem;
import com.hxzy.bookstore.domain.PageBean;
import com.hxzy.bookstore.domain.Product;
import com.hxzy.bookstore.utils.C3P0Util;

public class ProductDaoImpl implements ProductDao{

	//查找并分页
	public List<Product> findBooksPage(int currentPage, int pagesize, String category) throws Exception {
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		String sql="select * from products where 1=1 ";
		List list=new ArrayList();
		if(category!=""){
			sql+=" and category=? ";
			list.add(category);
		}
		sql+=" limit ?,? ";//?从第几条记录开始,?查询多少条
		list.add((currentPage-1)*pagesize);
		// currentPage=1   0  4(0+1=1,2,3,4)
		// currentPage=2   4  4(4+1=5,6,7,8)
		// currentPage=3   8  4(8+1=9,10,11,12)
		list.add(pagesize);
		
		
		 
		return qr.query(sql, new BeanListHandler<Product>(Product.class),list.toArray());
	}

	//查询总记录数
	public int count(String category) {
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		String sql="select count(*) from products where 1=1 ";
		if(category!=""){
			 sql+=" and category='"+category+"'";
		}
		long i=0;
		try {
			i = (long)qr.query(sql, new ScalarHandler(1));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (int)i;
	}

	@Override
	public Product findBookById(String idS) {
		Product product=new Product();
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		try {
			product=qr.query("select * from products where id=?",new BeanHandler<Product>(Product.class),idS);
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return product;
	}

	@Override
	public void updateProductNum(Order o) {
		List<OrderItem> orderItems=o.getOrderItems();
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		Object[][] params=new Object[orderItems.size()][];
		for(int i=0;i<params.length;i++){
			params[i]=new Object[]{orderItems.get(i).getBuynum(),orderItems.get(i).getProduct().getId()};
		}
		try {
			qr.batch("update products set pnum=pnum-? where id=?", params);
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
	}

}
