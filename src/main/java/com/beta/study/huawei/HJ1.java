package com.beta.study.huawei;

import java.util.Scanner;

/**
 * 描述 计算字符串最后一个单词的长度，单词以空格隔开，字符串长度小于5000。（注：字符串末尾不以空格为结尾） 输入描述： 输入一行，代表要计算的字符串，非空，长度小于5000。
 * <p>
 * 输出描述： 输出一个整数，表示输入字符串最后一个单词的长度。
 *
 * @author shiqiu
 * @date 2022/04/10
 */
public class HJ1 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String string = scanner.nextLine();
            if (string == null) {
                System.out.println(-1);
            }
            string = string.trim();
            int i = string.length() - 1;
            for (; i > -1; i--) {
                if (string.charAt(i) == ' ') {

                    break;
                }
            }
            System.out.println(string.length() - i - 1);
        }
    }
}
