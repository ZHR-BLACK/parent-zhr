package com.zhr.selfstudy.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName RegexDemo
 * @Date 2019-10-21 14:35
 * 元字符	说明
 * .	    匹配除换行符以外的任意字符
 * \w	    匹配字母或数字或下划线或汉字
 * \s	    匹配任意的空白符
 * \d	    匹配数字
 * \b	    匹配单词的开始或结束
 * ^	    匹配字符串的开始
 * $	    匹配字符串的结束
 * <p>
 * 语法	    说明
 * *	    重复零次或更多次
 * +	    重复一次或更多次
 * ?	    重复零次或一次
 * {n}	    重复n次
 * {n,}	    重复n次或更多次
 * {n,m}	重复n到m次
 * <p>
 * 用小括号()来做分组，也就是括号中的内容作为一个整体
 * 在要转义的字符前面加个斜杠，也就是\即可,如要匹配以(ab)开头：^(\(ab\))*
 * 用符号 | 来表示或，也叫做分支条件，当满足正则里的分支条件的任何一种条件时，都会当成是匹配成功.^(130|131|132|155|156|185|186|145|176)\d{8}$
 * <p>
 * 正则提供一个元字符中括号 [] 来表示区间条件。
 * 1. 限定0到9 可以写成[0-9]
 * 2. 限定A-Z 写成[A-Z]
 * 3. 限定某些数字 [165]
 * 上面电话表达式可简化为:^((13[0-2])|(15[56])|(18[5-6])|145|176)\d{8}$
 **/
public class RegexDemo {

    public static void main(String[] args) {
        // 1. 正向先行断言（正前瞻）:
        //• 语法：（?=pattern）
        //• 作用：匹配pattern表达式的前面内容，不返回本身。
        String test = "<span class=\"read-count\">阅读数：641</span>";
        String reg = "\\d+(?=</span>)";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(test);
        while (matcher.find()) {
            System.out.println("正向先行断言（正前瞻）:" + matcher.group());
        }

        // 2. 正向后行断言（正后顾）:
        //• 语法：（?<=pattern）
        //• 作用：匹配pattern表达式的后面的内容，不返回本身。
        String regAfter = "(?<=<span class=\"read-count\">阅读数：)\\d+";
        Pattern compile = Pattern.compile(regAfter);
        Matcher matcher1 = compile.matcher(test);
        while (matcher1.find()) {
            System.out.println("正向后行断言（正后顾）:" + matcher1.group());
        }

        // 3. 负向先行断言（负前瞻）
        //• 语法：(?!pattern)
        //• 作用：匹配非pattern表达式的前面内容，不返回本身。
        String test3 = "我爱祖国，我是祖国的花朵";
        // 找到不是的花朵前面的祖国
        String reg3 = "祖国(?!的花朵)";
        Pattern compile3 = Pattern.compile(reg3);
        Matcher matcher3 = compile3.matcher(test3);
        while (matcher3.find()) {
            System.out.println("负向先行断言（负前瞻）:" + matcher3.group());
        }

        // 4. 负向后行断言（负后顾）
        //• 语法：(?<!pattern)
        //作用：匹配非pattern表达式的后面内容，不返回本身





    }


}
