package com.zhr.selfstudy.regex;

import com.zhr.selfstudy.PrintDiy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName RegexGroupDemo
 * @Date 2019-10-21 15:14
 * @description todo
 **/
public class RegexGroupDemo {

    public static void main(String[] args) {
        PrintDiy.printSign("数字编号捕获组");
        // 数字编号捕获组：
        //语法：(exp)
        //解释：从表达式左侧开始，每出现一个左括号和它对应的右括号之间的内容为一个分组，在分组中，第0组为整个表达式，第一组开始为分组。
        String test = "020-85653333";
        String reg = "(0\\d{2})-(\\d{8})";
        Pattern pattern = Pattern.compile(reg);
        Matcher mc = pattern.matcher(test);
        if (mc.find()) {
            System.out.println("分组的个数有：" + mc.groupCount());
            for (int i = 0; i <= mc.groupCount(); i++) {
                System.out.println("第" + i + "个分组为：" + mc.group(i));
            }
        }

        PrintDiy.printSign("命名编号捕获组");
        // 命名编号捕获组：
        //语法：(?<name>exp)
        //解释：分组的命名由表达式中的name指定
        //比如区号也可以这样写:(?<quhao>\0\d{2})-(?<haoma>\d{8})
        // 在默认情况下都是以数字来命名，而且数字命名的顺序是从1开始的
        String test2 = "020-85653333";
        String reg2 = "(?<quhao>0\\d{2})-(?<haoma>\\d{8})";
        Pattern pattern2 = Pattern.compile(reg2);
        Matcher mc2 = pattern2.matcher(test2);
        if (mc2.find()) {
            System.out.println("分组的个数有：" + mc2.groupCount());
            System.out.println(mc2.group("quhao"));
            System.out.println(mc2.group("haoma"));
        }

        PrintDiy.printSign("非捕获组");
        // 3. 非捕获组：
        //语法：(?:exp)
        //解释：和捕获组刚好相反，它用来标识那些不需要捕获的分组，说的通俗一点，就是你可以根据需要去保存你的分组。
        String test3 = "020-85653333";
        String reg3 = "(?:0\\d{2})-(\\d{8})";
        Pattern pattern3 = Pattern.compile(reg3);
        Matcher mc3 = pattern3.matcher(test3);
        if (mc3.find()) {
            System.out.println("分组的个数有：" + mc3.groupCount());
            for (int i = 0; i <= mc3.groupCount(); i++) {
                System.out.println("第" + i + "个分组为：" + mc3.group(i));
            }
        }

    }
}
