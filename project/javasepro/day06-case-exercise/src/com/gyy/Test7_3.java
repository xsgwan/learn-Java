package com.gyy;

public class Test7_3 {
    public static void main(String[] args) {
        for (int i = 101; i <= 200; i++) {
            if(judgePrime(i)){
                System.out.println(i);
            }
        }
    }

    public static boolean judgePrime(int data) {
        for (int i = 2; i <= data / 2; i++) {
            if (data % i == 0) {
                return false;
            }
        }
        return true;
    }
}
