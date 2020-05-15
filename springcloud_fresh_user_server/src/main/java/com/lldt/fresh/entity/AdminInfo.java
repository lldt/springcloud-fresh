package com.lldt.fresh.entity;

import java.io.Serializable;

/**
 * 管理员信息
 * @author 懒懒的唐
 *
 */
public class AdminInfo implements Serializable{
	private static final long serialVersionUID = -8760797438351820490L;
	
	private Integer aid;//管理员编号
	private String aname;//管理员昵称
	private String pwd;//管理员密码
	private String tel;//手机号码
	@Override
	public String toString() {
		return "AdminInfo [aid=" + aid + ", aname=" + aname + ", pwd=" + pwd + ", tel=" + tel + "]";
	}
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public AdminInfo(Integer aid, String aname, String pwd, String tel) {
		super();
		this.aid = aid;
		this.aname = aname;
		this.pwd = pwd;
		this.tel = tel;
	}
	public AdminInfo() {
		super();
	}
	
	
	
}
