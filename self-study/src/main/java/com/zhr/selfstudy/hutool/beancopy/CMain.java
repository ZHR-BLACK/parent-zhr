package com.zhr.selfstudy.hutool.beancopy;

import cn.hutool.core.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName A
 * @Date 2019-10-31 11:11
 * @description 复制A的属性值给自己
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CMain {

    private String name;

    private int age;

    private B b;

    private List<B> bs;

    public static void main(String[] args) {
        // 设置source类属性
        B b = new B();
        b.setPhone("156666666666");

        B b2 = new B();
        b2.setPhone("15777777777");

        A a = new A();
        a.setB(b);

        List<B> list = new ArrayList();
        list.add(b);
        list.add(b2);
        a.setBs(list);


        CMain cMain = new CMain();
        // 复制A的属性值到CMain中
        BeanUtil.copyProperties(a, cMain);
        System.out.println("c = " + cMain);
        System.out.println("c = " + cMain.getB().getPhone());
        List<B> bs = cMain.getBs();
        System.out.println("bs ********************" + bs);
    }
}
