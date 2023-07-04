package com.zhr.es.index;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.indices.CreateIndexResponse;
import co.elastic.clients.elasticsearch.indices.DeleteIndexResponse;
import co.elastic.clients.elasticsearch.indices.GetIndexResponse;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
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
public class IndexTest {

    private RestClient restClient;
    private ElasticsearchTransport transport;

    private ElasticsearchClient client;

    @Before
    public void init() {
        // 创建连接
        restClient = RestClient.builder(
                new HttpHost("localhost", 9200)).build();
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
        CreateIndexResponse createIndexResponse = client.indices().create(c -> c.index("newapi"));
        // 打印结果
        System.out.println(createIndexResponse.acknowledged());
    }

    @Test
    public void queryIndex() throws IOException {
        GetIndexResponse createIndexResponse = client.indices().get(e -> e.index("newapi"));
        System.out.println("queryIndex:" + String.join(",", createIndexResponse.result().keySet()));
    }

    @Test
    public void deleteIndex() throws IOException {
        DeleteIndexResponse deleteIndexResponse = client.indices().delete(e -> e.index("newapi"));
        System.out.println(deleteIndexResponse.acknowledged());
    }

}
