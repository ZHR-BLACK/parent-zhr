package com.zhr.selfstudy.excel;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @创建人 zhangjing710
 * @创建时间 2021/2/26 16:37
 * @描述 下载excel文件
 */
@RestController
@RequestMapping("/file")
public class ExcelController {

    @RequestMapping(value = "/downloadModelExcel", method = RequestMethod.GET)
    public void downloadModelExcel(HttpServletResponse response) {
        ServletOutputStream servletOutputStream = null;
        InputStream inputStream = null;
        try {
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            // web下载excel，文件中文名会被替换为下划线,加上下面这句即可
            String encodeFilename = URLEncoder.encode("失败", StandardCharsets.UTF_8.toString());
            response.setHeader("Content-Disposition", "attachment;fileName=" + encodeFilename + ".xls");
            servletOutputStream = response.getOutputStream();

            String path = "D:/zhangjing710/Desktop/白名单批量上传模板.xlsx";
            inputStream = new FileInputStream(path);
            ExcelReader reader = ExcelUtil.getReader(inputStream);
            Map<String,String> map = new HashMap<>();
            map.put("账号","phone");
            map.put("店铺名","shopName");
            reader.setHeaderAlias(map);
            // 读取到List<ExcelBean>中
            List<ExcelBean> excelBeans = reader.readAll(ExcelBean.class);
            System.out.println("excelBeans = " + excelBeans);
            System.out.println("excelBeans = " + excelBeans.size());

            List<ExcelBean> failList = new ArrayList<>();
            failList.add(excelBeans.get(2));
            failList.add(excelBeans.get(3));

            ExcelWriter writer = ExcelUtil.getWriter();
            // 设置表头对应关系
            writer.addHeaderAlias("phone","账号");
            writer.addHeaderAlias("shopName","店铺名");
            writer.write(failList,true);
            writer.flush(servletOutputStream);
            writer.close();

            response.flushBuffer();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (servletOutputStream != null) {
                    servletOutputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
