package com.pqb;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import javax.annotation.Resource;

@SpringBootTest
public class test {


    @Autowired
    MongoTemplate mongoTemplate;

    @Test
    public void test(){
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(317112744L));
        JSONObject test = null;
        try {
            test = mongoTemplate.findById(query, JSONObject.class, "test");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(test.toJSONString());
//        return test.toJSONString();
    }
    }


