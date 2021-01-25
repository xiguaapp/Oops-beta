package com.example.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Book {

//    @Id //高亮查询不加该注解：Id property could not be found!
//    @Field("id")
//    private String book_id;
    @Field
    private String book_name;
    @Field
    private String book_writer;
    @Field
    private String book_publish;

}
