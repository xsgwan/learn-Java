package com.gyy.javabean;

public class Student {
    // 1、必须私有成员变量，并为每个成员变量都提供get set方法
    private String name;
    private Double score;

    // 2、必须为类提供一个公开的无参数构造器
    public Student() {

    }

    public Student(String name, Double score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
