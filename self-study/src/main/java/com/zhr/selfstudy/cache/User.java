package com.zhr.selfstudy.cache;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName User
 * @Date 2023-08-01 11:30
 * @description User
 **/
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;

    private String name;

    private Integer age;
}
