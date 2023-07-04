package com.zhr.selfstudy.excel.easyexcel.write;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName ComplexHeadData
 * @Date 2023-06-27 10:11
 * @description 复杂头写入
 **/
@Getter
@Setter
@EqualsAndHashCode
public class ComplexHeadData {

    @ExcelProperty({"主标题", "字符串标题"})
    private String string;
    @ExcelProperty({"主标题", "日期标题"})
    private Date date;
    @ExcelProperty({"主标题", "数字标题"})
    private Double doubleData;

}
