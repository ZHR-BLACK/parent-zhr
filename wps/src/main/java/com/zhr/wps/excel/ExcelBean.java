package com.zhr.wps.excel;

import lombok.Data;

/**
 * @创建人 zhangjing710
 * @创建时间 2021/2/26 15:57
 * @描述
 */
@Data
public class ExcelBean {

    private String phone;

    private String shopName;
    // 0-不存在    1-存在
//    private int existed = 0;

    private String bizId;

    private String bpin;
}
