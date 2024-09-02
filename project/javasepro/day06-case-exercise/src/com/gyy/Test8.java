package com.gyy;

public class Test8 {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "x" + i + "=" + (j * i) + "\t");
                /*System.out.print(" x ");
                System.out.print(i);
                System.out.print(" = ");
                System.out.print(j * i);
                System.out.print("    ");*/
            }
            System.out.println();
        }
    }
}
