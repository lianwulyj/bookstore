package com.hxzy.bookstore.serivice.impl;

import java.util.List;

import com.hxzy.bookstore.dao.ProductDao;
import com.hxzy.bookstore.dao.impl.ProductDaoImpl;
import com.hxzy.bookstore.domain.PageBean;
import com.hxzy.bookstore.domain.Product;
import com.hxzy.bookstore.service.ProductService;

public class ProductServiceImpl implements ProductService{

	public ProductDao productDao=new ProductDaoImpl();
	public PageBean findBooksPage(int currentPage, int pagesize, String category) throws Exception {
		//查询记录数
		List<Product> products=productDao.findBooksPage(currentPage, pagesize, category);
		//查询总记录数
		int count=productDao.count(category);
		//总页数
		int totalPage=(int)Math.ceil(count*1.0/pagesize);
		
		PageBean pb=new PageBean();
		pb.setProducts(products);
		pb.setCount(count);
		pb.setCurrentPage(currentPage);
		pb.setPagesize(pagesize);
		pb.setTotalPage(totalPage);
		pb.setCategory(category);
		return pb;
	}
	@Override
	public Product findBookById(String idS) {
		
		return productDao.findBookById(idS);
	}

}
