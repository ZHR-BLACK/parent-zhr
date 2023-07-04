package com.zhr.es;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.indices.CreateIndexResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName IndexTest
 * @Date 2023-06-28 16:28
 * @description IndexTest
 **/
@SpringBootTest(classes = {EsApplication.class})
@RunWith(SpringRunner.class)
public class JunitIndexTest {

    @Autowired
    private ElasticsearchClient restClient;

    @Test
    public void createIndex() throws IOException {
        // 创建索引
        CreateIndexResponse createIndexResponse = restClient.indices().create(c -> c.index("newapi"));
        // 打印结果
        System.out.println(createIndexResponse.acknowledged());
    }

}
