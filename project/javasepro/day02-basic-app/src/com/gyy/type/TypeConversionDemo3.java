package com.gyy.type;

public class TypeConversionDemo3 {
    public static void main(String[] args) {
        // 目标:掌握强制类型转换。
        int a = 20;
        byte b = (byte) a;// Alt + Enter 强制类型转换
        System.out.println(a);
        System.out.println(b);

        int i = 1500;
        byte j = (byte) i;
        System.out.println(i);
        System.out.println(j);

        double d = 99.5;
        int m = (int) d;
        System.out.println(m);
    }
}
