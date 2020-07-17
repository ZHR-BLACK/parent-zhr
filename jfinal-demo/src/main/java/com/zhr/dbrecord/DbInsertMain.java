package com.zhr.dbrecord;

import cn.hutool.core.util.RandomUtil;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.zhr.DatabaseInit;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        add();

        System.out.println("执行完毕********************" + new SimpleDateFormat("yyyy-MM-dd HHmmss").format(new Date()));
    }

    public static void add() {
        List<Record> list = new ArrayList<>(100000);
        for (int i = 0; i < 100000; i++) {
            Record user2 = new Record()
                    .set("name", "张三" + RandomUtil.randomString(4) + i)
                    .set("age", RandomUtil.randomInt(1, 90))
                    .set("amount", RandomUtil.randomBigDecimal(new BigDecimal("10000")))
                    .set("trans_date", new Date())
                    .set("bank_no", RandomUtil.randomString(30));
            list.add(user2);
            try {
                Db.save("user", user2);
//                if (Db.save("user", user2)) {
////                    System.out.println("user2 ********************" + user2);
//                } else {
////                    System.out.println("user2 失败********************" + user2);
//                }
            } catch (Exception e) {
                // 如果唯一索引冲突,会抛异常到这里
                e.printStackTrace();
            }
        }
//        System.out.println("list********************");
//        Db.batchSave("user", list, 100000);
    }
}
