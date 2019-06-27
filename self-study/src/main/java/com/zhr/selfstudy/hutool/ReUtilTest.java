package com.zhr.selfstudy.hutool;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ReUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName ReUtilTest
 * @Date 2019-06-26 17:02
 * 测试正则
 **/
public class ReUtilTest {

    public static void main(String[] args) {
        // 抽取多个分组然后把它们拼接起来
        String resultExtractMulti = ReUtil.extractMulti("(.*?)年(.*?)月", "2013年5月", "$1-$2");
        System.out.println("resultExtractMulti = " + resultExtractMulti);


        List<String> resultFindAll = ReUtil.findAll("\\w{2}", "ZZZaaa", 0, new ArrayList<String>());
        ArrayList<String> expected = CollectionUtil.newArrayList("ZZ", "Za", "aa");
        System.out.println("expected = " + expected);
        System.out.println("resultFindAll = " + resultFindAll);

    }
}
