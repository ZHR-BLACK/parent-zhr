package com.zhr.selfstudy.utils;

import cn.hutool.core.text.StrBuilder;

/**
 * 字段拼接工具
 */
public class FieldSplicingUtil {

    private String splicing(String[] items) {
        if (!OminiUtils.isNullOrEmpty(items)) {
            StrBuilder buf = new StrBuilder();
            for (String item : items) {
                buf.append(!OminiUtils.isNullOrEmpty(item) ? item : "");
            }
            return buf.toString();
        }
        return "";
    }

}
