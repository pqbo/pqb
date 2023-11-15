package com.pqb.controller;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.pqb.utils.ThreadPoolExecuteUtils;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Slf4j
@Controller
@RequestMapping("/cursor")
public class MongoCursorController {

    @Resource
    MongoTemplate mongoTemplate;

    @ResponseBody
    @GetMapping(value = "/getData")
    public void test(){
        log.info("开始执行");
        //创建查询条件
        Query query = new Query();
        //添加查询的条件
        query.addCriteria(Criteria.where("updatetime").gte(1665123622).lte(1667802022));
/*
        //可以指定想要的字段
        Field fields = query.fields();
        fields.include("");
        fields.include("");
*/
        //通过时间升序排序并且没次去3000条
        query.with(Sort.by(Sort.Direction.ASC, "updatetime"));
        //通过游标的方式获取数据集合
        FindIterable<Document> notice_info = mongoTemplate.getCollection("notice_info").find(query.getQueryObject()).batchSize(3000);
        //将数据转换成MongoCursor<Document>
        MongoCursor<Document> cursor = notice_info.iterator();
//        遍历游标中的数据
        while (cursor.hasNext()){
            ThreadPoolExecuteUtils.newExecutorInstance().execute(new Runnable() {
                @Override
                public void run() {
//                    在这里执行主要逻辑通过多线程的方式
                }
            });
        }
        log.info("执行结束");
    }
}
