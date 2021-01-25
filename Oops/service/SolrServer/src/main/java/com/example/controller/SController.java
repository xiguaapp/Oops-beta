package com.example.controller;

import com.example.commonutils.R;
import com.example.po.Book;
import com.example.po.UserVideo;
import com.example.server.BookService;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.*;
import org.springframework.data.solr.core.query.result.HighlightEntry;
import org.springframework.data.solr.core.query.result.HighlightPage;
import org.springframework.data.solr.core.query.result.ScoredPage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SController {

    @Autowired
    private BookService bookService;

    @Autowired
    private SolrClient client;
    //https://docs.spring.io/spring-data/solr/docs/current/api/org/springframework/data/solr/core/SolrTemplate.html
    @Autowired
    private SolrTemplate template;

    @RequestMapping("/save")
    public List<Book> add2() throws Exception {
        System.out.println("template:" + template);

        List<Book> list = new ArrayList<>();
        list.add(new Book("Java入门","高斯林","SUN出版社"));
        list.add(new Book("Vue入门","尤大大","阿里出版社"));
        //client.addBeans("accp",list);
        System.err.println(list);
        template.saveBeans("a3200",list);
        template.commit("a3200");
        return list;
    }

    @GetMapping("/save2")
    public String save() {
        List<Book> list = bookService.findAll();
        this.template.saveBeans("a3200", list);
        this.template.commit("a3200");
        return "success";
    }

    /**
     * 根据id删除索引
     * @param id
     * @return
     */
    @RequestMapping("/deleteById/{id}")
    public String delete(@PathVariable String id) {
        try {
            //client.deleteById("accp", id);
            template.deleteByIds("a3200",id);
            template.commit("a3200");
            return id;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }

    /**
     * 删除所有的索引
     * @return
     */
    @RequestMapping("/deleteAll")
    public String deleteAll() {
        try {
            //client.deleteByQuery("accp","*:*");
            //client.commit("mycore");
            Query query = new SimpleQuery("*:*");
            template.delete("a3200", query);
            template.commit("a3200");
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }

    /**
     * 根据id查询索引
     * @return
     * @throws Exception
     */
    @RequestMapping("/getById/{id}")
    public Book getById(@PathVariable String id) throws Exception {
        Optional<Book> optional = template.getById("a3200", id, Book.class);
        return optional.get();
    }

    /**
     * template综合查询: 在综合查询中, 有按条件查询,条件过滤, 排序, 分页
     *
     * @param keywords
     * @return
     */
    @RequestMapping("/find/{keywords}")
    public List<Book> find(@PathVariable String keywords) {

        Query query = new SimpleQuery("*:*");
        //条件
        Criteria cri = new Criteria("keyword");
        //contains: 是相当于数据库中like模糊查询的方式, 将查询关键字当成一个整体进行模糊查询
        //is: 将查询关键字使用对应这个域的分词器进行切分词, 然后将切分出来的每个词, 进行查询.
        //cri.contains(keywords);
        cri.is(keywords);
        //cri = cri.and("book_publish").endsWith("出版社");
        query.addCriteria(cri);
        //分页，默认1-10条
        query.setOffset(0L);    //(pageIndex-1)*pageSize
        query.setRows(2);
        //排序
        query.addSort(Sort.by(Sort.Direction.DESC, "id"));

        ScoredPage<Book> page = template.queryForPage("a3200", query, Book.class);
        for (Book b : page.getContent()) {
            System.out.println("\t"+b.getBook_name()+"\t"+b.getBook_writer()+"\t"+b.getBook_publish());
        }
        System.out.println("总记录：" + page.getTotalElements());
        System.out.println("总页数：" + page.getTotalPages());
        return page.getContent();
    }

    /**
     * template综合查询: 有按条件查询,条件过滤, 排序, 分页, 高亮
     *
     * @param
     * @return
     */
    @RequestMapping("/findBook/{keyword}/{order}/{pageIndex}/{pageSize}")
    public List<Book> findBook(@PathVariable String keyword,@PathVariable String order,
                               @PathVariable Long pageIndex, @PathVariable Integer pageSize) {
        System.out.println("order:"+order);
        //条件 模糊查询  is等值查询
        Criteria cri = new Criteria("keyword").is(keyword);
        //Query query = new SimpleQuery("*:*");
        HighlightQuery query = new SimpleHighlightQuery(cri);
        //分页，默认1-10条
        query.setOffset((pageIndex - 1) * pageSize);
        query.setRows(pageSize);
        //排序
        query.addSort(Sort.by(Sort.Direction.DESC, order));
        //高亮选项
        HighlightOptions ho = new HighlightOptions();
        ho.addField("book_publish");   //高亮域，可以多个
        ho.setSimplePrefix("<em style='color:red'>");
        ho.setSimplePostfix("</em>");
        //为查询对象设置高亮选项
        query.setHighlightOptions(ho);

        //返回高亮页对象
        HighlightPage<Book> hp = template.queryForHighlightPage("a3200", query, Book.class);
        //此时hp.getContent()还是原生内容，没有高亮
        //高亮入口集合（每条记录的高亮入口）
        List<HighlightEntry<Book>> list = hp.getHighlighted();
        for (HighlightEntry<Book> entry : list) {
            //获取高亮域列表（高亮域的个数）
            List<HighlightEntry.Highlight> hl = entry.getHighlights();
            if (hl.size() > 0 && hl.get(0).getSnipplets().size() > 0) {
                Book e = entry.getEntity();
                System.out.println("before:"+e.getBook_publish());
                //假设只一个高亮域
                e.setBook_publish(hl.get(0).getSnipplets().get(0));
                System.out.println("after:"+e.getBook_publish());
            }
        }
        System.out.println("总记录：" + hp.getTotalElements());
        System.out.println("总页数：" + hp.getTotalPages());
        return hp.getContent();
    }
//    @Autowired
//    SolrClient solrClient;
//
//    //添加所有
//    @RequestMapping("/cessss")
//    public R cessss() throws IOException, SolrServerException {
//        System.out.println("使用消息中间件");
//        List<UserVideo> userVideos=bookService.allsolr();
//        System.out.println("集合"+userVideos);
//        solrClient.addBean(userVideos);
//        //事物提交
//        solrClient.commit();
//        return R.ok();
//    }

}
