package com.hxzy.bookstore.domain;

import java.io.Serializable;

public class OrderItem implements Serializable{
	public Order order;
	public Product product;
	public int buynum;
	
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getBuynum() {
		return buynum;
	}
	public void setBuynum(int buynum) {
		this.buynum = buynum;
	}

}
