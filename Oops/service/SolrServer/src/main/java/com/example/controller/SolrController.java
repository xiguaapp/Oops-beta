package com.example.controller;


import com.example.commonutils.R;
import com.example.po.User;
import com.example.po.UserVideo;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.params.SolrParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

@RestController
//搜索引擎
public class SolrController {

    @Autowired
    SolrClient solrClient;

    //用户查询
    @RequestMapping("/solrse/userdis")
    public R userdis(@RequestParam String uty, HttpServletRequest request) throws IOException, SolrServerException {
        System.out.println("进来了..。。"+uty);
        //1.获得Solr链接 solrClient
        SolrQuery query=new SolrQuery();
        //2.创建对象
        StringBuilder params = new StringBuilder();
        params.append(" prod_username:"+uty );
        query.setHighlight(true); // 开启高亮组件或用query.setParam("hl", "true");
        query.addHighlightField("prod_username");//         高亮字段
        query.setHighlightSimplePre("<font color='red'>");//标记，高亮关键字前缀
        query.setHighlightSimplePost("</font>");//后缀
        QueryResponse queryResponse=solrClient.query(query.setQuery(params.toString()));
        long count=queryResponse.getResults().getNumFound();
        System.out.println("总记录数"+count);
        Map<String, Map<String,List<String>>> map=queryResponse.getHighlighting();
        List<UserVideo> list=queryResponse.getBeans(UserVideo.class);
        Map<String,Object> m=new HashMap<>();
        for (UserVideo u:list){
            Map<String,List<String>> map1=map.get(u.getAout());
            List<String> list1=map1.get("prod_username");
            if (list1!=null){
                String pame=list1.get(0);
                u.setUsername(pame);
            }
            System.out.println("集合"+list);
        }
        HashSet<UserVideo> userVideos = new HashSet<>(list);
        System.out.println(userVideos);
        //System.out.println("map的值"+m);
        return  R.ok().data("ceshi",userVideos);
    }


    //搜索视频+用户前端显示用户头像+用户昵称+视频文本+视频
    @RequestMapping("/solrse/usvideo")
     public R video(@RequestParam String uty,HttpServletRequest request) throws IOException, SolrServerException {
        System.out.println("进来了..。。"+uty);
        //1.获得Solr链接 solrClient
        SolrQuery query=new SolrQuery();
        //2.创建对象
        StringBuilder params = new StringBuilder();
        params.append(" prod_username:"+uty );
        params.append(" OR prod_videoDescript:"+uty);
        query.setHighlight(true); // 开启高亮组件或用query.setParam("hl", "true");
        query.addHighlightField("prod_username");//         高亮字段
        query.addHighlightField("prod_videoDescript");// 高亮字段
        query.setHighlightSimplePre("<font color='red'>");//标记，高亮关键字前缀
        query.setHighlightSimplePost("</font>");//后缀
        QueryResponse queryResponse=solrClient.query(query.setQuery(params.toString()));
        long count=queryResponse.getResults().getNumFound();
        System.out.println("总记录数"+count);
        Map<String, Map<String,List<String>>> map=queryResponse.getHighlighting();
        List<UserVideo> list=queryResponse.getBeans(UserVideo.class);
        Map<String,Object> m=new HashMap<>();
        for (UserVideo u:list){
            Map<String,List<String>> map1=map.get(u.getAout());
            List<String> list1=map1.get("prod_username");
            List<String> list2=map1.get("prod_videoDescript");
            if (list1!=null){
                String pame=list1.get(0);
                u.setUsername(pame);
            }
            if (list2!=null){
                String pame=list2.get(0);
                u.setVideoDescript(pame);
            }
            System.out.println("集合"+list);
        }
//        HashSet<UserVideo> userVideos = new HashSet<>(list);
//        System.out.println(userVideos);
        //System.out.println("map的值"+m);
        return  R.ok().data("ceshi",list);
    }


    //用户+视频描述一起搜索
    @RequestMapping("/solrse/ceshi")
    public R ceshi(@RequestParam String uty,HttpServletRequest request) throws IOException, SolrServerException {
        System.out.println("进来了..。。"+uty);
        //1.获得Solr链接 solrClient
        SolrQuery query=new SolrQuery();
        //2.创建对象
        StringBuilder params = new StringBuilder();
        params.append(" prod_username:"+uty );
        params.append(" OR prod_videoDescript:"+uty);
        query.setHighlight(true); // 开启高亮组件或用query.setParam("hl", "true");
        query.addHighlightField("prod_username");//         高亮字段
        query.addHighlightField("prod_videoDescript");// 高亮字段
        query.setHighlightSimplePre("<font color='red'>");//标记，高亮关键字前缀
        query.setHighlightSimplePost("</font>");//后缀
        QueryResponse queryResponse=solrClient.query(query.setQuery(params.toString()));
        long count=queryResponse.getResults().getNumFound();
        System.out.println("总记录数"+count);
        Map<String, Map<String,List<String>>> map=queryResponse.getHighlighting();
        List<UserVideo> list=queryResponse.getBeans(UserVideo.class);
        Map<String,Object> m=new HashMap<>();
        for (UserVideo u:list){
            Map<String,List<String>> map1=map.get(u.getAout());
            List<String> list1=map1.get("prod_username");
            List<String> list2=map1.get("prod_videoDescript");
            if (list1!=null){
                String pame=list1.get(0);
                u.setUsername(pame);
            }
            if (list2!=null){
                String pame=list2.get(0);
                u.setVideoDescript(pame);
            }
            System.out.println("集合"+m);
        }
        HashSet<UserVideo> userVideos = new HashSet<>(list);
        System.out.println(userVideos);
        //System.out.println("map的值"+m);
        return  R.ok().data("ceshi",userVideos);
    }

