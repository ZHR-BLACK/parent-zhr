package com.zhr.dbrecord;

import com.jfinal.plugin.activerecord.Db;
import com.zhr.DatabaseInit;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName DbDeleteMain
 * @Date 2020-02-03 11:28
 * @description Db删除表数据的小demo
 **/
public class DbDeleteMain {

    public static void main(String[] args) {
        DatabaseInit.init();

        // 使用sql语句根据日期进行删除表数据
//        String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
//        int delete = Db.delete("delete from user where trans_date = '"+format+"'");
//        System.out.println("delete ********************" + delete);

        // 根据表id删除数据
//        boolean user = Db.deleteById("user", 1);
//        System.out.println("user ********************" + user);

        // amount可以不是主键或者索引键,普通的字段即可
        boolean b = Db.deleteById("user", "amount", 12);
        System.out.println("b ********************" + b);

        // 根据yyyy-MM-dd类型日期删除相关记录
        boolean b1 = Db.deleteById("user", "trans_date", "2020-03-03");
        System.out.println("b1 ********************" + b1);

        // 删除整个表内容
//        Db.update("delete from user");
    }
}
