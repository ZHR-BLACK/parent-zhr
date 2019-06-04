package com.zhr.selfstudy.lombok;

import lombok.*;

import java.util.List;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName UserBean
 * @Date 2019/5/10 11:04
 * @description 测试lombok配置的bean类
 **/
@Builder
@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public class UserBean {

    private Integer id;
    private String userName;
    // 设置默认值要使用该标签，否则无法与build兼容生效
    @Builder.Default
    private String example = "123456";
    @Singular
    private List<String> favorites;
}



