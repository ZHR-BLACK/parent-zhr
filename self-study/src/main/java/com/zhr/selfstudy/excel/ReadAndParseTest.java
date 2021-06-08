package com.zhr.selfstudy.excel;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
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
        Map<String, String> map = new HashMap<>();
        map.put("账号", "phone");
        map.put("店铺名", "shopName");
        reader.setHeaderAlias(map);
        List<ExcelBean> excelBeans = reader.readAll(ExcelBean.class);
        System.out.println("excelBeans = " + excelBeans);
        System.out.println("excelBeans = " + excelBeans.size());

        Map<String, List<String>> phoneMap = new HashMap<>();
        excelBeans.forEach(item -> {
            if (phoneMap.get(item.getPhone()) != null) {
                phoneMap.get(item.getPhone()).add(item.getShopName());
            } else {
                List<String> shopNameList = new ArrayList<>();
                shopNameList.add(item.getShopName());
                phoneMap.put(item.getPhone(), shopNameList);
            }
        });
        System.out.println("phoneMap = " + phoneMap);
        Map<String, List<String>> shopMap = new HashMap<>();

        List<String> bizList = new ArrayList<>();
        phoneMap.forEach((key, value) -> {
            // 根据手机号查询bizId列表，再用bizId列表查询店铺名列表
            List<BizIdBean> list = new ArrayList<>();
            list.forEach(item -> {
                bizList.add(item.getBizId());
            });

        });

    }
}
