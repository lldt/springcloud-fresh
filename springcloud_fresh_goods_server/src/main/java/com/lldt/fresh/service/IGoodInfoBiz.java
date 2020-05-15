package com.lldt.fresh.service;


import java.util.List;
import java.util.Map;

import com.lldt.fresh.entity.GoodsInfo;
import com.lldt.fresh.entity.GoodsType;


public interface IGoodInfoBiz {
	public List<GoodsType> findAllType();
	
	public Map<String, Object> findByPage(Map<String, Object> map);

	public int add(GoodsInfo goodinfo);

	public int getTotal();

	public Map<String, Object> findTypeByPage(Map<String, Object> map);

	public int getTypeTotal();

	public List<GoodsType> findindexAll();

	public Map<String, Object> findByTno(Map<String, Object> map);
	
	public Map<String, Object> findByTnoprice(Map<String, Object> map);
	
	public int getByTnoTotal(Integer tno);
	public GoodsInfo findByGno(Integer gno);

	public List<Map<String, Object>> findAllGoods();

}
