package com.gyy;

import java.util.Random;
import java.util.Scanner;

public class Test9 {
    public static void main(String[] args) {
        // 目标:完成双色球系统的开发。
        int[] luckyNumbers = createLuckyNumber();
        int[] userNumbers;
        for (int i = 0; i < 177210088; i++) {
//            int[] userNumbers = userSelectNumber();
            userNumbers = createLuckyNumber();
            if (judge(userNumbers, luckyNumbers, 1)) {
                System.out.print("用户选择双色球号码:\t");
                printArray(userNumbers);
            }
        }
        System.out.print("双色球中奖号码:\t");
        printArray(luckyNumbers);
        /*int[] arr1 = {1, 2, 3, 4, 5, 6, 7};
        int[] arr2 = {1, 2, 3, 4, 5, 6, 7};
        judge(arr1, arr2);*/
    }

    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(i == arr.length - 1 ? arr[i] : arr[i] + ", ");
        }
        System.out.println("]");
    }

    public static int[] userSelectNumber() {
        Scanner sc = new Scanner(System.in);
        int blue_num;
        int red_num;
        int[] red_nums = new int[6];
        int[] userNumbers = new int[7];

        for (int i = 0; i < userNumbers.length; i++) {
            if (i == userNumbers.length - 1) {              // 蓝色球号码选择
                System.out.println("请选择蓝色球号码:");
                while (true) {                              // 死循环以达到蓝色球号码在1-16之间
                    blue_num = sc.nextInt();
                    if (blue_num >= 1 && blue_num <= 16) {
                        userNumbers[i] = blue_num;
                        break;
                    } else {
                        System.out.println("蓝色球只能在1-16号之间选择，请重新选择:");
                    }
                }
            } else {                                          // 红色球号码选择
                System.out.println("请选择第" + (i + 1) + "个红色球号码:");
                red_num = sc.nextInt();                       // 红色球号码选择初始值，对初始值进行判断，通过
                for (int j = 0; j <= i; j++) {
                    while (true) {
                        if (red_num < 1 || red_num > 33) {
                            System.out.println("红色球只能在1-33号之间选择,请重新选择" + (i + 1) + "号红色球:");
                            red_num = sc.nextInt();
                        } else if (red_num == red_nums[j]) {
                            System.out.println("红色球不能重复,请重新选择" + (i + 1) + "号红色球:");
                            red_num = sc.nextInt();
                            j = 0;
                        } else {
                            break;
                        }
                    }
                }
                red_nums[i] = red_num;
                userNumbers[i] = red_nums[i];
            }
            // 1 - 33:
        }
        return userNumbers;
    }

    public static int[] createLuckyNumber() {
        Random random = new Random();
        int[] luckyNumbers = new int[7];
        int blue_num = random.nextInt(16) + 1;
        int red_num = random.nextInt(33) + 1;
        luckyNumbers[luckyNumbers.length - 1] = blue_num;
        for (int i = 0; i < luckyNumbers.length - 1; i++) {
            for (int j = 0; j <= i; j++) {
                while (true) {
                    if (red_num == luckyNumbers[j]) {
                        red_num = random.nextInt(33) + 1;
                        j = 0;
                    } else {
                        break;
                    }
                }
            }
            luckyNumbers[i] = red_num;
        }
        return luckyNumbers;
    }

    public static void judge(int[] userNumbers, int[] luckyNumbers) {
        int count = 0;
        for (int i = 0; i < luckyNumbers.length - 1; i++) {
            if (luckyNumbers[i] == userNumbers[i]) {
                count++;
            }
        }
        if (userNumbers[6] == luckyNumbers[6]) {
            switch (count){
                case 0:
                case 1:
                    System.out.println("恭喜你中了六等奖");
                    break;
                case 2:
                case 3:
                    System.out.println("恭喜你中了五等奖");
                    break;
                case 4:
                    System.out.println("恭喜你中了四等奖");
                    break;
                case 5:
                    System.out.println("恭喜你中了三等奖");
                    break;
                case 6:
                    System.out.println("恭喜你中了一等奖");
                    break;
            }
        }else {
            switch (count){
                case 0:
                case 2:
                case 3:
                    System.out.println("很遗憾，您未中奖");
                    break;
                case 1:
                    System.out.println("恭喜你中了六等奖");
                    break;
                case 4:
                    System.out.println("恭喜你中了四等奖");
                    break;
                case 5:
                    System.out.println("恭喜你中了三等奖");
                    break;
                case 6:
                    System.out.println("恭喜你中了二等奖");
                    break;
            }
        }
    }

    public static boolean judge(int[] userNumbers, int[] luckyNumbers, int n) {
        for (int i = 0; i < luckyNumbers.length; i++) {
            if (luckyNumbers[i] != userNumbers[i]) {
                return false;
            }
        }
        return true;
    }
}
//如何判断红色球是否重复   red_num[6]; red[i]=sc.nextInt();
/*
    red_nums[6];        红色球数组
    for (int i = 0; i < userNumbers.length-1; i++) {
        for(int j=0;j<i;j++){
            if(red_num==red_nums[j]){
                System.out.println("红色球只能在1-33号之间选择，且不能重复，请重新选择" + (i + 1) + "号红色球:");
                break;
            }
        }
        red_nums[i]=sc.nextInt();
    }



* */