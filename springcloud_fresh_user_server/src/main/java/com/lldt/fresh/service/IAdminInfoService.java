package com.lldt.fresh.service;

import java.util.List;
import java.util.Map;

import com.lldt.fresh.entity.AdminInfo;
import com.lldt.fresh.entity.MenberInfo;


public interface IAdminInfoService {
	public AdminInfo login(AdminInfo af);
	
	public AdminInfo findByAid(String aid);

	public MenberInfo userlogin(MenberInfo mb);
	
	public int add(Map<String,String> map);

	public List<AdminInfo> findAll();

	public int update(String aid);

	public int useradd(Map<String, String> map);

	public List<MenberInfo> finduserAll();

	public int freeze(Map<String,String> map);

}
