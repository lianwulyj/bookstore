package com.hxzy.bookstore.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Util {
	private static DataSource dataSource = new ComboPooledDataSource();
	
	
	public static DataSource getDataSource() {
		return dataSource;
	}

	public static Connection getConnection() throws Exception{
			return dataSource.getConnection();
		
	}
	
	public static void release(Connection conn,Statement stmt,ResultSet rs){
				if(rs!=null){
					try {
						rs.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
					rs = null;
				}
				if(stmt!=null){
					try {
						stmt.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
					stmt = null;
				}
				if(conn!=null){
					try {
						conn.close();//�ر�
					} catch (Exception e) {
						e.printStackTrace();
					}
					conn = null;
				}
	}
	
}
