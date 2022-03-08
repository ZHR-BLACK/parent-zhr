package com.zhr.selfstudy.hutool.beancopy;

import cn.hutool.extra.cglib.CglibUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangjing710
 * @description 复制A的属性值给自己
 * Cglib的性能是目前公认最好的，其时间主要耗费在BeanCopier创建上，因此，Hutool根据传入Class不同，缓存了BeanCopier对象，使性能达到最好。
 * @date 2022/3/7 2:45 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CglibMain {

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

        List<B> list = new ArrayList<>();
        list.add(b);
        list.add(b2);
        a.setBs(list);

        // 复制A的属性值到CMain中
        CglibMain copy = CglibUtil.copy(a, CglibMain.class);
        System.out.println("c = " + copy);
        System.out.println("c = " + copy.getB().getPhone());
        List<B> bs = copy.getBs();
        System.out.println("bs ********************" + bs);
    }

}
