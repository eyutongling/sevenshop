package com.seven.dao;

import java.util.List;

import com.seven.entity.Goods;
public interface GoodsDao {
	/**
	 * 读取表中所有数据
	 * @return
	 */
	public List<Goods> selectAll();
	/**
	 * 通过ID获取表中具体某一行数据
	 * @param id
	 * @return
	 */
	public Goods selectById(Integer id);
	/**
	 * 向表中添加数据
	 * @param manage
	 * @return
	 */
	public boolean add(Goods goods);
	/**
	 * 更新表中数据
	 * @param manage
	 * @return
	 */
	public boolean update(Goods goods);
	/**
	 * 通过ID删除表中某一行数据
	 * @param id
	 * @return
	 */
	public boolean deleteById(Integer id);
}
