package com.hxzy.bookstore.service;

import com.hxzy.bookstore.domain.User;

public interface UserService {
	
	
	public void regist(User user);

	public void activeUser(String activeCode);
	
	public User findUserByUserNameAndPassWord(String username,String password);
	
	public User findUserById(String id);
	
	public void modifyUser(User user);
	

}
