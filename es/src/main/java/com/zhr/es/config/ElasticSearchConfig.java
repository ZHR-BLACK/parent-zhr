package com.zhr.es.config;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName ElasticSearchConfig
 * @Date 2023-06-28 14:29
 * @description 配置类
 **/
@Configuration
public class ElasticSearchConfig {

//    @Value("${spring.elasticsearch.rest.host}")
//    private String host;
//    @Value("${spring.elasticsearch.rest.enable:true}")
//    private boolean enable;
//
//    @Value("${spring.elasticsearch.rest.port}")
//    private int port;
//    @Value("${spring.elasticsearch.rest.username}")
//    private String userName;
//
//    @Value("${spring.elasticsearch.rest.password}")
//    private String passWord;


    //注入IOC容器
//    @Bean
//    public ElasticsearchClient elasticsearchClient() {
//        ElasticsearchClient client = new ElasticsearchClient(null);
//        if (enable) {
//            final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
//            //设置账号密码
//            credentialsProvider.setCredentials(
//                    AuthScope.ANY, new UsernamePasswordCredentials(userName, passWord));
//
//            RestClient restClient = RestClient.builder(new HttpHost(host, port))
//                    .setHttpClientConfigCallback(httpClientBuilder -> httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider)).build();
//
//            ElasticsearchTransport transport = new RestClientTransport(restClient, new JacksonJsonpMapper());
//            // And create the API client
//            client = new ElasticsearchClient(transport);
//        }
//        return client;
//    }

    @Bean("restClient")
    public ElasticsearchClient elasticsearchClient() {
        RestClient httpClient = RestClient.builder(new HttpHost("127.0.0.1", 9200)).build();
        // 不引用jakarta.json-api时，此行会报错
        ElasticsearchTransport transport = new RestClientTransport(httpClient, new JacksonJsonpMapper());
        return new ElasticsearchClient(transport);
    }

}
