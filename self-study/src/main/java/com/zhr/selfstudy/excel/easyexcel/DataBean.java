package com.zhr.selfstudy.excel.easyexcel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName DataBean
 * @Date 2023-06-27 10:13
 * @description 造数据
 **/
public class DataBean {

    public static List<DemoData> list = new ArrayList<>();

    static {
        for (int i = 0; i < 10; i++) {
            DemoData data = new DemoData();
            data.setString("字符串" + i);
            data.setDate(new Date());
            data.setDoubleData(0.56);
            list.add(data);
        }
    }

}
