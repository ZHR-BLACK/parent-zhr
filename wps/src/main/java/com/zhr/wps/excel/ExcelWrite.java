package com.zhr.wps.excel;

import cn.hutool.core.util.RandomUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName ExcelWrite
 * @Date 2019-10-18 18:00
 * @description poi-ooxml
 * excel写入
 **/
public class ExcelWrite {

    public static void main(String[] args) throws Exception {

        // 写入文件路径
        String path = "D:/zhangjing710/Desktop/" + RandomUtil.randomNumbers(10) + ".xlsx";

        Workbook wb = new HSSFWorkbook();
        // 创建sheet页
        Sheet sheet = wb.createSheet();
        // 创建第一行
        Row row = sheet.createRow(0);
        row.createCell(0, CellType.STRING).setCellValue("企业编号");
        row.createCell(1, CellType.STRING).setCellValue("企业账号");
        // 第二行
        Row row2 = sheet.createRow(1);
        row2.createCell(0, CellType.STRING).setCellValue("11111111111");
        row2.createCell(1, CellType.STRING).setCellValue("222222222222");
        // 写4行,上面空出一行
        Row row3 = sheet.createRow(3);
        row3.createCell(0, CellType.STRING).setCellValue("明细序号");
        row3.createCell(1, CellType.STRING).setCellValue("客户户名");
        row3.createCell(2, CellType.STRING).setCellValue("客户户名2");

        try (OutputStream fileOut = new FileOutputStream(path)) {
            wb.write(fileOut);
        }
        wb.close();
        System.out.println("写入" + path + "完毕.");
    }
}
