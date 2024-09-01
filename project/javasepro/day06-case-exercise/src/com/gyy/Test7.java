package com.gyy;

public class Test7 {
    public static void main(String[] args) {
        // 目标:完成找素数。

        System.out.println("当前素数的个数是:" + judegPrimeNumber(101, 200));

        /*int[] primes = judegPrimeNumber(100);
        printArray(primes);*/
    }

    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(i == arr.length - 1 ? arr[i] : arr[i] + ", ");
        }
        System.out.println("]");
    }


    public static int judegPrimeNumber(int start, int end) {
        int count = 0;
        // start = 101;     end = 200;
        // 1、定义一个for循环找到101到200之间的每个数据
        for (int i = start; i <= end; i++) {
            // i = 101 102 103 ··· 199 200

            //信号位思想
            boolean flag = true; // 假设的意思:默认认为当前1记住的数据是素数。

            // 2、判断当前1记住的这个数据是否是素数。
            for (int j = 2; j <= i / 2; j++) {
                if (i % j == 0) {
                    // i当前记住的这个数据不是素数了
                    flag = false;
                    break;
                }

            }

            // 3、根据判定的结果决定是否输出1当前记住的数据：是素数才输出展示。
            if (flag) {
                System.out.println(i);
                count++;
            }
        }
        return count;
    }

    /*
        思路:找素数  (除了1和它本身以外，不能被其他正整数整除)
        任意合数 都能被 比他小的、除1外 的某个素数 整除

    */
    public static int[] judegPrimeNumber(int range) {
        int[] primes = new int[range];
        primes[0] = 1;
        if (range >= 2) {
            primes[1] = 2;
            int k = 2;
            if (range >= 3) {
                for (int number = 3; number <= range; number++) { //   判断number是否为素数:
                    int j = 1;
                    while (primes[j] != 0 && number % primes[j] != 0) { // j==i;
                        j++;
                    }
                    if (primes[j] == 0) {
                        primes[k] = number;
                        k++;
                    }
                }
            }
        }
        return primes;
    }
}
