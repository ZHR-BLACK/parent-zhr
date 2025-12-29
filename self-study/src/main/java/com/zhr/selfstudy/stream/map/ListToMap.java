package com.zhr.selfstudy.stream.map;

import com.alibaba.fastjson.JSON;
import com.zhr.selfstudy.stream.Product;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName ListToMap
 * @Date 2023-06-25 16:54
 * @description list对象转map，key为对象的某个属性，value为对象本身
 **/
public class ListToMap {

    public static List<Product> productList;

    static {
        productList = new ArrayList<>();
        Product p1 = new Product(1, "iphoneX", 7800, "电子产品");
        Product p2 = new Product(2, "华为荣耀", 5000, "电子产品");
        Product p3 = new Product(3, "mac pro", 29000, "电子产品");
        Product p4 = new Product(4, "美瑞克斯", 750, "食品");
        Product p5 = new Product(5, "ON", 750, "食品");
        Product p6 = new Product(6, "耐克 AIR MAX", 1700, "服饰");
        Product p7 = new Product(7, "耐克 AIR MAX", 3200, "服饰");
        Product p8 = new Product(7, "耐克 AIR MAX2", 3201, "服饰2");
        productList.add(p1);
        productList.add(p2);
        productList.add(p3);
        productList.add(p4);
        productList.add(p5);
        productList.add(p6);
        productList.add(p7);
        productList.add(p8);
    }

    public static void main(String[] args) {
        // 这个方法可能报错（java.lang.IllegalStateException: Duplicate key），key重复的时候
//        Map<Integer, Product> map = productList.stream()
//                .collect(Collectors.toMap(Product::getId, Function.identity()));
//        System.out.println(JSON.toJSONString(map));
        // id为key，使用后者覆盖前者来解决key重复问题
        Map<Integer, Product> map2 = productList.stream()
                .collect(Collectors.toMap(Product::getId, Function.identity(), (key1, key2) -> key2));
        System.out.println(JSON.toJSONString(map2));

        // 分组
        Map<Integer, Product> map3 = productList.stream()
                .collect(Collectors.toMap(Product::getId, Function.identity(), (key1, key2) -> key2, LinkedHashMap::new));
        System.out.println(JSON.toJSONString(map3));
    }
}
