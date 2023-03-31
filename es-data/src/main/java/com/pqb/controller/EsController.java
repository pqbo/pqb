package com.pqb.controller;



import cn.hutool.core.io.FileUtil;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.io.FileUtils;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.script.Script;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.ScriptSortBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@Slf4j
@Controller
@RequestMapping("/es")
public class EsController {

    @Autowired
    RestHighLevelClient highLevelClient;

//    @ResponseBody
//    @GetMapping(value = "/getData")
//    public ArrayList<JSONObject> test(){
//        SearchRequest searchRequest = new SearchRequest(JOB_IDX);
//        // 2.创建一个SearchSourceBuilder专门用于构建查询条件
//        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//
//// 3.使用QueryBuilders.multiMatchQuery构建一个查询条件（搜索title、jd），并配置到SearchSourceBuilder
//        MultiMatchQueryBuilder multiMatchQueryBuilder = QueryBuilders.multiMatchQuery(keywords, "title", "jd");
//
//// 将查询条件设置到查询请求构建器中
//        searchSourceBuilder.query(multiMatchQueryBuilder);
//
//// 4.调用SearchRequest.source将查询条件设置到检索请求
//        searchRequest.source(searchSourceBuilder);
//
//// 5.执行RestHighLevelClient.search发起请求
//        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
//        SearchHit[] hitArray = searchResponse.getHits().getHits();
//
//// 6.遍历结果
//        ArrayList<JSONObject> jobDetailArrayList = new ArrayList<>();
//
//        return jobDetailArrayList;
//
//    }
//    @ResponseBody
//    @GetMapping(value = "/getData")
     public void randomUnitNature(Long start,Long end,String filename) {

        //创建一个搜索
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();


//        BoolQueryBuilder qb = QueryBuilders.boolQuery();

        BoolQueryBuilder totalFilter = QueryBuilders.boolQuery()

                .filter(QueryBuilders.rangeQuery("updatetime").gte(start).lt(end))
//                .filter(QueryBuilders.rangeQuery("notice_segment_type").gte(10).lt(11))
//                .filter(QueryBuilders.rangeQuery("catid").gte(0).lte(100 ));
//        .filter(QueryBuilders.rangeQuery("updatetime").gte(start).lte(end))
                .filter(QueryBuilders.rangeQuery("progid").gte(3).lt(6 ));
//
//                .filter(QueryBuilders.termQuery("progid", 3));


        sourceBuilder.query(totalFilter);

        sourceBuilder.size(3000);

        sourceBuilder.fetchSource(new String[]{"id"}, null);


        Script script = new Script("Math.random()");

        ScriptSortBuilder sortBuilder = new ScriptSortBuilder(script, ScriptSortBuilder.ScriptSortType.NUMBER);

        sourceBuilder.sort(sortBuilder);


        SearchRequest searchRequest = new SearchRequest();

        searchRequest.indices("notice_info");

        searchRequest.source(sourceBuilder);


        SearchResponse searchResponse = null;

        try {

            searchResponse = highLevelClient.search(searchRequest, RequestOptions.DEFAULT);

        } catch (IOException e) {

            throw new RuntimeException(e);

        }


        SearchHit[] res = searchResponse.getHits().getHits();

         File file = new File(filename);
         for (SearchHit searchHit : res) {
            JSONObject record = JSONObject.parseObject(searchHit.getSourceAsString());
            FileUtil.appendUtf8String(String.valueOf(record.getString("id"))+"\n",file);
        }

        System.out.println("结束");
    }
    @ResponseBody
    @GetMapping(value = "/getData")
    public void getdata() throws Exception{
//        Long start =1643644800L;
//        for (int i = 0; i < 38; i++) {
//            Long end = start+86400L;
//            log.info(start+"-------------"+end);
//            randomUnitNature(start,end,"D:\\"+i+".txt");
//            start =end;
//        }
        randomUnitNature(1616811261L,1641015633L,"D:\\i11110.txt");
    }
}



