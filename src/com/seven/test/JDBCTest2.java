package com.seven.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest2 {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstm =null;
		ResultSet rs = null;
		try {
			//1����������
			Class.forName("com.mysql.jdbc.Driver");
			//2���������
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop", "root", "123456");
			//3��׼��SQL���
			String sql = "select * from manage where username = ? ";
			//4������SQL���
			pstm = conn.prepareStatement(sql);
			pstm.setObject(1, "user");
			//5��ִ��SQL���(�õ������)
			rs = pstm.executeQuery();
			
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
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//6���ر���Դ
			try {
				rs.close();
				pstm.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		
	}
}
