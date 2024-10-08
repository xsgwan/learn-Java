package com.gyy.define;

import java.util.Scanner;

public class ArrayTest6 {
    public static void main(String[] args) {
        // 目标:完成评委打分的案例。
        // 1、定义一个动态初始化的数组，负责后期存储6个评委的打分。
        double[] scores = new double[6];

        Scanner sc = new Scanner(System.in);

        // 2、遍历数组中的每个位置，录入评委的分数，存入到数组中去
        double sum = 0;
        for (int i = 0; i < scores.length; i++) {
            // i = 0 1 2 3 4 5
            System.out.println("请您输入第 " + (i + 1) + " 个评委分数:");
            scores[i] = sc.nextDouble();

            // 3、遍历数组中的每个元素进行求和
            sum += scores[i];
        }
        double average = sum / scores.length;
        System.out.println("选手最终得分是: " + average);
    }
}
