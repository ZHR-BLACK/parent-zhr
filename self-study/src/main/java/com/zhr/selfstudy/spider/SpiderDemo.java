package com.zhr.selfstudy.spider;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zhangjing710
 * @description TODO
 * @date 2022/3/7 4:08 下午
 */
public class SpiderDemo {

    //url抓取数据（参数URL：就是你要抓数据的地址。如：http://www.cnev.cn/）
    public static String urlClimb(String url) throws Exception {
        URL getUrl = new URL(url); //创建URl连接
        HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection(); //建立连接
        connection.connect(); //打开连接
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8")); //创建输入流并设置编码
        StringBuffer sb = new StringBuffer();
        String lines = null;
        while ((lines = reader.readLine()) != null) {
            lines = new String(lines.getBytes(), "utf-8"); //读取流的一行,设置编码
            sb = sb.append(lines + "\n");
        }
        reader.close(); //关闭流
        connection.disconnect(); //销毁连接
        return sb.toString(); //返回抓取的数据(注意,这里是抓取了访问的网站的全部数据)
    }

    //正则筛选(抓取了访问的网站的全部数据的字符串,就是上面那两个方法其中一个返回的result)
    public static String choosePattern(String result){
        String regex = "//*[@id=\"sanRoot\"]/main/div[2]/div/div[2]/div[2]/div[2]/a/div[1]/"; //这个正则表达式是取所有span标签
        StringBuffer sb = new StringBuffer();
        //Pattern类编译正则表达式(后面的Pattern静态属性是忽略大小写)
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(result); //Matcher类是搜索匹配内容(下面也简单写上Matcher类的解释)
        while (matcher.find()) {
            sb.append(matcher.group(0)).append("\n"); //匹配整个正则表达式,并返回该行字符串
        }
        return sb.toString(); //把匹配的内容返回
    }

    public static void main(String[] args) throws Exception {
        String s = urlClimb("https://top.baidu.com/buzz?b=1&fr=topindex");
        System.out.println("s = " + s);
        String s1 = choosePattern(s);
        System.out.println("s1 = " + s1);
    }

}
