package com.beta.study.huawei.nowcoder;

import java.util.Scanner;

/**
 * ]描述 写出一个程序，接受一个由字母、数字和空格组成的字符串，和一个字符，然后输出输入字符串中该字符的出现次数。（不区分大小写字母）
 * <p>
 * 数据范围： 1 \le n \le 1000 \1≤n≤1000 输入描述： 第一行输入一个由字母和数字以及空格组成的字符串，第二行输入一个字符。
 * <p>
 * 输出描述： 输出输入字符串中含有该字符的个数。（不区分大小写字母）
 *
 * @author shiqiu
 * @date 2022/04/10
 */
public class HJ2 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String string = scanner.nextLine();
            String target = scanner.nextLine();
            if (null == string || target == null || target.length() > 1) {
                System.out.println(-1);
            }
            Character character = target.charAt(0);
            int count = 0;
            for (int i = 0; i < string.length(); i++) {
                if (String.valueOf(character).equalsIgnoreCase(String.valueOf(string.charAt(i)))) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

}
