package com.seven.entity.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.seven.entity.Goods;
import com.seven.util.RowMapper;

public class GoodsRowMapper implements RowMapper{

	@Override
	public Object getEntity(ResultSet rs) throws SQLException {
		Goods goods = new Goods();
		goods.setId(rs.getInt("id"));
		goods.setName(rs.getString("name"));
		goods.setPrices(rs.getFloat("prices"));
		goods.setTypeid(rs.getInt("typeid"));
		goods.setProductor(rs.getString("productor"));
		goods.setDescription(rs.getString("description"));
		goods.setImg1(rs.getString("img1"));
		goods.setImg2(rs.getString("img2"));
		goods.setImg3(rs.getString("img3"));
		return goods;
	}
	
}
