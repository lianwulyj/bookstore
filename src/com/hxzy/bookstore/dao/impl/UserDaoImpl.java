package com.hxzy.bookstore.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.hxzy.bookstore.dao.UserDao;
import com.hxzy.bookstore.domain.User;
import com.hxzy.bookstore.utils.C3P0Util;

public class UserDaoImpl implements UserDao{

	@Override
	public void addUser(User user) {
		QueryRunner queryRunner=new QueryRunner(C3P0Util.getDataSource());
		String sql="insert into user(username,password,gender,email,telephone,introduce,activecode,state,registtime) values (?,?,?,?,?,?,?,?,?)";
		try {
			queryRunner.update(sql,user.getUsername(),user.getPassword(),user.gender,user.getEmail(),user.getTelephone(),user.getIntroduce(),user.getActivecode(),user.getState(),user.getRegistTime());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		
	}

	public User findUserByActiveCode(String activecode) {
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		User user=null;
		try {
			user=qr.query("select * from user where activecode=?", new BeanHandler<User>(User.class),activecode);
		} catch (Exception e) {
		   e.printStackTrace();
		}
		return user;
	}

	@Override
	public void activeUser(String code) {
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		try {
			qr.update("update user set state=1 where activecode=?",code);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public User findUserByUserNameAndPassWord(String username, String password) {
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		User user=null;
		try {
			user= qr.query("select * from user where state='1'  and  username=? and password=?", new BeanHandler<User>(User.class),username,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User findUserById(String id) {
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		User user=null;
		try {
			 user=qr.query("select * from user where id=?", new BeanHandler<User>(User.class),id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public void modifyUser(User user) {
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		try {
			qr.update("update user set password=?, gender=?,telephone=? where id=?",user.getPassword(),user.getGender(),user.getTelephone(),user.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	

}
