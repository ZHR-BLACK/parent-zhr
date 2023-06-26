package com.zhr.selfstudy.hash;

import cn.hutool.core.util.HashUtil;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName HashMain
 * @Date 2019-11-21 16:09
 * @description 混合hash算法，输出64位的值
 **/
public class HashMain {

    public static void main(String[] args) {
        String s = "asdhniasdiasjd";

        long l = HashUtil.mixHash(s);
        System.out.println("l ********************" + l);

        long a = l % 5000;
        System.out.println("a ********************" + a);

        long a2 = -a;
        System.out.println("a2 ********************" + a2);
    }
}
