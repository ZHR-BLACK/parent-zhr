package com.zhr.dbrecord;

import com.jfinal.kit.Kv;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.plugin.activerecord.SqlPara;
import com.zhr.DatabaseInit;
import org.joda.time.DateTime;

import java.util.Date;
import java.util.List;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName JfinalDemo
 * @Date 2019-11-07 10:05
 * @description 测试Db操作数据库
 **/
public class JfinalDemo {

    public static void main(String[] args) {
        DatabaseInit.init();


        // 根据主键查找
        Record byIds = Db.findByIds("student", "id", 2);
        System.out.println("byIds = " + byIds);

        // 修改数据
        byIds.set("name", "李四" + new DateTime(new Date()).toString("HHmmss"));
        byIds.set("create_date", new Date());
        Db.update("student", "id", byIds);

    }


}
