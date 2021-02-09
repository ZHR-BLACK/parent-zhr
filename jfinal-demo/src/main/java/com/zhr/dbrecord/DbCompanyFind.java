package com.zhr.dbrecord;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.zhr.DatabaseInit;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName DbCompanyFind
 * @Date 2020-06-24 11:16
 * @description todo
 **/
public class DbCompanyFind {


    public static void main(String[] args) {
        DatabaseInit.init();

        Record byId = Db.findByIds("bal_query_instr_queue_lock", "acc_id", 9296);
        System.out.println("byId********************" + byId);

        String sql = "select * from bal_query_instr_queue_lock where acc_id="+ 9296 +" and query_date='2020-04-01'";
        Record first = Db.findFirst(sql);
        System.out.println("first********************" + first);

    }
}
