package com.seven.entity.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.seven.entity.User;
import com.seven.util.RowMapper;

public class UserRowMapper implements RowMapper{

	@Override
	public Object getEntity(ResultSet rs) throws SQLException {
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		user.setSex(rs.getInt("sex"));
		user.setIsadmin(rs.getInt("isadmin"));
		return user;
	}
	
}
