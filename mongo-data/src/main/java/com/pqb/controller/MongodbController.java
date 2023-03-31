package com.pqb.controller;

import com.alibaba.fastjson.JSONObject;
import com.pqb.bean.BiddingTypeDetailBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
@Slf4j
@Controller
@RequestMapping("/mongo")
public class MongodbController {
    @Resource
    MongoTemplate mongoTemplate;

    @ResponseBody
    @GetMapping(value = "/getData")
    public String test(){
        Query query = new Query();
//        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(324018157L));
        //通过id去数据库中查是否存在金额存在的话不进行提取
        BiddingTypeDetailBean notice_info = mongoTemplate.findOne(query, BiddingTypeDetailBean.class, "notice_info");
        System.out.println(notice_info.get_id());
        return notice_info.get_id();
    }
}
