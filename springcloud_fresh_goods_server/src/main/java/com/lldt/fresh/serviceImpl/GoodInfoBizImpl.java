package com.lldt.fresh.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lldt.fresh.entity.GoodsInfo;
import com.lldt.fresh.entity.GoodsType;
import com.lldt.fresh.mapper.IGoodInfoMapper;
import com.lldt.fresh.service.IGoodInfoBiz;

@Service
public class GoodInfoBizImpl implements IGoodInfoBiz {
	
	@Autowired
	private IGoodInfoMapper goodmapper;

	@Override
	public List<GoodsType> findAllType() {
		return goodmapper.findAllType();
	}

	@Override
	public int add(GoodsInfo goodinfo) {
		return goodmapper.add(goodinfo);
	}

	@Override
	public Map<String, Object>findByPage(Map<String, Object> map) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("rows", goodmapper.findByPage(map));
		result.put("total", goodmapper.getTotal());
		return result;
	}
	
	@Override
	public int getTotal() { 
		return goodmapper.getTotal();
	}
	
	@Override
	public int getTypeTotal() { 
		return goodmapper.getTypeTotal();
	}

	@Override
	public Map<String, Object> findTypeByPage(Map<String, Object> map) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("rows", goodmapper.findTypeByPage(map));
		result.put("total", goodmapper.getTypeTotal());
		return result;
	}

	@Override
	public List<GoodsType> findindexAll() {
		return goodmapper.findindexAll();
	}

	@Override
	public Map<String, Object> findByTno(Map<String, Object> map) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("rows", goodmapper.findByTno(map));
		result.put("total", goodmapper.getByTnoTotal((Integer) map.get("tno")));
		return result;
	}
	@Override
	public Map<String, Object> findByTnoprice(Map<String, Object> map) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("rows", goodmapper.findByTnoprice(map));
		result.put("total", goodmapper.getByTnoTotal((Integer) map.get("tno")));
		return result;
	}

	@Override
	public int getByTnoTotal(Integer tno) {
		return goodmapper.getByTnoTotal(tno);
	}

	@Override
	public GoodsInfo findByGno(Integer gno) {
		return goodmapper.findByGno(gno);
	}

	@Override
	public List<Map<String, Object>> findAllGoods() {
		return goodmapper.findAllGoods();
	}
}
