package com.gyy.arraylist;

import java.util.AbstractList;
import java.util.ArrayList;

public class ArrayListTest3 {
    public static void main(String[] args) {
        // 目标:完成拓展案例:商家菜品上架操作。
        // 1、设计一个菜品类,负责创建菜品对象,封装菜品数据
        // 2、设计一个菜品操作类FoodOperator负责完成对菜品的业务实现,上架,浏览信息
        FoodOperatoer operatoer = new FoodOperatoer();
        operatoer.start();
    }
}
