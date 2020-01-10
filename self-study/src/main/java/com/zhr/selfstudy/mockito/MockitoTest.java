package com.zhr.selfstudy.mockito;

import org.mockito.Mockito;

import java.util.List;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName MockitoTest
 * @Date 2020-01-08 15:46
 * @description Mockito的一些运用
 *
 * <dependency>
 *   <groupId>org.mockito</groupId>
 *   <artifactId>mockito-core</artifactId>
 *   <version>3.1.0</version>
 * </dependency>
 **/
public class MockitoTest {


    public static void main(String[] args) {
        List list = Mockito.mock(List.class);
        //mock实例
        Mockito.when(list.size()).thenReturn(5);
        Mockito.when(list.get(Mockito.anyInt())).thenReturn("element");
//        Mockito.when(list.get(1)).thenThrow(new RuntimeException());

        System.out.println("list ********************" + list.size());
        System.out.println("list ********************" + list.get(5));
    }
}
