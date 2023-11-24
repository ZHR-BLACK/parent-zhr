package com.zhr.wps.pdf;


import cn.hutool.core.text.StrBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SubstrUtil2 {

    public static int index = 0;

    /**
     * 根据文本宽度进行换行
     */
    public static List<String> autoLineByMaxWidth(String text, int maxWidth, int appointRow, List<String> list) {
        index = 0;
        list = myDrawString(text, maxWidth, appointRow, list);
        return list;
    }

    /**
     * 2、根据宽度截取字符串
     *
     * @param text     文本
     * @param maxWidth 行宽
     * @param maxLine  最大行数
     */
    private static List<String> myDrawString(String text, int maxWidth,
                                             int maxLine, List<String> list) {
        if (text == null || text.length() == 0) {
            return list;
        }
        StrBuilder sb = new StrBuilder();
        for (int i = 0; i < text.length(); i++) {
            char strChar = text.charAt(i);
            sb.append(strChar);
            int stringWidth = sb.toString().length();
            int strLength = text.substring(0, i).length();

            if (strLength >= 53 || strChar == '\n' || stringWidth >= maxWidth) {
                if (strChar == '\n') {
                    i += 1;
                }
                // 清空 sb字符串
                sb.clear();
                if (maxLine > 1) {
                    char value = ' ', value1 = ' ';
                    try {
                        value = text.substring(i).charAt(0);
                        value1 = text.substring(i - 1).charAt(0);
                    } catch (Exception e) {
                        System.err.println("----" + e.getMessage());
                    }
                    if (isChinesePunctuation(value) && checkCharCN(value1)) {
                        list.add(text.substring(0, i - 1));
                        myDrawString(text.substring(i - 1), maxWidth, maxLine - 1, list);
                    } else {
                        list.add(text.substring(0, i));
                        myDrawString(text.substring(i), maxWidth, maxLine - 1, list);
                    }
                    index = index + i;
                } else {
                    list.add(text.substring(0, i));
                    index = index + i;
                }
                return list;
            }
        }
        return list;
    }

    /**
     * 判断字符是否是中文
     *
     * @param c
     * @return
     */
    public static boolean checkCharCN(char c) {
        String s = String.valueOf(c);
        String regex = "[\u4e00-\u9fa5]";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(s);
        return m.matches();
    }

    /**
     * 判断字符是否是中文标点符号
     *
     * @param c
     * @return
     */
    public static boolean isChinesePunctuation(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        return ub == Character.UnicodeBlock.GENERAL_PUNCTUATION || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_FORMS
                || ub == Character.UnicodeBlock.VERTICAL_FORMS;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int appointRow = 10;
        String text = "111122223所以比传统纸巾更环保3334441比传统纸巾更环11111111111111122223565所以比传统纸巾更环保3334441测试数据"
                + "在仿苹果官网垃圾桶时， 设计出的UI使用PingFang SC 字体"
                + "天津市防控指挥部消息称,经排查,滨海新区中新天津纸巾更环保3334441比传统纸巾更环666所以比传统纸巾更环保3334441比传统纸巾更环8888";
        int maxWidth = 500;
        list = autoLineByMaxWidth(text, maxWidth, appointRow, list);
        // 兜底最后一句话
        int length = text.length();
        if (length > index) {
            list.add(text.substring(index));
        }
//        System.out.println("list=" + list);
        list.forEach(System.out::println);
        System.out.println("size:" + list.size());
        int height = 6;
        int fontSize = 14;
        // 总高度 = 总行高 + 总文字高度
        int totalHeight = (list.size() + 1) * height + (fontSize * list.size());
        System.out.println("totalHeight:" + totalHeight);
        // 总宽度 = 文字宽度 + (边宽 * 2)
        int margin = 72;
        System.out.println("totalWidth:" + (maxWidth + margin * 2));
    }
}
