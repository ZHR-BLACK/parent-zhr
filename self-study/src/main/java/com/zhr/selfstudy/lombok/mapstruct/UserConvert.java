package com.zhr.selfstudy.lombok.mapstruct;

import com.zhr.selfstudy.lombok.UserBean;
import com.zhr.selfstudy.lombok.UserBean2;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserConvert {

    UserConvert INSTANCE = Mappers.getMapper(UserConvert.class);

    /**
     * @author: ZHR
     * @param: userBean
     * @updateTime: 2023-08-10 9:18
     * @return: com.zhr.selfstudy.lombok.UserBean2
     * @description: 集合类型，实体类，名称不一致属性,日期 都得明确使用Mapping指定转换
     * 直接Mapping转换Date类型字段会不准确
     */
    @Mapping(source = "myName", target = "ownName")
    @Mapping(source = "favorites", target = "favorites")
    @Mapping(source = "school", target = "school")
    @Mapping(source = "updateDate", target = "updateDate")
    @Mapping(source = "updateDate2", target = "updateDate2")
    UserBean2 userBeanToUserBean2(UserBean userBean);

}
