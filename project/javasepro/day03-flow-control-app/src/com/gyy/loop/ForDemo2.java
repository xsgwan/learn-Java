package com.gyy.loop;

public class ForDemo2 {
    public static void main(String[] args) {
        // 目标:掌握使用f0P循坏批量产生数据。
        for (int i = 0; i <= 100; i++) {
            System.out.println(i);
        }

        System.out.println("-------------------------------------");

        // 2、定义一个变量用于求和
        int sum = 0;

        // 1、定义一个循环，先产生1-5，这5个数
        for (int i = 1; i <= 100; i++) {
            // i = 1 2 3 4 5
            sum += i; // sum = sum + i;
        }
        System.out.println("1-100的数据和: " + sum);

        System.out.println("-------------------------------------");

        // 2、定义一个变量用于求和
        int sum1 = 0;
        // 1、定义一个循环产生1-100之间的奇数
        for (int i = 1; i < 100; i += 2) {
            sum1 += i;
        }
        System.out.println("1-100的奇数和: " + sum1);

        System.out.println("-------------------------------------");

        int sum2 = 0;
        // 1、定义循环产生1-100之间的每个数据
        for (int i = 1; i < 100; i++) {
            // i = 1 2 3 4 5 6 ... 99 100
            // 2、使用一个if分支，判断i此时记住的数据是否是奇数，是奇数我们才累加给一个变量
            if (i % 2 == 1) {
                sum2 += i;
            }
        }
        System.out.println("1-100的奇数和: " + sum2);
    }
}
