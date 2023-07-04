package com.zhr.selfstudy.excel.easyexcel.write;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.annotation.ExcelProperty;
import com.zhr.selfstudy.excel.easyexcel.DataBean;
import com.zhr.selfstudy.excel.easyexcel.TestFileUtil;
import org.junit.Test;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName ComplexHeadWriteDemo
 * @Date 2023-06-27 10:12
 * @description 复杂头写入
 **/
public class ComplexHeadWriteTest {

    /**
     * 复杂头写入
     * <p>1. 创建excel对应的实体对象 参照{@link ComplexHeadData}
     * <p>2. 使用{@link ExcelProperty}注解指定复杂的头
     * <p>3. 直接写即可
     */
    @Test
    public void complexHeadWrite() {
        String fileName = TestFileUtil.getPath() + "complexHeadWrite" + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        EasyExcel.write(fileName, ComplexHeadData.class).sheet("模板").doWrite(DataBean.list);
    }
}
