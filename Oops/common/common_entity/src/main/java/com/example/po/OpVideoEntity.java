package com.example.po;

import java.io.Serializable;
import java.util.Date;



/**
 * 这里是视频表 包含视频的源与视频的发布人 时间与 关键字 点击率 播放次数 还有最为关键的权重 这个权重可以影响视频置顶
 * 
 * @author cf
 * @email 100@qq.com
 * @date 2020-12-22 11:51:02
 */
public class OpVideoEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//视频id
	private Integer videoid;
	//用户id
	private Integer userid;
	//视频路径
	private String videourl;
	//视频点赞数
	private Integer videocount;
	//权重
	private Integer weight;
	//状态
	private String videostatus;
	//上传时间
	private Date videotime;
	//视频描述
	private String videodescript;
	//点播id
	private String oosid;

	/**
	 * 设置：视频id
	 */
	public void setVideoid(Integer videoid) {
		this.videoid = videoid;
	}
	/**
	 * 获取：视频id
	 */
	public Integer getVideoid() {
		return videoid;
	}
	/**
	 * 设置：用户id
	 */
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	/**
	 * 获取：用户id
	 */
	public Integer getUserid() {
		return userid;
	}
	/**
	 * 设置：视频路径
	 */
	public void setVideourl(String videourl) {
		this.videourl = videourl;
	}
	/**
	 * 获取：视频路径
	 */
	public String getVideourl() {
		return videourl;
	}
	/**
	 * 设置：视频点赞数
	 */
	public void setVideocount(Integer videocount) {
		this.videocount = videocount;
	}
	/**
	 * 获取：视频点赞数
	 */
	public Integer getVideocount() {
		return videocount;
	}
	/**
	 * 设置：权重
	 */
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	/**
	 * 获取：权重
	 */
	public Integer getWeight() {
		return weight;
	}
	/**
	 * 设置：状态
	 */
	public void setVideostatus(String videostatus) {
		this.videostatus = videostatus;
	}
	/**
	 * 获取：状态
	 */
	public String getVideostatus() {
		return videostatus;
	}
	/**
	 * 设置：上传时间
	 */
	public void setVideotime(Date videotime) {
		this.videotime = videotime;
	}
	/**
	 * 获取：上传时间
	 */
	public Date getVideotime() {
		return videotime;
	}
	/**
	 * 设置：视频描述
	 */
	public void setVideodescript(String videodescript) {
		this.videodescript = videodescript;
	}
	/**
	 * 获取：视频描述
	 */
	public String getVideodescript() {
		return videodescript;
	}
	/**
	 * 设置：点播id
	 */
	public void setOosid(String oosid) {
		this.oosid = oosid;
	}
	/**
	 * 获取：点播id
	 */
	public String getOosid() {
		return oosid;
	}
}
