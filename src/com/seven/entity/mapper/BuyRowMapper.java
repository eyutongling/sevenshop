package com.seven.entity.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.seven.entity.Buy;
import com.seven.util.RowMapper;

public class BuyRowMapper implements RowMapper{

	@Override
	public Object getEntity(ResultSet rs) throws SQLException {
		Buy buy = new Buy();
		buy.setId(rs.getInt("id"));
		buy.setUserid(rs.getInt("userId"));
		buy.setGoodsid(rs.getInt("goodsiId"));
		buy.setFare(rs.getFloat("fare"));
		buy.setBuytime(rs.getString("buyTime"));
		buy.setAddress(rs.getString("address"));
		return buy;
	}
	
}
