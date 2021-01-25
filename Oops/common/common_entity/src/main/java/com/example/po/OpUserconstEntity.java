package com.example.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;



/**
 * 记录用户的充值打赏
 * 
 * @author cf
 * @email 100@qq.com
 * @date 2020-12-22 11:51:02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OpUserconstEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private int cid; //主键id
    private int userId;//用户id
	private String type; //充值方式
	private Date payTime;//消费时间
	private int v_id; //默认0:没有套餐则R币充值
	private Date expire; //会员到期时间
	private float money; //消费金额
}
