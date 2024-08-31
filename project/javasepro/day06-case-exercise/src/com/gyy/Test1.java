package com.gyy;

public class Test1 {
    public static void main(String[] args) {
        // 目标:完成买飞机票的案例。
        double price = calculate(1000, 11, "头等舱");
        System.out.println(price);
    }

    public static double calculate(double price, int mounth, String type) {
        // 1、判断当前月份是淡季还是旺季
        if (mounth >= 5 && mounth <= 10) {
            // 旺季
            // 2、判断仓位类型。
            switch (type) {
                case "头等舱":
                    price *= 0.9;
                    break;
                case "经济舱":
                    price *= 0.85;
                    break;
            }
        } else {
            // 淡季
            switch (type) {
                case "头等舱":
                    price *= 0.7;
                    break;
                case "经济舱":
                    price *= 0.65;
                    break;
            }
        }
        return price;
    }
}
