package com.example.po;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author cf
 * @email 100@qq.com
 * @date 2020-12-22 11:51:02
 */
public class OpVipEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//会员id
	private Integer vid;
	//会员名称
	private String vname;
	//会员价格
	private Double vprice;

	/**
	 * 设置：会员id
	 */
	public void setVid(Integer vid) {
		this.vid = vid;
	}
	/**
	 * 获取：会员id
	 */
	public Integer getVid() {
		return vid;
	}
	/**
	 * 设置：会员名称
	 */
	public void setVname(String vname) {
		this.vname = vname;
	}
	/**
	 * 获取：会员名称
	 */
	public String getVname() {
		return vname;
	}
	/**
	 * 设置：会员价格
	 */
	public void setVprice(Double vprice) {
		this.vprice = vprice;
	}
	/**
	 * 获取：会员价格
	 */
	public Double getVprice() {
		return vprice;
	}
}
