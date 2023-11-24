package com.zhr.selfstudy.hutool.bloom;

import cn.hutool.bloomfilter.BitMapBloomFilter;

/**
 * @author zhangjing710
 * @description 它实际上是一个很长的二进制向量和一系列随机映射函数。布隆过滤器可以用于检索一个元素是否在一个集合中。
 * 它的优点是空间效率和查询时间都远远超过一般的算法，缺点是有一定的误识别率和删除困难。
 * <p>
 * 布隆过滤器的原理是，当一个元素被加入集合时，通过K个散列函数将这个元素映射成一个位数组中的K个点，把它们置为1。
 * 检索时，我们只要看看这些点是不是都是1就（大约）知道集合中有没有它了：如果这些点有任何一个0，则被检元素一定不在；
 * 如果都是1，则被检元素很可能在。这就是布隆过滤器的基本思想。
 * @date 2022/3/7 2:52 下午
 */
public class BloomFilterDemo {

    public static void main(String[] args) {
        int total = 10000000;
        // 初始化
        BitMapBloomFilter filter = new BitMapBloomFilter(10);
        for (int i = 0; i < total; i++) {
            filter.add(String.valueOf(i));
        }
        int count = 0;
        // 验证匹配度
        for (int i = 0; i < total + 10000; i++) {
            if (filter.contains(String.valueOf(i))) {
                count++;
            }
        }
        System.out.println("匹配数量:" + count);
    }
}
