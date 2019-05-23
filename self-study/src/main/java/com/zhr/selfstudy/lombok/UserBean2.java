package com.zhr.selfstudy.lombok;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName UserBean2
 * @Date 2019/5/10 11:23
 * @description Accessors
 * 访问器模式，是给一个普通的Bean增加一个便捷的访问器，包括读和写。
 * 它有两种工作模式，fluent和chain
 **/
@Accessors(fluent = true)
@Data
public class UserBean2 {

    private Integer id;

    private String userName;

    private String password;

}
