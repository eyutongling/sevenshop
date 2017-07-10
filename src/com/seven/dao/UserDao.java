package com.seven.dao;

import java.util.List;

import com.seven.entity.User;
public interface UserDao {
	/**
	 * 读取表中所有数据
	 * @return
	 */
	public List<User> selectAll();
	/**
	 * 通过ID获取表中具体某一行数据
	 * @param id
	 * @return
	 */
	public User selectById(Integer id);
	/**
	 * 判断用户是否存在 
	 * @param user
	 * @return
	 * */
	public User isExist(String  username,String password);
	/**
	 * 向表中添加数据
	 * @param user
	 * @return
	 */
	public boolean add(User user);
	/**
	 * 更新表中数据
	 * @param user
	 * @return
	 */
	public boolean update(User user);
	/**
	 * 通过ID删除表中某一行数据
	 * @param id
	 * @return
	 */
	public boolean deleteById(Integer id);
}
