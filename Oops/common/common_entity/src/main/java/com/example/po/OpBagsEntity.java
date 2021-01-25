package com.example.po;

import java.io.Serializable;
import java.util.Date;



/**
 * 氪金道具
 * 
 * @author cf
 * @email 100@qq.com
 * @date 2020-12-22 11:51:03
 */
public class OpBagsEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer userid;
	//
	private Integer gifid;
	//
	private Integer giftcount;

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
	public void setGifid(Integer gifid) {
		this.gifid = gifid;
	}
	/**
	 * 获取：
	 */
	public Integer getGifid() {
		return gifid;
	}
	/**
	 * 设置：
	 */
	public void setGiftcount(Integer giftcount) {
		this.giftcount = giftcount;
	}
	/**
	 * 获取：
	 */
	public Integer getGiftcount() {
		return giftcount;
	}
}
