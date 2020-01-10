package com.zhr.selfstudy.sqlite3;

import com.alibaba.fastjson.JSONObject;

import java.io.FileNotFoundException;
import java.sql.*;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName Sqlite3Test
 * @Date 2019-12-18 10:45
 * @description Sqlite3的增删改查
 **/
public class Sqlite3Test {


    public static void main(String args[]) throws SQLException, FileNotFoundException, ClassNotFoundException {
        JSONObject object = SqliteHelper.executeQueryOne("select * from student where name = '张静'", "zhr");
        System.out.println("object ********************" + object);


    }


}
