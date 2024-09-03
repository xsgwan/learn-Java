package com.gyy;

import java.util.Random;
import java.util.Scanner;

public class Test9_2 {
    public static void main(String[] args) {
        int[] userNumbers = userSelectNumbers();
//        int[] userNumbers = createLuckyNumbers();
        System.out.println("您投注的号码:");
        printArray(userNumbers);

        int[] luckyNumbers = createLuckyNumbers();
        System.out.println("中奖的号码:");
        printArray(luckyNumbers);

        judge(userNumbers, luckyNumbers);

        System.out.println("-------------------------------------");
    }

    public static int[] userSelectNumbers() {
        int[] numbers = new int[7];

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < numbers.length - 1; i++) {
            while (true) {
                System.out.println("请您输入第" + (i + 1) + "个红球号码(1-33之间，不能重复)：");
                int number = sc.nextInt();

                if (number < 1 || number > 33) {
                    System.out.println("对不起，您输入的红球号码不在1-33之间，请确认！");
                } else if (exist(numbers, number)) {
                    System.out.println("对不起，您当前输入的红球号码前面选择过，重复了，请确认");
                } else {
                    numbers[i] = number;
                    break; // 结束当次投注,结束了当前死循环
                }
            }
        }

        while (true) {
            System.out.println("请您输入最后1个蓝球号码(1-16)");
            int number = sc.nextInt();
            if (number < 1 || number > 16) {
                System.out.println("对不起，您输入的蓝球号码范围不对");
            } else {
                numbers[6] = number;
                break;
            }
        }

        return numbers;
    }

    public static boolean exist(int[] numbers, int number) {
        //
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == 0) {
                return false;
            }
            if (numbers[i] == number) {
                return true;
            }
        }
        return false;
    }

    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(i == arr.length - 1 ? arr[i] : arr[i] + ", ");
        }
        System.out.println("]");
    }

    public static int[] createLuckyNumbers() {
        int[] numbers = new int[7];

        Random random = new Random();
        for (int i = 0; i < numbers.length - 1; i++) {
            while (true) {
                int number = random.nextInt(33) + 1;
                if (!exist(numbers, number)) {
                    numbers[i] = number;
                    break;
                }
            }
        }
        numbers[6] = random.nextInt(16) + 1;
        return numbers;
    }

    public static void judge(int[] userNumbers, int[] luckyNumbers) {
        int red_count = 0;
        int blue_count = 0;
        for (int i = 0; i < userNumbers.length - 1; i++) {
            for (int j = 0; j < luckyNumbers.length - 1; j++) {
                if (userNumbers[i] == luckyNumbers[j]) {
                    red_count++;
                    break;
                }
            }
        }
        blue_count = userNumbers[6] == luckyNumbers[6] ? 1 : 0;

        System.out.println("您命中的红色球数量是" + red_count);
        System.out.println("您命中的蓝色球数量是" + blue_count);


        if (blue_count == 1) {
            switch (red_count) {
                case 0:
                case 1:
                    System.out.println("恭喜你中了六等奖,奖金: 5元");
                    break;
                case 2:
                case 3:
                    System.out.println("恭喜你中了五等奖,奖金: 10元");
                    break;
                case 4:
                    System.out.println("恭喜你中了四等奖,奖金: 200元");
                    break;
                case 5:
                    System.out.println("恭喜你中了三等奖,奖金: 3000元");
                    break;
                case 6:
                    System.out.println("恭喜你中了一等奖,奖金: 1000万元");
                    break;
            }
        } else {
            switch (red_count) {
                case 0:
                case 2:
                case 3:
                    System.out.println("很遗憾，您未中奖");
                    break;
                case 1:
                    System.out.println("恭喜你中了六等奖,奖金: 5元");
                    break;
                case 4:
                    System.out.println("恭喜你中了四等奖,奖金: 200元");
                    break;
                case 5:
                    System.out.println("恭喜你中了三等奖,奖金: 3000元");
                    break;
                case 6:
                    System.out.println("恭喜你中了二等奖,奖金: 500万元");
                    break;
            }
        }
    }

    public static void paixv(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}