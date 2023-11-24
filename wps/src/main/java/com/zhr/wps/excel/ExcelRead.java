package com.zhr.wps.excel;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;

import java.util.List;

/**
 * @创建人 zhangjing710
 * @创建时间 2021/2/22 11:37
 * @描述 excel读取
 */
public class ExcelRead {

    public static void main(String[] args) {
        String path = "D:/zhangjing710/Desktop/6709872538.xlsx";

        ExcelReader reader = ExcelUtil.getReader(path);
        List<List<Object>> read = reader.read();
        System.out.println("read = " + read);
    }
}
