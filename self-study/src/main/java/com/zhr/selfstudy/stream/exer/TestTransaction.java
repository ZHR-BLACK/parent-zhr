package com.zhr.selfstudy.stream.exer;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.sl.draw.geom.GuideIf;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.apache.poi.sl.draw.geom.GuideIf.Op.min;

@Slf4j
public class TestTransaction {

    List<Transaction> transactions = null;

    @Before
    public void before() {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
    }

    //1. 找出2011年发生的所有交易， 并按交易额排序（从低到高）
    @Test
    public void test1() {
        List<Transaction> list = transactions.stream()
                .filter((t) -> t.getYear() == 2011)
                .sorted(Comparator.comparingInt(Transaction::getValue)).collect(Collectors.toList());
        System.out.println("1. 找出2011年发生的所有交易， 并按交易额排序（从低到高）" + list);
    }

    //2. 交易员都在哪些不同的城市工作过？
    @Test
    public void test2() {
        List<String> list = transactions.stream()
                .map((t) -> t.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
        System.out.println("2. 交易员都在哪些不同的城市工作过？" + list);
    }

    //3. 查找所有来自剑桥的交易员，并按姓名排序
    @Test
    public void test3() {
        List<Trader> list = transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .sorted(Comparator.comparing(Trader::getName))
                .distinct()
                .collect(Collectors.toList());
        System.out.println("3. 查找所有来自剑桥的交易员，并按姓名排序" + list);
    }

    //4. 返回所有交易员的姓名字符串，按字母顺序排序
    @Test
    public void test4() {
        List<String> list = transactions.stream()
                .map((t) -> t.getTrader().getName())
                .sorted()
                .collect(Collectors.toList());
        System.out.println("4. 返回所有交易员，按字母顺序排序" + list);

        System.out.println("-----------------------------------");

        String str = transactions.stream()
                .map((t) -> t.getTrader().getName())
                .sorted()
                .reduce("", String::concat);
        System.out.println("4. 返回所有交易员的姓名字符串，按字母顺序排序" + str);

        System.out.println("------------------------------------");

        transactions.stream()
                .map((t) -> t.getTrader().getName())
                .flatMap(TestTransaction::filterCharacter)
                .sorted(String::compareToIgnoreCase)
                .forEach(System.out::print);
    }

    public static Stream<String> filterCharacter(String str) {
        List<String> list = new ArrayList<>();
        for (Character ch : str.toCharArray()) {
            list.add(ch.toString());
        }
        return list.stream();
    }

    //5. 有没有交易员是在米兰工作的？
    @Test
    public void test5() {
        List<Transaction> list = transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Milan")).collect(Collectors.toList());
        System.out.println("5. 有没有交易员是在米兰工作的？" + list);
    }

    //6. 打印生活在剑桥的交易员的所有交易额
    @Test
    public void test6() {

        System.out.println("cambridge = " + transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .mapToDouble(Transaction::getValue).sum());
    }


    //7. 所有交易中，最高的交易额是多少
    @Test
    public void test7() {
        Integer max = transactions.stream()
                .map(Transaction::getValue)
                .max(Comparator.comparingInt(t -> t)).get();
        log.info("7. 所有交易中，最高的交易额是多少={}", max);
    }

    //8. 找到交易额最小的交易
    @Test
    public void test8() {
        Integer min = transactions.stream()
                .min(Comparator.comparingInt(Transaction::getValue))
                .map(Transaction::getValue).get();
        log.info("8. 找到交易额最小的交易={}", min);
    }

}