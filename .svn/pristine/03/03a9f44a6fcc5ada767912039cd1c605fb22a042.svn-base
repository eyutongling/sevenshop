package com.seven.dao;

import java.util.List;
import com.seven.entity.Goods;
import com.seven.entity.Goodscart;
import com.seven.entity.User;
public interface GoodscartDao {
	/**
	 * 读取表中所有数据
	 * @return
	 */
	public List<Goodscart> selectAll();
	/**
	 * 通过userID获取表中和user有关联的商品
	 * @param id
	 * @return
	 */
	public List<Goodscart> selectByUserId(Integer id);
	/**
	 * 向表中添加数据
	 * @param manage
	 * @return
	 */
	public boolean addByUserId(User user,Goods goods,Integer number);

	/**
	 * 通过ID删除表中某一行数据
	 * @param id
	 * @return
	 */
	public boolean deleteByGoodsId(Integer goodsId);
}
