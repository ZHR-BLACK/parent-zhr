package com.zhr.selfstudy.lombok;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName School
 * @Date 2023-08-10 9:15
 * @description School
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class School {

    private String name;

    private String address;

}
