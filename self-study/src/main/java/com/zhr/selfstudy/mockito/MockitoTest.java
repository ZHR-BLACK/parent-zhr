package com.zhr.selfstudy.mockito;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Mockito.when;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName MockitoTest
 * @Date 2020-01-08 15:46
 * @description Mockito的一些运用
 *
 * <dependency>
 * <groupId>org.mockito</groupId>
 * <artifactId>mockito-core</artifactId>
 * <version>3.1.0</version>
 * </dependency>
 **/
@Slf4j
public class MockitoTest {

    /**
     * @author: ZHR
     * @updateTime: 2023-09-04 17:20
     * @description: 普通的mock 模拟
     */
    @Test
    public void normMock() {
        List list = Mockito.mock(List.class);
        //mock实例
        when(list.size()).thenReturn(5);
        when(list.get(ArgumentMatchers.anyInt())).thenReturn("element");

        log.info("size:{}", list.size());
        log.info("item:{}", list.get(5));
    }

    /**
     * @author: ZHR
     * @updateTime: 2023-09-04 17:13
     * @description: Mockito 静态方法  需要导入 mockito-inline包
     */
    @Test
    public void staticMock() {
        Mockito.mockStatic(StaticClass.class);
        when(StaticClass.reverse(ArgumentMatchers.anyInt())).thenReturn(5);
        int reverse = StaticClass.reverse(3);
        log.info("reverse:{}", reverse);
    }
}
