package com.hxzy.bookstore.serivice.impl;

import com.hxzy.bookstore.dao.UserDao;
import com.hxzy.bookstore.dao.impl.UserDaoImpl;
import com.hxzy.bookstore.domain.User;
import com.hxzy.bookstore.service.UserService;
import com.hxzy.bookstore.utils.SendJMail;

public class UserServiceImpl implements UserService {
	
	public UserDao userDao=new UserDaoImpl();

	@Override
	public void regist(User user) {
		userDao.addUser(user);
		String emailMeg="注册成功,请<a href='http://localhost:8088/bookstore/activeServlet?activeCode="+user.getActivecode()+"'>激活</a>";
		//发邮件
	    SendJMail.sendMail(user.getEmail(),emailMeg);	
	
		
	}


	public void activeUser(String activeCode) {
	     //第一步拿到激活码到数据库查询
		 User user=userDao.findUserByActiveCode(activeCode);
		 //如果查询到 激活用户
		 if(user!=null){
			 userDao.activeUser(activeCode);
		 }else{
		 //如果查询不到 激活失败 
		 }
		
		
	}


	@Override
	public User findUserByUserNameAndPassWord(String username, String password) {
	  
		return userDao.findUserByUserNameAndPassWord(username, password);
	}


	@Override
	public User findUserById(String id) {
		
		return userDao.findUserById(id);
	}


	@Override
	public void modifyUser(User user) {
		 userDao.modifyUser(user);
		
	}

}
