package com.gyy;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        // 目标:完成评委打分案例。

        System.out.println("当前选手得分是:" + getAverageScore(6));

       /* int[] scores = scores(6);
        System.out.print("[");
        for (int i = 0; i < scores.length; i++) {
            System.out.print(i == scores.length - 1 ? scores[i] : scores[i] + ",");
        }
        System.out.println("]");*/
    }

    public static double getAverageScore(int number) {
        // 1、定义、个动态初始化的数组，负责后期存入评委的打分
        int[] scores = new int[number]; // 6
        // scores = [0, 0, 0, 0, 0, 0]

        // 2、遍历数组的每个位置，依次录入评委的分数
        Scanner sc = new Scanner(System.in);
        int sum = 0; // 求总分用的变量
        int max = 0;
        int min = 0;
        for (int i = 0; i < scores.length; i++) {
            System.out.println("输入第" + (i + 1) + "个评委评分:");
            scores[i] = sc.nextInt();

            // 3、从数组中计算出总分，找出最高分，最低分。
            // 求和
            sum += scores[i];
            // 求最大值、最小值
            if (i == 0) {
                max = scores[i]; // 求最大值的
                min = scores[i]; // 求最小值的
            }
            if (scores[i] > max) {
                max = scores[i];
            }
            if (scores[i] < min) {
                min = scores[i];
            }
        }
        double averageScores = 1.0 * (double) (sum - max - min) / (number - 2); // 保留小数
        return averageScores;
    }

   /* public static int[] scores(int n) {
        int[] scores = new int[n];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            System.out.println("输入第" + (i + 1) + "个评委评分:");
            scores[i] = sc.nextInt();
        }
        return scores;
    }*/
}
