package com.gyy;

import java.util.Random;
import java.util.Scanner;

public class Test6 {
    public static void main(String[] args) {
        // 目标:完成抢红包案例的开发。
        int[] money = {9, 666, 188, 520, 99999};
//        redEnvelope(money);
//        red_Envelope(money);
        hb(money);
        printArray(money);
    }

    public static void printArray(int[] money) {
        System.out.print("[");
        for (int i = 0; i < money.length; i++) {
            System.out.print(i == money.length - 1 ? money[i] : money[i] + ", ");
        }
        System.out.println("]");
    }

    public static void red_Envelope(int[] money) {
        Random r = new Random();
        for (int i = 0; i < money.length; i++) {
            // 获取红包随机顺序
            int index = r.nextInt(money.length);
            int temp = money[i];
            money[i] = money[index];
            money[index] = temp;
        }

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < money.length; i++) {
            //提醒用户抽奖
            System.out.println("请您输入任意内容进行抽奖:");
            sc.next(); // 等待用户输入内容，按了回车才往下走的。
            System.out.println("恭喜您，您抽中了红包:" + money[i]);
        }
        System.out.println("活动结束。。。");
    }

    public static void redEnvelope(int[] money) {
        // money = [9, 666, 188, 520, 99999]
        //          0   1    2    3    4

        // 1、定义一个for循环，控制抽奖5次
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        for (int i = 0; i < money.length; i++) {
            // 2、提示粉丝抽奖
            System.out.println("请您输入任意内容进行抽奖:");
            sc.next(); // 等待用户输入内容，按了回车才往下走的。

            // 3、为当前粉丝找一个随机的红包出来
            while (true) {
                int index = r.nextInt(money.length); // 0 - 4
                int u_money = money[index];

                // 4、判断这个红宝是否不为0
                if (u_money != 0) {
                    System.out.println("恭喜您，您抽中了红包:" + u_money);
                    money[index] = 0;
                    break; // 结束这次抽奖!
                }
            }
        }
        System.out.println("活动结束。。。");

    }

    /*思路:随机一个索引，其位置处的数据即为用户抽到的红包，并将此处数据与数组最后处进行交换
          后续用户随机索引范围-1，重复上述操作
     */
    public static void hb(int[] money) {
        int range = money.length;
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < money.length; i++, range--) {
            // 提示粉丝抽奖
            System.out.println("请您输入任意内容进行抽奖:");
            sc.next(); // 等待用户输入内容，按了回车才往下走的。

            // 生成随机索引
            int index = r.nextInt(range);
            System.out.print("恭喜您，您抽中了:");
            System.out.println(u_Money(money, index, range));
        }
        System.out.println("活动结束。。。");
    }

    public static int u_Money(int[] arr, int index, int range) {
        int uMoney = arr[index];
        arr[index] = arr[range - 1];
        arr[range - 1] = uMoney;
        return uMoney;
    }
}
