package com.lldt.fresh.entity;

import java.io.Serializable;

/**
 * 商品信息
 * @author 懒懒的唐
 *
 */
public class GoodsInfo implements Serializable{

	private static final long serialVersionUID = 8555837168042686376L;
	
	
	private Integer gno;//
	private String 	gname;//商品名称
	private Integer tno;//所属类型
	private double  price;//商品单价
	private String intro;//简介
	private Integer balance;//库存量
	private String pics;//图片
	private String unit;//单位
	private String qperied;//保质期
	private String weight;//净重
	private String descr;//描述

	
	@Override
	public String toString() {
		return "GoodsInfo [gno=" + gno + ", gname=" + gname + ", tno=" + tno + ", price=" + price + ", intro=" + intro
				+ ", balance=" + balance + ", pics=" + pics + ", unit=" + unit + ", qperied=" + qperied + ", weight="
				+ weight + ", descr=" + descr + "]";
	}



	public Integer getGno() {
		return gno;
	}

	public void setGno(Integer gno) {
		this.gno = gno;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public Integer getTno() {
		return tno;
	}

	public void setTno(Integer tno) {
		this.tno = tno;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public String getPics() {
		return pics;
	}

	public void setPics(String pics) {
		this.pics = pics;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getQperied() {
		return qperied;
	}

	public void setQperied(String qperied) {
		this.qperied = qperied;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public GoodsInfo(Integer gno, String gname, Integer tno, double price, String intro, Integer balance, String pics,
			String unit, String qperied, String weight, String descr) {
		super();
		this.gno = gno;
		this.gname = gname;
		this.tno = tno;
		this.price = price;
		this.intro = intro;
		this.balance = balance;
		this.pics = pics;
		this.unit = unit;
		this.qperied = qperied;
		this.weight = weight;
		this.descr = descr;
	}

	public GoodsInfo() {
		super();
	}
	
	
	
	
}
