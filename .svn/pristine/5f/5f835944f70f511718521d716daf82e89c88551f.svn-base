package com.seven.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.seven.entity.Manage;

public class JDBCTest {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stm =null;
		ResultSet rs = null;
		try {
			//1����������
			Class.forName("com.mysql.jdbc.Driver");
			//2���������
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop", "root", "123456");
			//3��׼��SQL���
			String sql = "select * from manage ";
			//4������SQL���
			stm = conn.createStatement();
			//5��ִ��SQL���(�õ������)
			rs = stm.executeQuery(sql);
			
			while(rs.next()){
				/*System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getInt(4));
				System.out.println(rs.getString(5));*/
				
				System.out.println(rs.getInt("id"));
				System.out.println(rs.getString("username"));
				System.out.println(rs.getString("password"));
				System.out.println(rs.getInt("sex"));
				System.out.println(rs.getString("truename"));
				
				Manage manage = new Manage();
				manage.setId(rs.getInt("id"));
				manage.setUsername(rs.getString("username"));
				manage.setPassword(rs.getString("password"));
				manage.setSex(rs.getInt("sex"));
				manage.setTruename(rs.getString("truename"));
				
				System.out.println(manage);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//6���ر���Դ
			try {
				rs.close();
				stm.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		
	}
}
