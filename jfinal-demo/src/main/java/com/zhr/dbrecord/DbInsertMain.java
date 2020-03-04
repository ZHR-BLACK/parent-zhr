package com.zhr.dbrecord;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.zhr.DatabaseInit;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName DbMain
 * @Date 2019-11-07 14:33
 * @description 添加表数据
 **/
public class DbInsertMain {

    public static void main(String[] args) {
        DatabaseInit.init();
        // 添加数据
//        Record user = new Record().set("name", "James").set("age", 25).set("create_date", new Date());
//        Db.save("student", user);

        Record user2 = new Record().set("name", "张三").set("age", 23).set("amount", 213);
        try {
            if (Db.save("user", user2)) {
                System.out.println("user2 ********************" + user2);
            } else {
                System.out.println("user2 失败********************" + user2);
            }
        } catch (Exception e) {
            // 如果唯一索引冲突,会抛异常到这里
            e.printStackTrace();
        }
        System.out.println("执行完毕********************");
    }
}
