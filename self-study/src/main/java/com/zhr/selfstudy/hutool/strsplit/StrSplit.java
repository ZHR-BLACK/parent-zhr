package com.zhr.selfstudy.hutool.strsplit;

import cn.hutool.core.lang.Console;
import cn.hutool.core.text.StrSpliter;

import java.util.List;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName StrSplit
 * @Date 2019-06-27 9:54
 * 字符串切割
 **/
public class StrSplit {

    /**
     * @Date 2019-06-27 9:55
     * @param  args
     * @return void
     * 分割限制分割数
     * 分割后每个字符串是否需要去掉两端空格
     * 是否忽略空白片
     * 根据固定长度分割
     * 通过正则分隔
     **/
    public static void main(String[] args) {
        String str1 = "a, ,efedsfs,   ddf";
        //参数：被切分字符串，分隔符逗号，0表示无限制分片数，不去除两边空格，忽略空白项
        List<String> split = StrSpliter.split(str1, ',', 0, false, true);
        System.out.println("split = " + split);
        List<String> split2 = StrSpliter.split(str1, ',', 0, true, true);
        System.out.println("split2 = " + split2);

    }
}
