package com.zhr.selfstudy.excel;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;

import java.util.List;

public class TestExcelWrite {

    public static void main(String[] args) {
        List<String> row1 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row2 = CollUtil.newArrayList(null, null, null, null);
        List<String> row3 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");

        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3);

        //通过工具类创建writer
        ExcelWriter writer = ExcelUtil.getWriter("C:/Users/ZHR/Desktop/test.xls");

        //一次性写出内容，强制输出标题
        writer.write(rows);
        //关闭writer，释放内存
        writer.close();
    }
}
