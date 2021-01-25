package com.example.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * 
 * 
 * @author cf
 * @email 100@qq.com
 * @date 2020-12-22 11:51:03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OpAttentionEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	//关注人id
	private Integer attentionuid;
	//被关注人id
	private Integer beattentionuid;
}
