package com.example.po;


import lombok.Data;
import org.apache.solr.client.solrj.beans.Field;

import java.io.Serializable;
import java.util.List;

@Data
public class User implements Serializable {
    private static final long serialVersionUID=1L;
    @Field("id")
    private String userid;
    @Field("prod_username")
    private String username;
    @Field("prod_introduce")
    private String introduce;
    @Field("prod_oid")
    private String oid;
    @Field("prod_describe")
    private String describe;
}
