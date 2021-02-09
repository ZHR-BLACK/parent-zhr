package com.zhr;

import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.dialect.MysqlDialect;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.template.source.ClassPathSourceFactory;
import com.zhr.dbrecord.MyDbPro;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName DatabaseInit
 * @Date 2019-11-07 10:12
 * @description 初始化数据源
 **/
public class DatabaseInit {

    public static void init() {
        // 使用JDBC连接MySql时出现：The server time zone value '�й���׼ʱ��' is unrecognized or represents more than one
        // time zone. You must configure either the server or JDBC driver (via the serverTimezone configuration
        // 原因是未加加上serverTimezone=GMT即可解决问题，如果需要使用gmt+8时区，需要写成GMT%2B8
//        DruidPlugin dp = new DruidPlugin("jdbc:mysql://localhost:3306/self?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8&useSSL=false", "root", "root");
//        DruidPlugin dp = new DruidPlugin("jdbc:mysql://111.231.107.12:3306/self?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8&useSSL=false", "zhr", "root");
        DruidPlugin dp = new DruidPlugin("jdbc:mysql://10.1.1.2:3306/corpzone_dev_sunlife?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8&useSSL=false", "cfm", "cfm");

        //        dp.addFilter(new Slf4jLogFilter());
        dp.setMaxActive(10);
        dp.setMaxWait(30000);

        ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);
        arp.setDevMode(true);
        arp.setShowSql(false);
        arp.setDialect(new MysqlDialect());
        arp.setDbProFactory(configName -> new MyDbPro(configName));
        arp.getEngine().setSourceFactory(new ClassPathSourceFactory());
//        arp.setBaseSqlTemplatePath(PathKit.getWebRootPath() + "/sql/mysql");
        arp.addSqlTemplate("/sql/mysql/self.sql");

        // redis
//        RedisPlugin plugin = new RedisPlugin("cfm", "10.1.1.2", 6379);
//        plugin.start();

        // 表的主键名为默认为 "id"，如果主键名称为 "user_id" 则需要手动指定，如：arp.addMapping("user", "user_id", User.class)。
//        arp.addMapping("user", User.class);

        dp.start();
        arp.start();
    }
}
