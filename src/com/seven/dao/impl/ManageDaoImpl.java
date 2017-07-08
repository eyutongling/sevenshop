package com.seven.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.seven.dao.ManageDao;
import com.seven.entity.Manage;
import com.seven.entity.mapper.ManageRowMapper;
import com.seven.util.JdbcUtils;

public class ManageDaoImpl implements ManageDao {

	@Override
	public List<Manage> selectAll() {
		Connection conn = null;
		List list = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from manage";
			list = JdbcUtils.executeQuery(conn, sql, null, new ManageRowMapper());
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.close(conn);
		}
		
		return list;
	}

	@Override
	public Manage selectById(Integer id) {
		Connection conn = null;
		List<Manage> list = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from manage where id=?";
			Integer[] params = {id};
			list = JdbcUtils.executeQuery(conn, sql, params, new ManageRowMapper());
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.close(conn);
		}
		
		return list.get(0);
	}

	@Override
	public boolean add(Manage manage) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Manage manage) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	public static void main(String[] args) {
		ManageDao manageDao = new ManageDaoImpl();
		/*List list = manageDao.selectAll();
		System.out.println(list);*/
	}
}
