package com.pqb.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 读取参数
 * @author wangchen
 */
@Component
@ConfigurationProperties(prefix = "elasticsearch")
@Data
public class EsProperties {

    /**
     * esAddress.
     */
    private String esAddress;

    /**
     * 连接超时时间
     */
    private int connectTimeOut;
    /**
     * 连接超时时间
     */
    private int socketTimeOut;
    /**
     * 获取连接的超时时间
     */
    private int connectionRequestTimeOut;
    /**
     * 最大连接数
     */
    private int maxConnectNum;
    /**
     * 最大路由连接数
     */
    private int maxConnectPerRoute;

    /**
     * keepAlive保活策略
     */
    private int keepAliveMinutes;
}
