package com.example.po;

import java.io.Serializable;
import java.util.Date;



/**
 * 这里存放的是某用户对某视频的打赏
 * 
 * @author cf
 * @email 100@qq.com
 * @date 2020-12-22 11:51:03
 */
public class OpOdercostEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer videoid;
	//
	private Integer paymanid;
	//
	private Integer giftid;

	/**
	 * 设置：
	 */
	public void setVideoid(Integer videoid) {
		this.videoid = videoid;
	}
	/**
	 * 获取：
	 */
	public Integer getVideoid() {
		return videoid;
	}
	/**
	 * 设置：
	 */
	public void setPaymanid(Integer paymanid) {
		this.paymanid = paymanid;
	}
	/**
	 * 获取：
	 */
	public Integer getPaymanid() {
		return paymanid;
	}
	/**
	 * 设置：
	 */
	public void setGiftid(Integer giftid) {
		this.giftid = giftid;
	}
	/**
	 * 获取：
	 */
	public Integer getGiftid() {
		return giftid;
	}
}
