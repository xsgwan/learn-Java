package com.gyy;

import java.util.Random;

public class Test2 {
    public static void main(String[] args) {
        System.out.println(createCode(8));
    }

    public static String createCode(int n) {
        // 1、定义一个f0P循环用于控制产生多少位随机字符
        Random r = new Random();
        // 3、定义一个String类型的变量用于记住产生的每位随机字符
        String code = "";
        for (int i = 1; i <= n; i++) {
            // i = 1 2 3 4 5
            // 2、为每个位置生成一个随机字符：可能是数字、大小写字母。
            // 思路:随机一个0 1 2之间的数字出来，0代表随机一个数字字符，1、2代表随机大写字母，小写字母。
            int temp = r.nextInt(3);
            switch (temp) {
                case 0:
                    // 随机生成一个数字字符
                    code += r.nextInt(10); // 0 - 9 code = code + 8
                    break;
                case 1:
                    // 随机一个大写字符 A 65    Z 65 + 25     (0 - 25) + 65
                    char ch1 = (char) (r.nextInt(26) + 65);
                    code += ch1;
                    break;
                case 2:
                    // 随机一个大写字符 a 97    z 97 + 25     (0 - 25) + 97
                    char ch2 = (char) (r.nextInt(26) + 97);
                    code += ch2;
                    break;
            }
        }
        return code;
    }
}
