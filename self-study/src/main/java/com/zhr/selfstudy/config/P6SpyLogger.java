package com.zhr.selfstudy.config;

import cn.hutool.core.util.StrUtil;
import com.p6spy.engine.spy.appender.MessageFormattingStrategy;

/**
 * @author zhangjing
 */
public class P6SpyLogger implements MessageFormattingStrategy {
    @Override
    public String formatMessage(int connectionId, String now, long elapsed, String category,
                                String prepared, String sql, String url) {
        return StrUtil.isNotEmpty(sql) ? now + " 耗时：" + elapsed + "ms " + " 链接信息：" + category + "-" + connectionId +
                "\n执行语言：" + sql.replaceAll("[\\s]+", " ") + "\n" : null;
    }
}
