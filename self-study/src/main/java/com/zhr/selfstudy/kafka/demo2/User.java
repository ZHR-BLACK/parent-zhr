package com.zhr.selfstudy.kafka.demo2;

import lombok.Data;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName User
 * @Date 2023-05-10 15:12
 * @description User
 **/
@Data
public class User {

    private String userName;
    private Integer age;
    private Integer sex;
    private String des;

}
