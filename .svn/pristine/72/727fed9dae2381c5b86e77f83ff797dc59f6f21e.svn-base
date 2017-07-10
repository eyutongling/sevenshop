package com.seven.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import com.seven.dao.GoodsDao;
import com.seven.dao.GoodscartDao;
import com.seven.entity.Goods;
import com.seven.entity.Goodscart;
import com.seven.entity.User;
import com.seven.entity.mapper.GoodsRowMapper;
import com.seven.entity.mapper.GoodscartRowMapper;
import com.seven.util.JdbcUtils;

public class GoodsCartDaoImpl implements GoodscartDao {

	@Override
	public List<Goodscart> selectAll() {
		Connection conn = null;
		List list = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from goodscart";
			list = JdbcUtils.executeQuery(conn, sql, null, new GoodscartRowMapper());
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.close(conn);
		}
	
		return list;
	}

	@Override
	public List<Goodscart> selectByUserId(Integer userId) {
		Connection conn = null;
		List<Goodscart> list = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from goodscart where id=?";
			Integer[] params = {userId};
			list = JdbcUtils.executeQuery(conn, sql, params, new GoodscartRowMapper());
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.close(conn);
		}
		
		return list;
	}

	@Override
	public boolean addByUserId(User user,Goods goods,Integer number) {
		Connection conn = null;
	
		try {
			conn = JdbcUtils.getConnection();
			String sql = "insert into goodscart (userId,goodsId,number) values(?,?,?)";
			Object [] params = {user.getId(),goods.getId(),
					number};
	
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
	public boolean deleteByGoodsId(Integer goodsId) {
		Connection conn = null;
		
		try {
			conn = JdbcUtils.getConnection();
			String sql = "delete from goodscart where goodsId=?";
			Object [] params = {goodsId};
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

	public static void main(String[] args) {
		GoodscartDao goodscartDao = new GoodsCartDaoImpl();
//		List list = goodscartDao.selectAll();
		List list = goodscartDao.selectByUserId(1);
		System.out.println(list);
		Goods goods=new Goods();
		User user=new User();
		user.setId(1);
		goods.setId(1);
//		System.out.println(goodscartDao.addByUserId(user, goods, 233));
		System.out.println(goodscartDao.deleteByGoodsId(1));
		

	}
}
