package com.zhr.selfstudy.lombok.mapstruct;

import com.zhr.selfstudy.lombok.School;
import com.zhr.selfstudy.lombok.UserBean;
import com.zhr.selfstudy.lombok.UserBean2;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName MapStructTest
 * @Date 2023-08-09 17:17
 * @description MapStruct应用
 **/
@Slf4j
public class MapStructTest {

    @Test
    public void test() {
        School school = School.builder().name("好小学").address("幸福大街").build();
        LocalDate now = LocalDate.now();
        UserBean user = UserBean.builder()
                .id(11)
                .userName("张三")
                .myName("好名字")
                .favorite("music")
                .favorite("book")
                .school(school)
                .amount(new BigDecimal("23.42"))
                .createDate(Date.from(Instant.now()))
                .updateDate(now)
                .updateDate2(LocalDateTime.now())
                .build();
        UserBean2 userBean2 = UserConvert.INSTANCE.userBeanToUserBean2(user);
        log.info("userBean2:{}", userBean2);
    }

}
