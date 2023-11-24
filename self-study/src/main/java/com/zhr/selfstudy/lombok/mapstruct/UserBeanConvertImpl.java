package com.zhr.selfstudy.lombok.mapstruct;

import com.zhr.selfstudy.lombok.UserBean;
import com.zhr.selfstudy.lombok.UserBean2;

import java.util.ArrayList;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName UserConvertImpl
 * @Date 2023-08-09 17:25
 * @description UserBeanConvertImpl
 **/
public class UserBeanConvertImpl implements UserConvert {

    @Override
    public UserBean2 userBeanToUserBean2(UserBean userBean) {
        if (userBean == null) {
            return null;
        }
        UserBean2.UserBean2Builder builder = UserBean2.builder()
                .createDate(userBean.getCreateDate());

        return builder.build();
    }
}
