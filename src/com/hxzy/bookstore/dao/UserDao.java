package com.hxzy.bookstore.dao;

import com.hxzy.bookstore.domain.User;

public interface UserDao {
	
	public void addUser(User user);
	public User findUserByActiveCode(String activecode);
	public void activeUser(String code);
	public User findUserByUserNameAndPassWord(String username, String password);
	public User findUserById(String id);
	public void modifyUser(User user);
}
