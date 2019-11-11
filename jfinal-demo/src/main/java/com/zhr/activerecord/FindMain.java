package com.zhr.activerecord;

import com.jfinal.plugin.activerecord.Page;
import com.zhr.DatabaseInit;

import java.util.List;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName Main
 * @Date 2019-11-07 15:50
 * @description todo
 **/
public class FindMain {

    public static void main(String[] args) {
        DatabaseInit.init();

        // 查询id值为25的User将其name属性改为James并更新到数据库
        User.dao.findById(3).set("name", "James").update();

        // 查询id值为25的user, 且仅仅取name与age两个字段的值
        User user = User.dao.findByIdLoadColumns(3, "name, age");
        System.out.println("user******************" + user);

        // 查询所有年龄大于18岁的user
        List<User> users = User.dao.find("select * from user where age>18");
        System.out.println("users******************" + users);

        // 分页查询年龄大于18的user,当前页号为1,每页10个user
        Page<User> userPage = User.dao.paginate(1, 3, "select *", "from user where age > ?", 18);
        System.out.println("userPage******************" + userPage);
    }
}
