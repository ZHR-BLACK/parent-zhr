package com.zhr.db.bean;

import lombok.Data;

import java.io.Serializable;


/**
 * 分页类
 */
@Data
public class PageBase implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 页码（范围1-100）
     */
    private Integer pageIndex = 1;

    /**
     * 每页条数（范围1-100）
     */
    private Integer pageSize = 10;

    /**
     * 获取起始行
     * 通过调该方法，或者使用startRow属性触发调用该方法
     **/
    public int getStartRow() {
        correct();
        return (pageIndex - 1) * pageSize;
    }

    /**
     * 获取结束行
     * 通过调该方法，或者使用endRow属性触发调用该方法
     **/
    public int getEndRow() {
        correct();
        return pageSize;
    }

    /**
     * 分页数值矫正
     **/
    private void correct() {
        if (pageIndex <= 0) {
            pageIndex = 1;
        }
        if (pageSize <= 0) {
            pageSize = 10;
        }
    }
}
