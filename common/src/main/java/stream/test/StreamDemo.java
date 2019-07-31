package stream.test;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName StreamDemo
 * @Date 2019/5/23 14:32
 * @description todo
 **/
public class StreamDemo {
    public static List<Product> productList;
    static {
        productList = new ArrayList<Product>();
        Product p1 = new Product(1, "iphoneX", 7800, "电子产品");
        Product p2 = new Product(2, "华为荣耀", 5000, "电子产品");
        Product p3 = new Product(3, "mac pro", 29000, "电子产品");
        Product p4 = new Product(4, "美瑞克斯", 750, "食品");
        Product p5 = new Product(5, "ON", 750, "食品");
        Product p6 = new Product(6, "耐克 AIR MAX", 1700, "服饰");
        Product p7 = new Product(7, "耐克 AIR MAX", 3200, "服饰");
        productList.add(p1);
        productList.add(p2);
        productList.add(p3);
        productList.add(p4);
        productList.add(p5);
        productList.add(p6);
        productList.add(p7);
    }

    // 循环
    @Test
    public void test1() {
        // productList.forEach(x -> System.out.println(x.getName()));
        // productList.forEach(System.out::println);
        // productList.stream().map(Product::getName).collect(Collectors.toList()).forEach(System.out::println);

        Map<String, Product> productMap = new HashMap<>();
        productMap.put("a",new Product(1, "iphoneX", 7800, "电子产品"));
        productMap.put("b",new Product(1, "iphoneXr", 4800, "电子产品"));
        productMap.forEach((x, y) -> System.out.println(x + " " + y.getName()));
    }

    // 排序
    public static void sorted() {
        // productList.stream().sorted((x, y) -> (int)(x.getPrice() -
        // y.getPrice()));
        productList.stream().sorted(StreamDemo::compare).forEach(x -> System.out.println(x.getName()));
        System.out.println("---------------");
        productList.forEach(x -> System.out.println(x.getName()));
    }

    private static int compare(Product o1, Product o2) {
        return (int) (o1.getPrice() - o2.getPrice());
    }

    // limit & skip
    @Test
    public void test11() {
        productList.stream().limit(2).collect(Collectors.toList());
        productList.stream().limit(2).collect(Collectors.toList()).stream().map(Product::getName).collect(Collectors.toList())
                .forEach(System.out::println);
        productList.stream().skip(2).collect(Collectors.toList()).stream().map(Product::getName).collect(Collectors.toList())
                .forEach(System.out::println);
    }

    /**
     * 分组 key不能为null 否则 element cannot be mapped to a null key
     */
    @Test
    public void test2() {
        Map<String, List<Product>> list1 = productList.stream().collect(Collectors.groupingBy(Product::getType));
        System.out.println(new Gson().toJson(list1));
        Map<Integer, Product> map1 = productList.stream().collect(Collectors.toMap(Product::getId, Function.identity()));
        Map<Integer, String> map2 = productList.stream().collect(Collectors.toMap(Product::getId, Product::getName));
    }

    public static void test3() {
        // List<String> colectList =
        // productList.stream().map(Product::getType).collect(Collectors.toList());
        // System.out.println(new Gson().toJson(colectList));
        // Set<String> collectSet =
        // productList.stream().map(Product::getType).collect(Collectors.toSet());
        // System.out.println(new Gson().toJson(collectSet));
        // Map<String, Product> collectMap0 =
        // productList.stream().collect(Collectors.toMap(Product::getName,
        // Function.identity()));
        // System.out.println(new Gson().toJson(collectMap0));
        // Map<String, String> collectMap1 =
        // productList.stream().collect(Collectors.toMap(Product::getName,
        // Product::getType));
        // System.out.println(new Gson().toJson(collectMap1));
        // Map<String, String> collectMap2 = productList.stream()
        // .collect(Collectors.toMap(Product::getType, Product::getName,
        // (oldValue, newValue) -> oldValue));
        // System.out.println(new Gson().toJson(collectMap2));

    }

    // 多级分组
    @Test
    public void groupingMultiple() {
        Map<String, Map<String, List<Product>>> g = productList.stream()
                .collect(Collectors.groupingBy(Product::getType, Collectors.groupingBy(Product::getName)));
        System.out.println(new Gson().toJson(g));

        Map<String, Long> g2 = productList.stream().collect(Collectors.groupingBy(Product::getType, Collectors.counting()));
        System.out.println(new Gson().toJson(g2));

        Map<Double, Long> g3 = productList.stream().collect(Collectors.groupingBy(Product::getPrice, Collectors.counting()));
        System.out.println(new Gson().toJson(g3));
    }

    // A/B分组
    @Test
    public void groupingPartern() {
        Map<Boolean, List<Product>> x = productList.stream().collect(Collectors.partitioningBy(StreamDemo::partern));
        System.out.println(new Gson().toJson(x));
    }

    private static boolean partern(Product p) {
        return p.getPrice() > 1000;
    }

    // anymatch
    @Test
    public void test4() {
        boolean x = productList.stream().anyMatch(a -> a.getType() == null);
        boolean y = productList.stream().map(Product::getType).anyMatch(a -> a == null);
        boolean z = productList.stream().map(Product::getType).anyMatch(this::validIsNull);

        boolean u = productList.stream().allMatch(a -> a.getPrice() > 100);
        System.out.println(u);
    }

    public boolean validIsNull(String x) {
        return x == null;
    }

    // 字符串拼接
    public static void test5() {
        String x = productList.stream().map(Product::getType).collect(Collectors.joining());
        String y = productList.stream().map(Product::getType).collect(Collectors.joining(","));
        System.out.println(x);
        System.out.println(y);
    }

    // distinct 去重，用对象的equals方法判断
    @Test
    public void test6() {
        productList.stream().distinct().forEach(x -> System.out.println(x.getName()));
    }

    // 聚合操作
    @Test
    public void test7() {
        // 求和
        double x = productList.stream().map(Product::getPrice).reduce(Double::sum).get();
        productList.stream().map(Product::getPrice).collect(Collectors.summarizingDouble(a -> a));

        // 最大
        double y = productList.stream().map(Product::getPrice).reduce(Double::max).get();
        // 平均
        double z = productList.stream().mapToDouble(Product::getPrice).average().getAsDouble();

        System.out.println(x + "  " + y + "  " + z);
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Product {
    private Integer id;
    private String name;
    private double price;
    private String type;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Product other = (Product) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

}
