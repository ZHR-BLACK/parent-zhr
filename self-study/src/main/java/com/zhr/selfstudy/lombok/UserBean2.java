package com.zhr.selfstudy.lombok;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName UserBean2
 * @Date 2019/5/10 11:23
 * @description Accessors
 * 访问器模式，是给一个普通的Bean增加一个便捷的访问器，包括读和写。
 * 它有两种工作模式，fluent和chain
 **/
@Builder
@Accessors(fluent = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserBean2 {

    private Integer id;

    private String userName;

    private String password;

    private List<String> favorites;

    private String ownName;

    private School school;

    private BigDecimal amount;

    private Date createDate;

    private LocalDate updateDate;

    private LocalDateTime updateDate2;

}
