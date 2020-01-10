package com.zhr.selfstudy.sqlite3;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqliteHelper {

    private static final String Class_Name = "org.sqlite.JDBC";

    private static Logger log = LoggerFactory.getLogger(SqliteHelper.class);


    private static boolean isWindowSys() {
        Properties props = System.getProperties(); //获得系统属性集
        String osName = props.getProperty("os.name"); //操作系统名称
        log.info("Current OS Type :" + osName);
        osName = osName.toLowerCase();
        // 如果系统名称中含有windows就是windows系统
        return osName.indexOf("windows") >= 0;

    }


    private static String getDbFile(String databasePath, String databaseName) {
        String handleBaseDir = databasePath.replaceAll("\\\\", "/");
        log.debug("handleBaseDir is :{}", handleBaseDir);
        if (handleBaseDir.endsWith("/") || handleBaseDir.endsWith("\\")) {
            return new StringBuffer(handleBaseDir)
                    .append(databaseName).append(".db").toString();
        } else {
            return new StringBuffer(handleBaseDir).append("/")
                    .append(databaseName).append(".db").toString();
        }

    }

    /**
     * 获取sqllite连接
     *
     * @return
     */
    private static Connection getConnection(String databaseName) throws SQLException, ClassNotFoundException,
            FileNotFoundException {
        Class.forName(Class_Name);
        Connection conn = null;
        // db所在目录
        String databasePath = "C:/Users/ZHR";
        String dbFile_path = getDbFile(databasePath, databaseName);
        File dbFile = new File(dbFile_path);
        if (dbFile.exists()) {
            log.info("dbFile_path is: {}", dbFile_path);
            String url = "jdbc:sqlite:" + dbFile_path;
            if (isWindowSys()) {
                url = "jdbc:sqlite:/" + dbFile_path.toLowerCase();
            }
            log.debug("sqlite url is:{}", url);
            conn = DriverManager.getConnection(url);
            return conn;
        } else {
            throw new FileNotFoundException();
        }

    }


    /**
     * 执行sql查询
     *
     * @param sql sql select 语句
     *            结果集处理类对象
     * @return 查询结果
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static JSONObject executeQueryOne(String sql, String channelCode) throws SQLException,
            ClassNotFoundException, FileNotFoundException {
        log.debug("sql={}", sql);
        List<JSONObject> list = executeQueryList(sql, channelCode);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    /**
     * 执行select查询，返回结果列表
     *
     * @param sql sql select 语句
     *            结果集的行数据处理类对象
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static List<JSONObject> executeQueryList(String sql, String channelCode) throws SQLException,
            ClassNotFoundException, FileNotFoundException {
        List<JSONObject> rsList = new ArrayList<JSONObject>();
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            conn = getConnection(channelCode);
            statement = conn.createStatement();
            //attach(statement,channelCode);
            resultSet = statement.executeQuery(sql);
            ResultSetMetaData md = resultSet.getMetaData();// 获取键名
            int columnCount = md.getColumnCount();// 获取行的数量
            while (resultSet.next()) {
                JSONObject json = new JSONObject();// 声明Map
                for (int i = 1; i <= columnCount; i++) {
                    json.put(md.getColumnName(i), resultSet.getObject(i));// 获取键名及值
                }
                rsList.add(json);
            }
            return rsList;
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                resultSet.close();
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void attach(Statement statement, String databasePath, String databaseName) {
        try {
            String dbFile = getDbFile(databasePath, databaseName);
            statement.execute("ATTACH DATABASE '" + dbFile + "' AS " + databaseName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
