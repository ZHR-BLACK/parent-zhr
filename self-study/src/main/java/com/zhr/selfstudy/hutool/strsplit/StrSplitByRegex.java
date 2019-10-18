package com.zhr.selfstudy.hutool.strsplit;

import cn.hutool.core.text.StrBuilder;
import cn.hutool.core.text.StrSpliter;

import java.util.List;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName StrSplitByRegex
 * @Date 2019-06-27 11:54
 * 用换行符作为分隔符分割字符串,使用正则的方式
 **/
public class StrSplitByRegex {

    public static void main(String[] args) {
        StrBuilder sb = new StrBuilder("");
        sb.append("   aaa \n");
        sb.append("     bbb          \n");
        sb.append("ccc  \n");
        sb.append("\n");
        sb.append("ddd\r\n");
        sb.append("\r\n");
        sb.append("eee\n");

        String text = sb.toString();
        System.out.println("---Original---");
        System.out.println(text);

        // 以换行符作为分隔符
        List<String> split = StrSpliter.splitByRegex(text, "\\r?\\n", 0, true, true);
        System.out.println("split = " + split.size());
        System.out.println("split = " + split);



    }
}
