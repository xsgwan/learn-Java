package com.gyy.encapsulation;

public class Test {
    public static void main(String[] args) {
        // 目标:掌握封装的设计规范：合理隐藏、合理暴露。
        Student s1 = new Student();
        s1.setScore(99);
        System.out.println(s1.getScore());
    }
}
