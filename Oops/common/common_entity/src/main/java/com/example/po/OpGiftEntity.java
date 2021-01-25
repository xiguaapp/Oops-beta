package com.example.po;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;



/**
 * 这里是礼物类型
 * 
 * @author cf
 * @email 100@qq.com
 * @date 2020-12-22 11:51:02
 */
@Data
public class OpGiftEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer giftid;
	//
	private String gifname;
	//
	private Integer gifprice;

	//金额
	private int money;

	//礼物数量
	private int giftCount;
	//
	private String gifimageurl;

}
