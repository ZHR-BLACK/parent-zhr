package com.zhr.dbrecord;

import com.jfinal.plugin.activerecord.DbPro;
import com.jfinal.plugin.activerecord.Record;

import java.util.Arrays;
import java.util.List;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName MyDbPro
 * @Date 2019-11-07 14:43
 * @description Db 工具类所有功能都依赖于底层的 DbPro，而 DbPro 可以通过继承来定制自己想要的功能
 * 以上代码扩展了 DbPro 并覆盖了父类的 find(String, Object...) 方法，该方法在调用 super.find(...) 之前输出了 sql 及其 para 值。
 *
 *    然后配置一下即可让 MyDbPro 取代 DbPro 的功能：
 *    ActiveRecordPlugin arp = new ActiveRecordPlugin(...);
 *      arp.setDbProFactory(configName -> new MyDbPro(configName));
 *
 *      通过如上配置，在使用 Db.find(String, Object...) 方法时用到的将是自己在 MyDbPro 中实现的 find 方法。
 **/
public class MyDbPro extends DbPro {

    public MyDbPro(String configName) {
        super(configName);
    }

    public List<Record> find(String sql, Object... paras) {
//        System.out.println("Sql: " + sql);
//        System.out.println("Paras: " + Arrays.toString(paras));
        System.out.println("***************此为DbPro扩展******************");
        return super.find(sql, paras);
    }
}
