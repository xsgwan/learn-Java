package com.gyy;

public class test8_2 {
    public static void main(String[] args) {
        print(5);
    }

    public static void print(int n) {
        int space_count;
        int _count;
        for (int i = 1; i <= n; i++) {
            if (i <= (n + 1) / 2) {
                space_count = (n + 1) / 2 - i;
                _count = 2 * i - 1;
                for (int j = 1; j <= space_count; j++) {
                    System.out.print(" ");
                }
                for (int k = 1; k <= _count; k++) {
                    System.out.print("*");
                }
                System.out.println();
            } else {
                space_count = i - (n + 1) / 2;
                _count = (n + 1 - i) * 2;
                for (int j = 1; j < i - n / 2; j++) {
                    System.out.print(" ");
                }
                for (int k = 1; k < (n + 1 - i) * 2; k++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }
    }
}

/*
            *
           ***
          *****
          *****
           ***
            *

* i         空格          *
* 1         2            1
* 2         1            3
* 3         0            5
*        (n+1)/2-i      2*i-1
* -----------------------------
* 4         0            5
* 5         1            3
* 6         2            1
*        i-(n+1)/2    2*(n+1-i)-1
*
        // 打印n行，第一行打印 n/2-i列空格， 第二行打印 1列空格， 第三行打印 0行空格  第四行打印 1列空格  第五行打印 i-n+1/2列空格
        // 打印n行，第一行打印 2*1-1 列，第二行打印 2*2-1 列，第三行打印 2*3-1列，第四行打印 2*(n+1-i)-1列
* */