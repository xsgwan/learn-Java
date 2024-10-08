package com.gyy.string;

import java.util.Random;

/**
 * 目标：完成随机产生验证码，验证码的每位可能是数字、大写字母、小写字母
 */
public class StringTest5 {
    public static void main(String[] args) {
        System.out.println(craeteCode(4));
        System.out.println(craeteCode(6));
    }

    /**
     * 1、设计一个方法，返回指定位数的验证码
     */
    public static String craeteCode(int n) {
        // 2、定义2个变量一个是记住最终产生的随机验证码一个是记住可能用到的全部字符
        String code = "";
        String data = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        // 3、开始定义一个循环产生每位随机字符
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            // 4、随机一个字符范围内的索引。
            int index = r.nextInt(data.length());
            // 5、根据索引去全部字符中提取该字符
            code += data.charAt(index); // code = code + 字符
        }
        return code;
    }
}
