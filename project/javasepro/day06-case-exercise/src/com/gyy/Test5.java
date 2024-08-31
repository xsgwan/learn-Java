package com.gyy;

public class Test5 {
    public static void main(String[] args) {
        int[] arr = {11, 22, 33};
        int[] arr2 = copy(arr);
        printArray(arr2);

        // 注意:这个不是拷贝数组，叫把数组变量赋值给另一个数组变量。
//        int[] arr3 = arr;
//        arr3[1] = 666;
//        System.out.println(arr[1]);

        arr2[1] = 666;
        System.out.println(arr[1]);
    }

    public static int[] copy(int[] arr) {
        // arr = [11， 22, 33]
        //         0    1   2

        // 1、创建一个长度一样的整型数组出来。
        int[] arr2 = new int[arr.length];
        // arr2 = [0, 0, 0]
        //         0  1  2

        // 2、把原数组的元素值对应位置赋值给新数组。
        for (int i = 0; i < arr.length; i++) {
            // i = 0 1 2
            arr2[i] = arr[i];
        }
        return arr2;
    }

    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(i == arr.length - 1 ? arr[i] : arr[i] + ",");
        }
        System.out.println("]");
    }
}
