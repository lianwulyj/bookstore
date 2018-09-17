package com.hxzy.bookstore.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.hxzy.bookstore.domain.Product;
import com.hxzy.bookstore.domain.User;
import com.hxzy.bookstore.serivice.impl.ProductServiceImpl;
import com.hxzy.bookstore.serivice.impl.UserServiceImpl;
import com.hxzy.bookstore.service.ProductService;
import com.hxzy.bookstore.service.UserService;

public class AddCartServlet extends HttpServlet{
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		 doPost(request,response);
	}
	
   
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        
        PrintWriter pw=response.getWriter();
    	//获取商品id
    	String id=request.getParameter("id");
    	//通过商品id查询
    	ProductService ps=new ProductServiceImpl();
    	Product product=ps.findBookById(id);
    	//java 
    	
    	//获取session
    	HttpSession session=request.getSession();
    	Map<Product,String> map=(Map<Product,String>)session.getAttribute("map");
    	//cart java 2
    	int num=1;
        if(map==null){
        	map=new HashMap<Product,String>();
        }
        if(map.containsKey(product)){
        	num=Integer.parseInt(map.get(product))+1;//2+1
        }
        map.put(product, num+"");
        session.setAttribute("map", map);
        pw.print("<a href='"+request.getContextPath()+"/pageServlet'>继续购物</a> <a href='"+request.getContextPath()+"/cart.jsp'>查看购物车</a>");
        
    
    	
    }
}
