package com.seven.dao;

import java.util.List;

import com.seven.entity.Buy;
public interface BuyDao {
	/**
	 * 读取表中所有数据
	 * @return
	 */
	public List<Buy> selectAll();
	
	/**
	 * 通过ID获取表中具体某一行数据
	 * @param id
	 * @return
	 */
	public Buy selectByUid(Integer id);
	public Buy selectByGid(Integer id);
	/**
	 * 向表中添加数据
	 * @param user
	 * @return
	 */
	public boolean add(Buy buy);
	/**
	 * 更新表中数据
	 * @param user
	 * @return
	 */
	public boolean update(Buy buy);
	/**
	 * 通过ID删除表中某一行数据
	 * @param id
	 * @return
	 */
	public boolean deleteById(Integer id);
}
