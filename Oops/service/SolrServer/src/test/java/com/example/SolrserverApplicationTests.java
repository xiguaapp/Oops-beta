package com.example;

import com.example.po.User;

import com.example.po.UserVideo;
import com.example.po.Video;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.params.SolrParams;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;
import java.util.Map;


@SpringBootTest
class SolrserverApplicationTests {

    @Autowired
    SolrClient solrClient;

    @Test
    void contextLoads() {
        System.out.println("SLOR");
        System.out.println("对象是否存在"+solrClient);
    }

    /*
    * 通过SolrJ对索引库数据进行增删改查功能
    * SolrJ提供两个有用的接口，UpdateResponse和 QueryResponse，它们可以很方便的处理特定域的对象
     * */
    //添加对solr索引进行添加
    @Test
    void insert() throws IOException, SolrServerException {
        //1.获得Solr链接 solrClient
        //2.创建对象
        User user=new User();
//        user.setUserid("20");
        user.setUsername("梁心");
        user.setIntroduce("12312");
        solrClient.addBean(user);
        //事物提交
        solrClient.commit();
    }

    //对solr索引进行修改
    @Test
    void update() throws IOException, SolrServerException {
        //1.获得Solr链接 solrClient
        //2.创建对象
        User user=new User();
        user.setUserid("20");
        user.setUsername("李康军");
        user.setIntroduce("来自邵阳");
        solrClient.addBean(user);
        //事物提交
        solrClient.commit();
    }
    //通过指定id来删除索引
    @Test
    void delete() throws IOException, SolrServerException {
        //1.获得Solr链接 solrClient
        //2.创建对象
        /*
        * 清空solr数据库
        * solrClient.deleteByQuery("*:*")
        * */
        solrClient.deleteById("1");
        //事物提交
        solrClient.commit();
    }

    //简单查询
    @Test
    void ceshi() throws IOException, SolrServerException {
        //1.获得Solr链接 solrClient
        //2.创建对象
        SolrParams solrParams=new SolrQuery("*:*");
        QueryResponse queryResponse=solrClient.query(solrParams);
        long count=queryResponse.getResults().getNumFound();
        System.out.println("总记录数"+count);
        queryResponse.getBeans(UserVideo.class);
        List<UserVideo> list=queryResponse.getBeans(UserVideo.class);
        for (UserVideo u:list){
            System.out.println("视频id"+u.getVideoId()+"用户名"+u.getUsername()
                    +"视频描述"+u.getVideoDescript()+"视频url"+u.getVideoUrl());
        }
        //事物提交
        solrClient.commit();
    }

    //复杂查询
    @Test
    void query() throws IOException, SolrServerException {
        //1获得链接

        //2.查询的条件
        SolrQuery query=new SolrQuery();

        //q,prod_introduce:李四
        //query.set("q","prod_introduce:长沙");
        query.set("q","*:*");
        //fq 过滤查询
        //query.setFilterQueries("");
        //多选查询
//        query.addFilterQuery("prod_introduce:长沙 or prod_describe:中国");

        //价格筛选 price=10-  10-  10-20
//        query.addFilterQuery("prod_price:[10 To *]");
//        //排序 sort  psort=1 升序 2降序
//        query.addSort("prod_price",SolrQuery.ORDER.asc); //升序
//        query.addSort("prod_price",SolrQuery.ORDER.desc); //降序

        //分页 start rows
        /*
        limit [loffset] rows
        offset 偏移量从0开始
        rows  返回的最大记录数
        */
//        query.setStart(0);
//        query. setRows(5);

        //fl 回显 显示指定的字段
        //query.setFields("字段1","字段2","字段3");

        //高亮配置
        query.setHighlight(true); //启动高亮
//        //设置高亮域名称
//        query.addHighlightField("prod_username");
//        //设置前缀
//        query.setHighlightSimplePre("<font color='red'> ");
//        //设置后缀
//        query.setHighlightSimplePost("</font>");


        //3.查询的结果
        QueryResponse response=solrClient.query(query);
        //获取高亮的数据
        Map<String,Map<String,List<String>>> map=response.getHighlighting();
        long count=response.getResults().getNumFound();
        System.out.println("总记录数"+count);
        List<User> list=response.getBeans(User.class);
        for (User u:list){
            Map<String,List<String>> map1=map.get(u.getOid());
            List<String> list1=map1.get("prod_describe");
            if (list1!=null){
            String pame=list1.get(0);
            u.setDescribe(pame);
            }
            System.out.println("id"+u.getOid()+"biaot"+u.getDescribe());
            System.out.println("用户id"+u.getUserid()+"用户名"+u.getUsername()
             +"城市"+u.getIntroduce()+"vname"+u.getDescribe());
        }
    }
    }