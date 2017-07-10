package com.seven.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.seven.dao.BuyDao;
import com.seven.entity.Buy;
import com.seven.entity.mapper.BuyRowMapper;
import com.seven.util.JdbcUtils;

public class BuyDaoImpl implements BuyDao {

	@Override
	public List<Buy> selectAll() {
		Connection conn = null;
		List<Buy> list = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from buy";
			list = JdbcUtils.executeQuery(conn, sql, null, new BuyRowMapper());
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.close(conn);
		}
	
		return list;
	}

	@Override
	public Buy selectByUid(Integer id) {
		Connection conn = null;
		List<Buy> list = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from buy where userId=?";
			Integer[] params = {id};
			list = JdbcUtils.executeQuery(conn, sql, params, new BuyRowMapper());
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.close(conn);
		}
		
		return list.get(0);
	}
	
	@Override
	public Buy selectByGid(Integer id) {
		Connection conn = null;
		List<Buy> list = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from buy where goodsId=?";
			Integer[] params = {id};
			list = JdbcUtils.executeQuery(conn, sql, params, new BuyRowMapper());
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.close(conn);
		}
		
		return list.get(0);
	}
	
	@Override
	public boolean add(Buy buy) {
		Connection conn = null;
	
		try {
			conn = JdbcUtils.getConnection();
			String sql = "insert into buy (id,userId,goodsId,fare,buyTime,address) values(null,?,?,?,?,?)";
			Object [] params = {buy.getUserid(),buy.getGoodsid(),
					buy.getFare(),buy.getBuytime(),buy.getAddress()};
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
	public boolean update(Buy buy) {
		
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "update buy set userId =?,goodsId= ?,fare=?,buyTime=?,address=? WHERE id="+buy.getId()+"" ;
			Object [] params = {buy.getUserid(),buy.getGoodsid(),
					buy.getFare(),buy.getBuytime(),buy.getAddress()};
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
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "delete from buy WHERE id=?" ;
			Object [] params = {id};
			int result=JdbcUtils.executeUpdate(conn, sql, params);
			System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.close(conn);
		}
		return true;
		
	}

	public static void main(String[] args) {
		BuyDaoImpl UDI = new BuyDaoImpl();
		GoodsDaoImpl GDI = new GoodsDaoImpl();
		Buy buy = new Buy();
		buy.setUserid(1);
		buy.setGoodsid(1);
		buy.setFare(GDI.selectById(1).getPrices());
		buy.setAddress("广东省广州市花都区新华镇");
		buy.setBuytime("2017-07-09");
		UDI.add(buy);
//		List<Buy> list = UDI.selectAll();
//		for(Buy buy2 : list){
//			System.out.println(buy2);
//		}
//		Buy buy2 = UDI.selectByGid(1);
//		System.out.println(buy2.getId());
//		buy2 = UDI.selectByUid(1);
//		System.out.println(buy2.getId());
//		UDI.deleteById(1);
}
}
