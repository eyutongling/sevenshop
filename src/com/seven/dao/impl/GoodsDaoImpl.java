package com.seven.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import com.seven.dao.GoodsDao;
import com.seven.entity.Goods;
import com.seven.entity.mapper.GoodsRowMapper;
import com.seven.util.JdbcUtils;

public class GoodsDaoImpl implements GoodsDao {

	@Override
	public List<Goods> selectAll() {
		Connection conn = null;
		List list = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from goods";
			list = JdbcUtils.executeQuery(conn, sql, null, new GoodsRowMapper());
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.close(conn);
		}
	
		return list;
	}

	@Override
	public Goods selectById(Integer id) {
		Connection conn = null;
		List<Goods> list = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from goods where id=?";
			Integer[] params = {id};
			list = JdbcUtils.executeQuery(conn, sql, params, new GoodsRowMapper());
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.close(conn);
		}
		
		return list.get(0);
	}

	@Override
	public boolean add(Goods goods) {
		Connection conn = null;
	
		try {
			conn = JdbcUtils.getConnection();
			String sql = "insert into goods (name,prices,typeid) values(?,?,?)";
//			String sql = "insert into goods (name,prices,typeid,productor,description,img1,img2,img3) values('?','?','?','?','?','?')";
			Object [] params = {goods.getName(),goods.getPrices(),
					goods.getTypeid()};
/*			Object[] params = {goods.getName(),goods.getPrices(),
					goods.getTypeid(),goods.getProductor(),goods.getDescription(),
					goods.getImg1()};
*/			
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
	public boolean update(Goods goods) {
		
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "update goods set name =? , prices= ?,typeid=?  WHERE id="+goods.getId()+"" ;
			Object [] params = {goods.getName(),goods.getPrices(),
					goods.getTypeid()};
					System.out.println(goods.getName());
					System.out.println(goods.getPrices());
					System.out.println(goods.getTypeid());
			int result=JdbcUtils.executeUpdate(conn, sql, params);
			System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.close(conn);
		}
		return false;
	}

	@Override
	public boolean deleteById(Integer id) {
		
		
		return false;
	}

	public static void main(String[] args) {
		GoodsDao goodsDao = new GoodsDaoImpl();
		List list = goodsDao.selectAll();
		Goods goods=goodsDao.selectById(1);
		System.out.println(list);
		System.out.println(goods);
		//System.out.println(goodsDao.add(goods));
		System.out.println(goodsDao.update(goods));
	}
}
