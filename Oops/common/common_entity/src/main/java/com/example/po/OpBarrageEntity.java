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
public class OpBarrageEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//弹幕id
	private Integer bId;
	//视频id
	private Integer videoId;
	//发送的内容
	private String content;

	/**
	 * 设置：弹幕id
	 */
	public void setBId(Integer bId) {
		this.bId = bId;
	}
	/**
	 * 获取：弹幕id
	 */
	public Integer getBId() {
		return bId;
	}
	/**
	 * 设置：视频id
	 */
	public void setVideoId(Integer videoId) {
		this.videoId = videoId;
	}
	/**
	 * 获取：视频id
	 */
	public Integer getVideoId() {
		return videoId;
	}
	/**
	 * 设置：发送的内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：发送的内容
	 */
	public String getContent() {
		return content;
	}
}
