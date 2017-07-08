package com.seven.entity.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.seven.entity.Manage;
import com.seven.util.RowMapper;

public class ManageRowMapper implements RowMapper{

	@Override
	public Object getEntity(ResultSet rs) throws SQLException {
		Manage manage = new Manage();
		manage.setId(rs.getInt("id"));
		manage.setUsername(rs.getString("username"));
		manage.setPassword(rs.getString("password"));
		manage.setSex(rs.getInt("sex"));
		manage.setTruename(rs.getString("truename"));
		
		return manage;
	}
	
}
