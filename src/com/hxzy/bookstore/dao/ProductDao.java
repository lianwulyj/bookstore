package com.hxzy.bookstore.dao;

import java.util.List;

import com.hxzy.bookstore.domain.Order;
import com.hxzy.bookstore.domain.PageBean;
import com.hxzy.bookstore.domain.Product;

public interface ProductDao {

	public List<Product> findBooksPage(int currentPage,int pagesize,String category) throws Exception;
    public int count(String category);
    public Product findBookById(String idS);
    
    public void updateProductNum(Order o);
}
