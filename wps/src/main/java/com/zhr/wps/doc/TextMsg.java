package com.zhr.wps.doc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jing.zhang31
 * @ClassName TextMsg
 * @description: TextMsg
 * @date 2023年08月28日
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TextMsg {

    /**
     * 当前是第index个span标签文本
     */
    private Integer index;
    /**
     * span标签包含的文本
     */
    private String text;
    /**
     * span标签中class的值
     */
    private String classVal;
    /**
     * span标签在整个字符串根据span标签拆分后的index
     */
    private Integer spanIndex;
}
