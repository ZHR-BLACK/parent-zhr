package com.zhr.selfstudy.excel;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @创建人 zhangjing710
 * @创建时间 2021/2/26 15:26
 * @描述 读取文件内容并返回
 */
public class ReadAndParseTest {

    public static void main(String[] args) throws FileNotFoundException {
        String path = "D:/zhangjing710/Desktop/白名单批量上传模板.xlsx";

        InputStream inputStream = new FileInputStream(path);
        ExcelReader reader = ExcelUtil.getReader(inputStream);
        Map<String,String> map = new HashMap<>();
        map.put("账号","phone");
        map.put("店铺名","shopName");
        reader.setHeaderAlias(map);
        List<ExcelBean> excelBeans = reader.readAll(ExcelBean.class);
        System.out.println("excelBeans = " + excelBeans);
        System.out.println("excelBeans = " + excelBeans.size());

    }
}
