package com.zhr.es.doc;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.SortOrder;
import co.elastic.clients.elasticsearch._types.aggregations.Aggregate;
import co.elastic.clients.elasticsearch._types.aggregations.Buckets;
import co.elastic.clients.elasticsearch._types.aggregations.LongTermsAggregate;
import co.elastic.clients.elasticsearch._types.aggregations.LongTermsBucket;
import co.elastic.clients.elasticsearch.core.*;
import co.elastic.clients.elasticsearch.core.bulk.BulkOperation;
import co.elastic.clients.json.JsonData;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import com.alibaba.fastjson.JSON;
import com.zhr.es.bean.Student;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author ZHR
 * @version 1.0
 * @ClassName DocTest
 * @Date 2023-06-28 17:00
 * @description 文档操作
 **/
@Slf4j
public class DocTest {

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
    public void createDoc() throws IOException {
        Student student = Student.builder().name("阿萨达").age(40).sex("男").build();
        // 构建一个创建Doc的请求
        CreateResponse createResponse = client.create(e -> e.index("newapi").id("1004").document(student));
        // 打印请求结果
        System.out.println(createResponse.result());
    }

    @Test
    public void batchCreateDoc() throws IOException {
        // 构建一个批量操作BulkOperation的集合
        List<BulkOperation> bulkOperations = new ArrayList<>();
        // 向集合添加数据
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            bulkOperations.add(new BulkOperation.Builder().create(d -> d.document(new Student("zhangsan" + finalI, "男", 30)).id("3000" + finalI).index("newapi")).build());
        }
        // 使用bulk方法执行批量操作并获得响应
        BulkResponse response = client.bulk(e -> e.index("newapi").operations(bulkOperations));
        // 打印结果
        System.out.println(response.took());
        System.out.println(response.items());
    }

    @Test
    public void batchDeleteDoc() throws IOException {
        // 构建一个批量操作BulkOperation的集合
        List<BulkOperation> bulkOperations = new ArrayList<>();
        // 向集合添加数据
        for (int i = 0; i < 3; i++) {
            int finalI = i;
            bulkOperations.add(new BulkOperation.Builder().delete(d -> d.id("3000" + finalI).index("newapi")).build());
        }
        // 调用客户端的bulk方法，并获取批量操作响应结果
        BulkResponse response = client.bulk(e -> e.index("newapi").operations(bulkOperations));
        System.out.println(response.took());
        System.out.println(response.items());
    }

    @Test
    public void queryPageDoc() throws IOException {
        // 分页查询
        SearchResponse<Student> response3 = client.search(s -> s
                        .index("newapi")
                        .query(q -> q.matchAll(m -> m))
                        .from(0)
                        .size(2)
                , Student.class);
        System.out.println("took:" + response3.took());
        System.out.println("total:" + response3.hits().total().value());
        response3.hits().hits().forEach(e -> System.out.println("hit:" + e.source()));
    }

    @Test
    public void querySortDoc() throws IOException {
        // 查询排序
        SearchResponse<Student> response4 = client.search(s -> s
                        .index("newapi")
                        .query(q -> q
                                .matchAll(m -> m)
                        )
                        .sort(sort -> sort
                                .field(f -> f
                                        .field("age")
                                        .order(SortOrder.Desc)
                                )
                        )
                , Student.class);
        System.out.println(response4.took());
        System.out.println(response4.hits().total().value());
        response4.hits().hits().forEach(e -> System.out.println(e.source().toString()));
    }

    @Test
    public void updateDoc() throws IOException {
        // 构建需要修改的内容，这里使用了Map
        Map<String, Object> map = new HashMap<>();
        map.put("age", 35);
        // 构建修改文档的请求
        UpdateResponse<Student> response = client.update(e -> e.index("newapi").id("1003").doc(map), Student.class);
        // 打印请求结果
        System.out.println(response.result());
    }

    @Test
    public void deleteDoc() throws IOException {
        // 构建删除文档请求
        DeleteResponse response = client.delete(e -> e.index("newapi").id("1001"));
        // 打印请求结果
        System.out.println(response.result());
    }

    /**
     * @author: ZHR
     * @updateTime: 2023-06-28 17:51
     * @description: 使用includes和excludes来标记白名单或黑名单模式，其中includes代表白名单，只返回指定的字段。
     * excludes代表黑名单，不返回指定的字段。
     */
    @Test
    public void cludesDoc() throws IOException {
        // 过滤字段
        SearchResponse<Student> response5 = client.search(s -> s
                        .index("newapi")
                        .query(q -> q
                                .matchAll(m -> m)
                        )
                        .sort(sort -> sort
                                .field(f -> f
                                        .field("age")
                                        .order(SortOrder.Desc)
                                )
                        )
                        .source(source -> source
                                .filter(f -> f
                                        .includes("name")
                                        .excludes("")
                                )
                        )
                , Student.class);
        System.out.println(response5.took());
        System.out.println(response5.hits().total().value());
        response5.hits().hits().forEach(e -> System.out.println(e.source().toString()));
    }

    /**
     * @author: ZHR
     * @updateTime: 2023-06-28 17:53
     * @description: 使用bool下的must或should来代表必须满足某条件或只需满足某条件。
     * elasticsearch在should和must查询时不能精确查出数据，
     * 主要原因是在7.0版本后should查询时minimum_should_match默认为0，查出了非should条件中的数据。
     *
     * minimum_should_match可以控制查询精度，在should和must联合查询查询时必须使用，否则查不出精确的数据。
     * minimum_should_match为1时，表示无管should有多少可选条件子句，至少满足1个条件。
     * minimum_should_match为-1时，负数时，至少满足should可选子句的总数减去此数字应该是必需的。
     *
     * 默认的match搜索会对搜索内容进行分词，比如：mill lane 会分成 mill 和 lane 之后搜索的结果可能包含仅有其中一项的结果，但是此类结果分数较低。
     * 如果不希望被分词而是直接查询短语，可以使用 match_phrase 进行搜索
     */
    @Test
    public void complexQueryDoc() throws IOException {
        // 组合查询
        SearchResponse<Student> response6 = client.search(s -> s
                        .index("newapi")
                        .query(q -> q
                                .bool(b -> b
                                        .must(must -> must
                                                .match(m -> m
                                                        .field("sex")
                                                        .query("男")
                                                )
                                        )
                                        .should(should -> should
                                                .match(m -> m
                                                        .field("age")
                                                        .query(30)
                                                )
                                        )
                                        .should(should -> should
                                                .match(m -> m
                                                        .field("age")
                                                        .query(40)
                                                )
                                        )
                                        .minimumShouldMatch("1")
                                )
                        )
                , Student.class);
        System.out.println(response6.took());
        System.out.println(response6.hits().total().value());
        response6.hits().hits().forEach(e -> System.out.println(e.source().toString()));
    }

    /**
     * @author: ZHR
     * @updateTime: 2023-06-28 18:02
     * @description: 范围查询
     */
    @Test
    public void rangeDoc() throws IOException {
        // 范围查询
        SearchResponse<Student> response7 = client.search(s -> s
                        .index("newapi")
                        .query(q -> q
                                .range(r -> r
                                        .field("age")
                                        .gte(JsonData.of(30))
                                        .lt(JsonData.of(40))
                                )
                        )
                , Student.class);
        System.out.println(response7.took());
        System.out.println(response7.hits().total().value());
        response7.hits().hits().forEach(e -> System.out.println(e.source().toString()));
    }

    /**
     * @author: ZHR
     * @updateTime: 2023-06-28 18:04
     * @description: 其中field代表需要判断的字段名称，value代表需要模糊查询的关键词，
     * fuzziness代表可以与关键词有误差的字数，可选值为0、1、2这三项。
     */
    @Test
    public void fuzzyDoc() throws IOException {
        // 模糊查询
        SearchResponse<Student> response8 = client.search(s -> s
                        .index("newapi")
                        .query(q -> q
                                .fuzzy(f -> f
                                        .field("name")
                                        .value("张")
                                        .fuzziness("1"))
                        )
                , Student.class);
        System.out.println(response8.took());
        System.out.println(response8.hits().total().value());
        response8.hits().hits().forEach(e -> System.out.println(e.source().toString()));
    }
    /**
     * @author: ZHR
     * @updateTime: 2023-06-29 16:30
     * @description: 创建索引时没有对name字段设置类型,默认为text
     * 这样查询中文的时候若不是单字查的话会有问题,需要用下面这种方式来实现like模糊搜索
     * 字段名加上.keyword    字段值加上通配符*
     */
    @Test
    public void fuzzyDoc2() throws IOException {
        // 模糊查询
        SearchResponse<Student> response8 = client.search(s -> s
                        .index("newapi")
                        .query(q -> q
                                .fuzzy(f -> f
                                        .field("name.keyword")
                                        .value("阿萨*")
                                        .fuzziness("AUTO"))
                        )
                , Student.class);
        System.out.println(response8.took());
        System.out.println(response8.hits().total().value());
        response8.hits().hits().forEach(e -> System.out.println(e.source().toString()));
    }

    /**
     * @author: ZHR
     * @updateTime: 2023-06-29 9:48
     * @description: 主要用于给查询出的关键词添加一个标识符，便于前端展示。使用highlight字段，
     * 其中fields的key代表需要标记的字段名称，preTags代表需要添加标记的前缀，postTags代表需要添加标记的后缀
     */
    @Test
    public void highlightDoc() throws IOException {
        // 高亮查询
        SearchResponse<Student> response9 = client.search(s -> s
                        .index("newapi")
                        .query(q -> q
                                .term(t -> t
                                        .field("name")
                                        .value("zhangsan5")
                                )
                        )
                        .highlight(h -> h
                                .fields("name", f -> f
                                        .preTags("<font color='red'>")
                                        .postTags("</font>")
                                )
                        )
                , Student.class);
        System.out.println(response9.took());
        System.out.println(response9.hits().total().value());
        response9.hits().hits().forEach(e -> {
            System.out.println(e.source().toString());
            for (Map.Entry<String, List<String>> entry : e.highlight().entrySet()) {
                System.out.println("Key = " + entry.getKey());
                entry.getValue().forEach(System.out::println);
            }
        });
    }

    /**
     * @author: ZHR
     * @updateTime: 2023-06-29 9:50
     * @description: aggregations方法的key可以自行起名，max代表最大值
     */
    @Test
    public void aggregateDoc() throws IOException {
        // 聚合查询
        SearchResponse<Student> response10 = client.search(s -> s
                        .index("newapi")
                        .aggregations("maxAge", a -> a
                                .max(m -> m
                                        .field("age")
                                )
                        )
                , Student.class);
        System.out.println(response10.took());
        assert response10.hits().total() != null;
        System.out.println(response10.hits().total().value());
        for (Map.Entry<String, Aggregate> entry : response10.aggregations().entrySet()) {
            log.info("key:{},value:{}", entry.getKey(), entry.getValue().max().value());
        }
    }
    /**
     * @author: ZHR
     * @updateTime: 2023-06-29 10:19
     * @description: terms方法来代表分组查询，field传入需要分组的字段，最后通过响应中的aggregations参数来获取，
     * 这里需要根据数据的类型来获取最后的分组结果，我这里因为统计的是数字类型，所以使用LongTermsAggregate来获取结果，
     * 最后打印出docCount属性即可
     */
    @Test
    public void aggregateDoc2() throws IOException {
        // 分组查询
        SearchResponse<Student> response11 = client.search(s -> s
                        .index("newapi")
                        .size(100)
                        .aggregations("ageGroup", a -> a
                                .terms(t -> t
                                        .field("age")
                                )
                        )
                , Student.class);
        System.out.println(response11.took());
        System.out.println(response11.hits().total().value());
        Aggregate aggregate = response11.aggregations().get("ageGroup");
        LongTermsAggregate lterms = aggregate.lterms();
        Buckets<LongTermsBucket> buckets = lterms.buckets();
        for (LongTermsBucket b : buckets.array()) {
            System.out.println(b.key() + " : " + b.docCount());
        }
    }

}
