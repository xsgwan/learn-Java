package com.gyy.objecct;

public class Student {
    // 成员变量(对象的属性)
    String name; // 姓名
    double chinese; // 语文成绩
    double math;  // 数学成绩


    // 成员方法(对象的行为)
    public void printTotalScores() {
        System.out.println(name + "的总成绩是:" + (chinese + math));
    }

    public void printAverageScores() {
        System.out.println(name + "的评价成绩是:" + (chinese + math) / 2.0);
    }
}

class Phone {

}

class Car{

}
