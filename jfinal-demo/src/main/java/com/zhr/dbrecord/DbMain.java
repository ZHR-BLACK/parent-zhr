package com.zhr.dbrecord;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.zhr.DatabaseInit;

import java.util.Date;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName DbMain
 * @Date 2019-11-07 14:33
 * @description 添加
 **/
public class DbMain {

    public static void main(String[] args) {
        DatabaseInit.init();
        // 添加数据
        Record user = new Record().set("name", "James").set("age", 25).set("create_date", new Date());
        Db.save("student", user);
    }
}
