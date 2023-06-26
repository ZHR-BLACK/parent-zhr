package com.zhr.db.dao.table;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @创建人 zhangjing710
 * @创建时间 2021/2/9 15:24
 * @描述
 */
@Data
@TableName("t_student")
public class StudentDo{

    private Long id;

    private String name;

    private int age;

    private BigDecimal amount;

    private Date createDate;

    private Date endDate;
}
