package com.zhr.selfstudy.javadoc;

/**
 * 测试注释内容
 * <p>这是一段注释</p>
 *
 * @author ZHR
 * @version 1.0
 * @Date 2019/6/4 14:48
 * @since 1.6
 * @javadoc 这是javadoc文档
 *
 **/
public class Documentation {

    /**
     *  这是成员变量
     **/
    public String name;

    /**
     * @author ZHR
     * @param name 姓名
     * @param m 数值
     * @return String 字符串
     * @throws Exception 异常
     * @Date 2019/6/4 14:48
     **/
    public String function(String name,int m) throws Exception{
        return name;
    }

}
