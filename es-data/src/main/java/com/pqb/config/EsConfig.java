package com.pqb.config;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * 类作用: Elasticsearch配置类
 * 类名称: ElasticsearchMonitorConfig
 * 类描述: Elasticsearch配置类
 *
 * @author wangchen
 */
@Configuration
public class EsConfig {
    @Autowired
    private EsProperties esProperties;

    @Bean(name = "highLevelClient")
    public RestHighLevelClient restHighLevelClient() {
        String[] urlArr = esProperties.getEsAddress().split(",");
        HttpHost[] httpPostArr = new HttpHost[urlArr.length];
        for (int i = 0; i < urlArr.length; i++) {
            HttpHost httpHost = new HttpHost(urlArr[i].split(":")[0].trim(),
                    Integer.parseInt(urlArr[i].split(":")[1].trim()), "http");
            httpPostArr[i] = httpHost;
        }
        RestClientBuilder builder = RestClient.builder(httpPostArr);
        // 异步httpclient连接延时配置
        builder.setRequestConfigCallback(requestConfigBuilder -> {
            requestConfigBuilder.setConnectTimeout(esProperties.getConnectTimeOut());
            requestConfigBuilder.setSocketTimeout(esProperties.getSocketTimeOut());
            requestConfigBuilder.setConnectionRequestTimeout(esProperties.getConnectionRequestTimeOut());
//            HttpHost proxy = new HttpHost("127.0.0.1", 22, "http");
//            requestConfigBuilder.setProxy(proxy);
            return requestConfigBuilder;
        });

        // 异步httpclient配置
        builder.setHttpClientConfigCallback(httpClientBuilder -> {
            // httpclient连接数配置
            httpClientBuilder.setMaxConnTotal(esProperties.getMaxConnectNum());
            httpClientBuilder.setMaxConnPerRoute(esProperties.getMaxConnectPerRoute());
            // httpclient保活策略 (调用 自定义保持连接的策略 )
            httpClientBuilder.setKeepAliveStrategy(
                    CustomConnectionKeepAliveStrategy.getInstance(esProperties.getKeepAliveMinutes()));
            return httpClientBuilder;
        });
        return new RestHighLevelClient(builder);
    }
}