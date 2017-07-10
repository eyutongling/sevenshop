package com.seven.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.seven.dao.UserDao;
import com.seven.entity.User;
import com.seven.entity.mapper.UserRowMapper;
import com.seven.util.JdbcUtils;

public class UserDaoImpl implements UserDao {

	@Override
	public List<User> selectAll() {
		Connection conn = null;
		List<User> list = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from user";
			list = JdbcUtils.executeQuery(conn, sql, null, new UserRowMapper());
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.close(conn);
		}
	
		return list;
	}

	@Override
	public User selectById(Integer id) {
		Connection conn = null;
		List<User> list = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from user where id=?";
			Integer[] params = {id};
			list = JdbcUtils.executeQuery(conn, sql, params, new UserRowMapper());
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.close(conn);
		}
		
		return list.get(0);
	}
	
	@Override
	public User isExist(String  username,String password) {
		Connection conn = null;
		List<User> list = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from user where username=? and password=?";
			Object[] params = {username,password};
			list = JdbcUtils.executeQuery(conn, sql, params, new UserRowMapper());
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.close(conn);
		}
		
		return list.get(0);
	}

	@Override
	public boolean add(User user) {
		Connection conn = null;
	
		try {
			conn = JdbcUtils.getConnection();
			String sql = "insert into user (id,username,password,sex,isadmin) values(null,?,?,?,?)";
			Object [] params = {user.getUsername(),user.getPassword(),
					user.getSex(),user.getIsadmin()};
			int result=JdbcUtils.executeUpdate(conn, sql, params);
			System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.close(conn);
		}
		
		return true;
	}


	@Override
	public boolean update(User user) {
		
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "update user set username =?,password= ?,sex=?,isadmin=? WHERE id="+user.getId()+"" ;
			Object [] params = {user.getUsername(),user.getPassword(),
					user.getSex(),user.getIsadmin()};
					System.out.println(user.getUsername());
					System.out.println(user.getPassword());
					System.out.println(user.getSex());
					System.out.println(user.getIsadmin());
			int result=JdbcUtils.executeUpdate(conn, sql, params);
			System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.close(conn);
		}
		return true;
	}

	@Override
	public boolean deleteById(Integer id) {
		
		
		return false;
	}

	public static void main(String[] args) {
		UserDaoImpl UDI = new UserDaoImpl();
		User user = new User();
		user.setUsername("xiaoma");
		user.setPassword("xiaoma");
		user.setSex(1);
		user.setIsadmin(1);
		//UDI.add(user);
		
		User user2 = UDI.isExist("admin","123");
		if(user2==null){
			System.out.println("不存在");
		}else{
			System.out.println("存在");
		}
	}


}
