package com.example.vueboot.pojo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

//给实体类加一个文档注释
@ApiModel("用户实体类")
public class User {
    //给属性加一个文档注释
    @ApiModelProperty("用户名")
    public  String username;
    @ApiModelProperty("密码")
    public  String password;
}
