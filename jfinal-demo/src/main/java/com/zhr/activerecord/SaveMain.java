package com.zhr.activerecord;

import com.zhr.DatabaseInit;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName SaveMain
 * @Date 2019-11-07 16:47
 * @description 新增数据
 **/
public class SaveMain {

    public static void main(String[] args) {
        DatabaseInit.init();
        // 创建name属性为James,age属性为25的User对象并添加到数据库
        new User().set("name", "James").set("age", 25).save();
    }
}
