package com.zhr.es.index;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.indices.CreateIndexResponse;
import co.elastic.clients.elasticsearch.indices.DeleteIndexResponse;
import co.elastic.clients.elasticsearch.indices.GetIndexResponse;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName IndexTest
 * @Date 2023-06-28 16:33
 * @description IndexTest
 **/
@Slf4j
public class IndexTest {

    private RestClient restClient;
    private ElasticsearchTransport transport;

    private ElasticsearchClient client;

    public static final String INDEX_NAME = "newapi";

    @Before
    public void init() {
        // 创建连接
        restClient = RestClient.builder(
                new HttpHost("8.140.51.4", 9200)).build();
        transport = new RestClientTransport(
                restClient, new JacksonJsonpMapper());
        client = new ElasticsearchClient(transport);
    }

    @After
    public void close() throws IOException {
        transport.close();
        restClient.close();
    }

    @Test
    public void createIndex() throws IOException {
        // 创建索引
        CreateIndexResponse createIndexResponse = client.indices().create(c -> c.index(INDEX_NAME));
        // 打印结果
        log.info(String.valueOf(createIndexResponse.acknowledged()));
    }

    @Test
    public void queryIndex() throws IOException {
        GetIndexResponse createIndexResponse = client.indices().get(e -> e.index(INDEX_NAME));
        log.info("queryIndex:{}", String.join(",", createIndexResponse.result().keySet()));
    }

    @Test
    public void deleteIndex() throws IOException {
        DeleteIndexResponse deleteIndexResponse = client.indices().delete(e -> e.index(INDEX_NAME));
        log.info(String.valueOf(deleteIndexResponse.acknowledged()));
    }

}
