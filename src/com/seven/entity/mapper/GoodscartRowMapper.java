package com.seven.entity.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.seven.entity.Goodscart;
import com.seven.util.RowMapper;
public class GoodscartRowMapper implements RowMapper{

	@Override
	public Object getEntity(ResultSet rs) throws SQLException {
		Goodscart goodscart = new Goodscart();
		goodscart.setId(rs.getInt("id"));
		goodscart.setUserid(rs.getInt("userId"));
		goodscart.setGoodsid(rs.getInt("goodsId"));
		goodscart.setNumber(rs.getInt("number"));
		return goodscart;
	}
	
}
