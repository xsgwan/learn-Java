package com.gyy;

public class Test7_2 {
    public static void main(String[] args) {
        System.out.println(judegPrimeNumber(101, 200));
    }

    public static int judegPrimeNumber(int start, int end) {
        // 1、定义一个f0r循环找到101到200之间的每个数据
        int count = 0;
        // start = 101;     end = 200;
        OUT:    //  为外部循环指定标签
        for (int i = start; i <= end; i++) {
            // i = 101 102 103 ··· 199 200

            // 2、拦截判断该数是否是素数
            for (int j = 2; j <= i / 2; j++) {
                if (i % j == 0) {
                    // 这个数不是素数，不能打印
                    continue OUT; // 结束外部循环的当次执行！
                }
            }

            System.out.println(i);
            count++;
        }
        return count;
    }
}
