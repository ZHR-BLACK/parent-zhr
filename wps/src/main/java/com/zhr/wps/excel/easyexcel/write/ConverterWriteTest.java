package com.zhr.wps.excel.easyexcel.write;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.annotation.ExcelProperty;
import com.zhr.wps.excel.easyexcel.ConverterData;
import com.zhr.wps.excel.easyexcel.DataBean;
import com.zhr.wps.excel.easyexcel.TestFileUtil;
import org.junit.Test;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName ConverterWriteTest
 * @Date 2023-06-27 13:31
 * @description 日期、数字或者自定义格式转换
 **/
public class ConverterWriteTest {

    /**
     * 日期、数字或者自定义格式转换
     * <p>1. 创建excel对应的实体对象 参照{@link ConverterData}
     * <p>2. 使用{@link ExcelProperty}配合使用注解{@link DateTimeFormat}、{@link NumberFormat}或者自定义注解
     * <p>3. 直接写即可
     */
    @Test
    public void converterWrite() {
        String fileName = TestFileUtil.getPath() + "converterWrite" + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        EasyExcel.write(fileName, ConverterData.class).sheet("模板").doWrite(DataBean.list);
    }
}
