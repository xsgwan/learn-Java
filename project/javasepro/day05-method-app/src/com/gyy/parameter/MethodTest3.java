package com.gyy.parameter;

public class MethodTest3 {
    public static void main(String[] args) {
        // 目标:完成打印int类型的数组内容。
        int[] arr = new int[]{10, 30, 50, 70};
        printArray(arr);

        int[] arr2 = null;
        printArray(arr2);
    }

    public static void printArray(int[] arr) {
        if (arr == null) {
            System.out.println(arr); // null
            return; // 跳出当前方法
        }

        System.out.print("[");
        // 直接遍历接到的数组元素
        for (int i = 0; i < arr.length; i++) {
            /*System.out.print(arr[i]);
            if (i != arr.length - 1) {
                System.out.print(", ");
            } else {
                System.out.println("]");
            }*/
            System.out.print(i == arr.length - 1 ? arr[i] : arr[i] + ",");
        }
        System.out.println("]");
    }
}
