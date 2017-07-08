package com.seven.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.seven.entity.mapper.ManageRowMapper;
import com.seven.util.JdbcUtils;

public class JDBCTest3 {
	public static void main(String[] args) {
		
		try {
			Connection conn = JdbcUtils.getConnection();
			String sql = "select * from manage where username = ? and password = ?";
			String[] params = {"admin","123456"};
			List list = JdbcUtils.executeQuery(conn, sql, params, new ManageRowMapper());
			System.out.println(list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
