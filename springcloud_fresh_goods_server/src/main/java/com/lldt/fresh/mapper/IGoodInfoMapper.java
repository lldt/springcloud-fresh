package com.lldt.fresh.mapper;

import java.util.List;
import java.util.Map;

import com.lldt.fresh.entity.GoodsInfo;
import com.lldt.fresh.entity.GoodsType;


public interface IGoodInfoMapper {

	public List<GoodsType> findAllType();
	
	public List<GoodsInfo> findByPage(Map<String, Object> map);
	
	public List<GoodsType> findTypeByPage(Map<String, Object> map);

	public int add(GoodsInfo goodinfo);

	public int getTotal();

	public int getTypeTotal();

	public List<GoodsType> findindexAll();
	
	public List<GoodsInfo> findByTno(Map<String, Object> map);
	
	public List<GoodsInfo> findByTnoprice(Map<String, Object> map);
	
	public int getByTnoTotal(Integer tno);
	
	public GoodsInfo findByGno(Integer gno);

	public List<Map<String, Object>> findAllGoods();


}
