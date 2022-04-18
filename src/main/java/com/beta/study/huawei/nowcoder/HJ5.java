package com.beta.study.huawei.nowcoder;

import java.util.Scanner;

/**
 * 描述 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。
 * <p>
 * 数据范围：保证结果在 1 \le n \le 2^{31}-1 \1≤n≤2 31 −1 输入描述： 输入一个十六进制的数值字符串。
 * <p>
 * 输出描述： 输出该数值的十进制字符串。不同组的测试用例用\n隔开。
 * <p>
 * 示例1 输入： 0xAA 复制 输出： 170
 *
 * @author shiqiu
 * @date 2022/04/10
 */
public class HJ5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if (!s.startsWith("0x") || s.startsWith("0X") || s.length() < 3) {
            return;
        }
        s = s.substring(2);

        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int v = 0;
            if (c >= '0' && c <= '9') {
                v = c - '0';

            } else {
                v = c - 'A' + 10;
            }
            sum = sum * 16 + v;
        }

        System.out.println(sum);
    }
}
