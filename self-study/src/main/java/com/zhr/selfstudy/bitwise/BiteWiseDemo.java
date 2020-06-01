package com.zhr.selfstudy.bitwise;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName BiteWiseDemo
 * @Date 2020-05-28 16:08
 * @description 一些位运算小技巧
 **/
public class BiteWiseDemo {

    public static void main(String[] args) {
        int n = 89;
        if((n & 1) == 1){
            // n 是个奇数。
            System.out.println("n为奇数********************");
        }
        swap(34,23);
    }
    // 两数交换,两个相同的数异或之后结果会等于 0，即 n ^ n = 0。并且任何数与 0 异或等于它本身，即 n ^ 0 = n
    // 异或运算支持运算的交换律和结合律
    public static void swap(int x,int y){
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;
        System.out.println(x + "********************" + y);
    }

    // 求m的n次方
    int pow(int m,int n){
        int sum = 1;
        int tmp = m;
        while(n != 0){
            if((n & 1) == 1){
                sum *= tmp;
            }
            tmp *= tmp;
            n = n >> 1;
        }
        return sum;
    }
    // 给你一组整型数据，这些数据中，其中有一个数只出现了一次，其他的数都出现了两次，让你来找出一个数
    int find(int[] arr){
        int tmp = arr[0];
        for(int i = 1;i < arr.length; i++){
            tmp = tmp ^ arr[i];
        }
        return tmp;
    }
    // 找出不大于N的最大的2的幂指数
    int findN(int n){
        n |= n >> 1;
        n |= n >> 2;
        n |= n >> 4;
        n |= n >> 8; // 整型一般是 32 位，上面我是假设 8 位。
        return (n + 1) >> 1;
    }
}
