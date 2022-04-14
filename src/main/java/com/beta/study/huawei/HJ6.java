package com.beta.study.huawei;

import java.util.Scanner;

/**
 * 描述 功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5 ）
 * <p>
 * <p>
 * 数据范围： 1 \le n \le 2 \times 10^{9} + 14 \1≤n≤2×10 9 +14 输入描述： 输入一个整数
 * <p>
 * 输出描述： 按照从小到大的顺序输出它的所有质数的因子，以空格隔开。
 * <p>
 * 示例1 输入： 180 复制 输出： 2 2 3 3 5
 *
 * @author shiqiu
 * @date 2022/04/10
 */
public class HJ6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Long num = in.nextLong();
        if (num == null || num < 0L) {
            return;
        }
        long sqrt = (long)Math.sqrt(num);
        for (long i = 2; i <= sqrt; i++) {
            while (num % i == 0) {
                System.out.print(i + " ");
                num /= i;
            }
        }
        if (num > 1) {
            System.out.print(num);
        }
    }
}
