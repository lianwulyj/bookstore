package com.hxzy.bookstore.service;

import java.util.List;

import com.hxzy.bookstore.domain.PageBean;
import com.hxzy.bookstore.domain.Product;

public interface ProductService {
	 
	public PageBean findBooksPage(int currentPage,int pagesize,String category) throws Exception ;
    public Product findBookById(String idS);
}
