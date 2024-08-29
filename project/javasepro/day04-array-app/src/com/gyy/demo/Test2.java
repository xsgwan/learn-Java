package com.gyy.demo;

public class Test2 {
    /*public static int[] daoxv(int[] arr) {
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return arr;
    }*/

    public static void main(String[] args) {
        // 目标:完成数组反转。
        // 1、准备一个数组
        int[] data = {10, 20, 30, 40, 50};

        //data=daoxv(data);

        // 2、定义一个循环，设计2个变量，一个在前，一个在后
        for (int i = 0, j = data.length - 1; i < j; i++, j--) {
            // arr[i] arr[j]
            // 交换
            // 1、定义一个临时变量记住后一个位置处的值
            int temp = data[j];
            // 2、把前一个位置处的值赋值给后一个位置了
            data[j] = data[i];
            // 3、把临时变量中记住的后一个位置处的值赋值给前一个位置处
            data[i] = temp;
        }
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
    }
}
