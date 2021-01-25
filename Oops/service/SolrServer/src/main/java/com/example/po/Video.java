package com.example.po;

import lombok.Data;
import org.apache.solr.client.solrj.beans.Field;

import java.io.Serializable;
import java.util.List;

@Data
public class Video implements Serializable {
    private static final long serialVersionUID=1L;
    @Field("prod_oid")
    private int oid;
    @Field("prod_describe")
    private int describe;
}
