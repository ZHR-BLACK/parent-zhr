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
 * @description Db删除的小demo
 **/
public class DbDeleteMain {

    public static void main(String[] args) {
        DatabaseInit.init();

        // 根据日期进行删除表数据
        String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        int delete = Db.delete("delete from user where trans_date = '"+format+"'");
        System.out.println("delete ********************" + delete);
        // 删除整个表内容
//        Db.update("delete from user");
    }
}
