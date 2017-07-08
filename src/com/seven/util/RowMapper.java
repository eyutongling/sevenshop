package com.seven.util;

import java.sql.ResultSet;
import java.sql.SQLException;


public interface RowMapper {
	public Object getEntity(ResultSet rs) throws SQLException;
}
