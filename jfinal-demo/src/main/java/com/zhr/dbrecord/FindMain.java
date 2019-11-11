package com.zhr.dbrecord;

import com.jfinal.kit.Kv;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.plugin.activerecord.SqlPara;
import com.zhr.DatabaseInit;

import java.util.List;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName FindMain
 * @Date 2019-11-07 14:38
 * @description 查找
 **/
public class FindMain {

    public static void main(String[] args) {
        DatabaseInit.init();

        // 当 select 后的字段只有一个时，可以使用合适的泛型接收数据
        List<String> titleList = Db.query("select name from student");
        System.out.println("titleList ********************" + titleList);

        // 当 select 后的字段有多个时，必须使用 List<Object[]> 接收数据
        List<Object[]> query = Db.query("select name,age from student");
        Object[] objects = query.get(0);
        System.out.println("query ********************" + objects[0]);

        // Db.queryXxx 系方法有：queryInt、queryLong、queryStr 等等，这些方法对于使用聚合函数这类的 sql 十分方便
        int total = Db.queryInt("select count(*) from student");
        System.out.println("total = " + total);

        // Db.queryXxx 系方法要求 select 后面必须只能有一个字段名，或者说只能返回一个 column 值（例如 count(*)）。
        String nickName = Db.queryStr("select name from student where id = ?", 3);
        System.out.println("nickName ********************" + nickName);

        // 查找
        Record record = Db.findByIds("student", "id,name", 1, "张三");
        System.out.println("record ********************" + record);

        List<Record> users = Db.find("select * from student where age > 18");
        System.out.println("users ********************" + users);

        // 设置查询参数
        Kv cond = Kv.by("age", 16).set("name", "宋五");
        //根据标识将参数封装进sql模板并返回完整的sql
        SqlPara sqlpara = Db.getSqlPara("self.findByNameAndAge", cond);
        // 执行查询
        List<Record> list = Db.find(sqlpara);
        System.out.println("list ********************" + list);

        // 根据主键查找
        Record byIds = Db.findByIds("student", "id", 2);
        System.out.println("byIds ********************" + byIds);
    }
}
