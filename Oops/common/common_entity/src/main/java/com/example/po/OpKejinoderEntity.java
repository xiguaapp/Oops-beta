package com.example.po;

import java.io.Serializable;
import java.util.Date;



/**
 * 用户充值的钱
 * 
 * @author cf
 * @email 100@qq.com
 * @date 2020-12-22 11:49:59
 */
public class OpKejinoderEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer userid;
	//
	private Float kejinmoney;
	//
	private Integer paymodle;
	//
	private Date kejintime;

	/**
	 * 设置：
	 */
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	/**
	 * 获取：
	 */
	public Integer getUserid() {
		return userid;
	}
	/**
	 * 设置：
	 */
	public void setKejinmoney(Float kejinmoney) {
		this.kejinmoney = kejinmoney;
	}
	/**
	 * 获取：
	 */
	public Float getKejinmoney() {
		return kejinmoney;
	}
	/**
	 * 设置：
	 */
	public void setPaymodle(Integer paymodle) {
		this.paymodle = paymodle;
	}
	/**
	 * 获取：
	 */
	public Integer getPaymodle() {
		return paymodle;
	}
	/**
	 * 设置：
	 */
	public void setKejintime(Date kejintime) {
		this.kejintime = kejintime;
	}
	/**
	 * 获取：
	 */
	public Date getKejintime() {
		return kejintime;
	}
}