    @RequestMapping("/solrse")
    public R solrse() throws IOException, SolrServerException {

        //1.获得Solr链接 solrClient
        SolrQuery query=new SolrQuery();
        //2.创建对象
        StringBuilder params = new StringBuilder();

//        query.setQuery("prod_username:李四");
//        query.setHighlight(true); //开启高亮组件
//        query.addHighlightField("prod_username");//高亮字段
//        query.setHighlightSimplePre("<font color=red>");//标记
//        query.setHighlightSimplePost("</font>");
        params.append(" prod_describe:李" );
        params.append(" OR prod_username:李");
        query.setHighlight(true); // 开启高亮组件或用query.setParam("hl", "true");
        query.addHighlightField("prod_username");//         高亮字段
        query.addHighlightField("prod_describe");// 高亮字段
        query.setHighlightSimplePre("<font color='red'>");//标记，高亮关键字前缀
        query.setHighlightSimplePost("</font>");//后缀

//        query.setHighlight(true); // 开启高亮组件或用query.setParam("hl", "true");
//        query.setHighlightSimplePre("<font color='red'>");//标记，高亮关键字前缀
//        query.addHighlightField("prod_username");//         高亮字段
//        query.setHighlightSimplePost("</font>");//后缀

        QueryResponse queryResponse=solrClient.query(query.setQuery(params.toString()));
//        QueryResponse queryResponse=solrClient.query(query);

        long count=queryResponse.getResults().getNumFound();
        System.out.println("总记录数"+count);
        Map<String, Map<String,List<String>>> map=queryResponse.getHighlighting();
        List<User> list=queryResponse.getBeans(User.class);
//        for (User u:list){
//            Map<String,List<String>> map1=map.get(u.getOid());
//            List<String> list1=map1.get("prod_describe");
//            if (list1!=null){
//                String pame=list1.get(0);
//                u.setDescribe(pame);
//            }
//            System.out.println("id"+u.getOid()+"biaot"+u.getDescribe()+"username"+u.getUsername());
//        }
//            if(count==0){
//            params.append(" OR prod_describe:中国" );
//            //query.addFilterQuery("q","prod_introduce:长沙");
//            query.setHighlight(true); // 开启高亮组件或用query.setParam("hl", "true");
//            query.addHighlightField("prod_introduce");// 高亮字段
//            query.addHighlightField("prod_describe");// 高亮字段
//            query.setHighlightSimplePre("<font color='red'>");//标记，高亮关键字前缀
//            query.setHighlightSimplePost("</font>");//后缀
//            System.out.println("没有查询到用户去查询视频");
//            QueryResponse queryResponse1=solrClient.query(query.setQuery(params.toString()));
//            long cou=queryResponse1.getResults().getNumFound();
//            System.out.println("总记录数"+cou);
//            List<User> list=queryResponse1.getBeans(User.class);
//            //获取高亮的数据
//            Map<String, Map<String,List<String>>> map=queryResponse1.getHighlighting();
//            return  R.ok().message(map);
//        }
//        params.append(" OR prod_describe:我爱中国" );
//        //query.addFilterQuery("q","prod_introduce:长沙");

//        System.out.println("没有查询到用户去查询视频");
//        long cou=queryResponse.getResults().getNumFound();
//        System.out.println("总记录数"+cou);

//         queryResponse.getBeans(User.class);
//        List<User> list=queryResponse.getBeans(User.class);
        //获取高亮的数据
//        for (User u:list){
//        System.out.println("用户id"+u.getUserid()+"用户名"+u.getUsername()
//        +"城市"+u.getIntroduce()+"vname");
//        }
//事物提交
       //solrClient.commit();
        Map<String,Object> m=new HashMap<>();
        for (User u:list){
            Map<String,List<String>> map1=map.get(u.getUserid());
            List<String> list1=map1.get("prod_username");
            List<String> list2=map1.get("prod_describe");
            if (list1!=null){
                String pame=list1.get(0);
                u.setUsername(pame);
            }
            if (list2!=null){
                String pame=list2.get(0);
                u.setDescribe(pame);
            }
            System.out.println("id"+u.getOid()+"biaot"+u.getUsername());
            System.out.println("oid"+u.getOid()+"biaot"+u.getDescribe());
            m.put("prod_username1",u.getUsername());
            m.put("prod_describe1",u.getDescribe());
            m.put("id1",u.getOid());
            m.put("oid1",u.getOid());
            System.out.println("集合"+m);
        }
        //System.out.println("map的值"+m);
        return  R.ok().data("ceshi",list);
    }

}
