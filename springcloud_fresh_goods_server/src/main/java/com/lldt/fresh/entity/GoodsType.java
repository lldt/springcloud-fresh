package com.lldt.fresh.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 商品类型
 * @author 懒懒的唐
 *
 */
public class GoodsType implements Serializable{

	private static final long serialVersionUID = 7571894075513500184L;

	private Integer tno;//类型编号
	private String tname;//商品类型名
	private String pic;//类型图片
	private Integer status;//状态
	
	private List<GoodsInfo> goodinfos;

	
	@Override
	public String toString() {
		return "GoodsType [tno=" + tno + ", tname=" + tname + ", pic=" + pic + ", status=" + status + "]";
	}

	
	public List<GoodsInfo> getGoodinfos() {
		return goodinfos;
	}


	public void setGoodinfos(List<GoodsInfo> goodinfos) {
		this.goodinfos = goodinfos;
	}


	public Integer getTno() {
		return tno;
	}

	public void setTno(Integer tno) {
		this.tno = tno;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public GoodsType(Integer tno, String tname, String pic, Integer status) {
		super();
		this.tno = tno;
		this.tname = tname;
		this.pic = pic;
		this.status = status;
	}

	public GoodsType() {
		super();
	}

	


}
