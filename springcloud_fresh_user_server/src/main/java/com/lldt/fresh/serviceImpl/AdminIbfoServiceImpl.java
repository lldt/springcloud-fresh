package com.lldt.fresh.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lldt.fresh.entity.AdminInfo;
import com.lldt.fresh.entity.MenberInfo;
import com.lldt.fresh.mapper.IAdminInfoMapper;
import com.lldt.fresh.service.IAdminInfoService;
import com.lldt.fresh.until.StringUtil;

@Service
public class AdminIbfoServiceImpl implements IAdminInfoService {
	
	@Autowired
	private IAdminInfoMapper adminmapper;
	
	@Override
	public AdminInfo login(AdminInfo af) {
		if(StringUtil.checkNull(af.getAname(),af.getPwd())){
			return null;
		}
		return adminmapper.login(af);
	}

	@Override
	public MenberInfo userlogin(MenberInfo mb) {
		if(StringUtil.checkNull(mb.getNickName(),mb.getPwd())){
			return null;
		}
		return adminmapper.userlogin(mb);
	}

	@Override
	public int add(Map<String, String> map) {
		if(StringUtil.checkNull(map.get("aname"),map.get("pwd"),map.get("tel"))){
			return 0;
		}
		return adminmapper.add(map);
	}

	@Override
	public List<AdminInfo> findAll() {
		List<AdminInfo> list = new ArrayList<AdminInfo>();
		list = adminmapper.findAll();
		String tel;
		for(int i = 0,len = list.size();i<len;i++){
			String temp = list.get(i).getTel();
			tel = temp.substring(0,3) + "*****" + temp.substring(temp.length() -4 ,temp.length());
			list.get(i).setTel(tel);
		}
		return list;
	}

	@Override
	public int update(String aid) {
		if(StringUtil.checkNull(aid)){
			return 0;
		}
		AdminInfo af = adminmapper.findByAid(aid);
		String tel = af.getTel();
		af.setPwd(tel.substring(tel.length() -6 ,tel.length()));;
		return adminmapper.update(af);
	}

	@Override
	public AdminInfo findByAid(String aid) {
		return adminmapper.findByAid(aid);
	}

	@Override
	public int useradd(Map<String, String> map) {
		return adminmapper.useradd(map);
	}

	@Override
	public List<MenberInfo> finduserAll() {
		List<MenberInfo> list = new ArrayList<MenberInfo>();
		list = adminmapper.finduserAll();
		String tel;
		for(int i = 0,len = list.size();i<len;i++){
			String temp = list.get(i).getTel();
			tel = temp.substring(0,3) + "*****" + temp.substring(temp.length() -4 ,temp.length());
			list.get(i).setTel(tel);
		}
		return list;
	}

	@Override
	public int freeze(Map<String,String> map) {
		return adminmapper.freeze(map);
	}

}
