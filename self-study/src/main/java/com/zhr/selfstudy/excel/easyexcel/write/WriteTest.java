package com.zhr.selfstudy.excel.easyexcel.write;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.zhr.selfstudy.excel.easyexcel.DataBean;
import com.zhr.selfstudy.excel.easyexcel.DemoData;
import com.zhr.selfstudy.excel.easyexcel.TestFileUtil;
import org.junit.Test;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName WriteMain
 * @Date 2023-06-26 16:53
 * @description 写excel
 **/
public class WriteTest {

    @Test
    public void test1() {
        // 注意 simpleWrite在数据量不大的情况下可以使用（5000以内，具体也要看实际情况），数据量大参照 重复多次写入

        // 写法1 JDK8+
        // since: 3.0.0-beta1
        String fileName = TestFileUtil.getPath() + "simpleWrite" + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
//        EasyExcel.write(fileName, DemoData.class)
//                .sheet("模板")
//                .doWrite(() -> {
//                    // 分页查询数据
//                    return DataBean.list;
//                });
//
//        // 写法2
//        fileName = TestFileUtil.getPath() + "simpleWrite" + System.currentTimeMillis() + ".xlsx";
//        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
//        // 如果这里想使用03 则 传入excelType参数即可
//        EasyExcel.write(fileName, DemoData.class).sheet("模板").doWrite(DataBean.list);

        // 写法3
        fileName = TestFileUtil.getPath() + "simpleWrite" + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写
        try (ExcelWriter excelWriter = EasyExcel.write(fileName, DemoData.class).build()) {
            WriteSheet writeSheet = EasyExcel.writerSheet("模板").build();
            excelWriter.write(DataBean.list, writeSheet);
        }
    }
}
