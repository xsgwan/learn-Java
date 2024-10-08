package com.gyy.variable;

public class Test {
    public static void main(String[] args) {
        // 目标:搞清楚成员变量和局部变量的区别。
        // 1、类中位置不同：成员变量（类中，方法外）、局部变量（常见于方法中）
        int a = 20;

        // 2、初始化值不同：成员变量（有默认值，不需要初始化赋值），局部变量（没有默认值，使用之前必须完成赋值）
        // int b;
        // System.out.println(b); // Variable 'b'might not have been initialized

        int b = 20;
        System.out.println(b);

        // 3、内存位置不同:成员变量（存在于堆内存)，局部变量（栈内存）
        // 4、作用域不同:成员变量（整个对象），局部变量（在所归属的大括号中）
        String name = "gyy";

        // 5、生命周期不同:成员变量（与对象同生共死），局部变量（方法调用而生，方法结束而亡）
    }
}
