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
public class OpTopupEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//充值id
	private Integer tId;
	//充值金额
	private Double money;
	//R币
	private Integer r;

	/**
	 * 设置：充值id
	 */
	public void setTId(Integer tId) {
		this.tId = tId;
	}
	/**
	 * 获取：充值id
	 */
	public Integer getTId() {
		return tId;
	}
	/**
	 * 设置：充值金额
	 */
	public void setMoney(Double money) {
		this.money = money;
	}
	/**
	 * 获取：充值金额
	 */
	public Double getMoney() {
		return money;
	}
	/**
	 * 设置：R币
	 */
	public void setR(Integer r) {
		this.r = r;
	}
	/**
	 * 获取：R币
	 */
	public Integer getR() {
		return r;
	}
}
