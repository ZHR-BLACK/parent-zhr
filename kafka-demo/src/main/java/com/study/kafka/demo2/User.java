package com.study.kafka.demo2;

import lombok.Builder;
import lombok.Data;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName User
 * @Date 2023-05-10 15:12
 * @description User
 **/
@Data
@Builder
public class User {

    private String userName;
    private Integer age;
    private Integer sex;
    private String des;

}
