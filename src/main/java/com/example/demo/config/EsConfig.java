package com.example.demo.config;


import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by Alex on 2018/1/24.
 */
@Configuration
public class EsConfig {

    @Value("${spring.elasticsearch.host}")
    private String host;//elasticsearch的地址

    @Value("${spring.elasticsearch.port}")
    private Integer port;//elasticsearch的端口

    private static final Logger logger = LoggerFactory.getLogger(EsConfig.class);

    @Bean
    public TransportClient esclient() {

        InetSocketTransportAddress node = null;
        try {
//            node = new InetSocketTransportAddress(InetAddress.getByName(host), port);
            node = new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300);
        } catch (UnknownHostException e) {
            e.printStackTrace();
            logger.error("创建elasticsearch客户端失败");
        }
        logger.info("创建elasticsearch客户端成功");
        Settings settings = Settings.builder()
                .put("cluster.name", "wali")
                .build();
        TransportClient client = new PreBuiltTransportClient(settings);
        client.addTransportAddress(node);
        //集群可以new多个地址node 在add进去
        return client;

    }
}
