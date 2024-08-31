package com.gyy;

public class Test4 {
    public static void main(String[] args) {
        // 目标:完成数字加密程序的开发。
        System.out.println(encrypt(1983));
        /*int data = 1983;
        int[] datas = jami(data);
        for (int i = 0; i < datas.length; i++) {
            System.out.print(datas[i]);
        }
        int i = 0;
        int j = datas.length - 1;
        while (i < j) {
            int temp = datas[i];
            datas[i] = datas[j];
            datas[j] = temp;
            i++;
            j--;
        }
        System.out.println();
        for (int k : datas) {
            System.out.print(k);
        }*/
    }

    public static String encrypt(int number) {
        // number = 1983
        // 1、把这个密码拆分成一个一个的数字，才可以对其进行加密啊。
        int[] numbers = split(number);
        // numbers = [1, 9, 8, 3]

        //  2、遍历这个数组中的每个数字，对其进行加密处理。
        for (int i = 0; i < numbers.length; i++) {
            // i = 0 1 2 3
            numbers[i] = (numbers[i] + 5) % 10;
        }
        // numbers = [6, 4, 3, 8]

        // 3、对数组反转，把对数组进行反转的操作交给一个独立的方法来完成
        reverse(numbers);
        // numbers = [8, 3, 4, 6]

        // 4、把这些加密的数字拼接起来做为加密后的结果返回即可。
        String data = "";
        for (int i = 0; i < numbers.length; i++) {
            data += numbers[i];
        }
        return data;
    }

    public static void reverse(int[] numbers) {
        // 交换i和j位置处的数据
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            int temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
            i++;
            j--;
        }
        /*for (int i = 0, j = numbers.length; i < j; i++, j--) {
            int temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
        }*/
    }

    public static int[] split(int number) {
        // 确定number的位数
        int n = 0;
        int temp = number;
        while (temp / 10 != 0 || temp % 10 != 0) {
            temp = temp / 10;
            n++;
        }
        int[] datas = new int[n];

        // 将number拆分插入数组
        int i = n;
        while (number / 10 != 0 || number % 10 != 0) {
            datas[i - 1] = number % 10;
            number = number / 10;
            i--;
        }
        return datas;
    }
    /*public static int[] jami(int data) {
        int n = 0;
        int temp = data;
        while (temp / 10 != 0) {
            temp = temp / 10;   // 198  19  1
            n++;                //0   1   2  3
        }
        int[] datas = new int[n + 1];
        int i = n;
        while (data / 10 != 0 || data % 10 != 0) {
            datas[i] = (data % 10 + 5) % 10; // 3  8   9   1
            data = data / 10;   // 198  19  1
            i--;                //0   1   2  3
        }
        return datas;
    }*/
}
