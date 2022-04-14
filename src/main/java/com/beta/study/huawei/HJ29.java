package com.beta.study.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 描述 对输入的字符串进行加解密，并输出。
 * <p>
 * 加密方法为：
 * <p>
 * 当内容是英文字母时则用该英文字母的后一个字母替换，同时字母变换大小写,如字母a时则替换为B；字母Z时则替换为a；
 * <p>
 * 当内容是数字时则把该数字加1，如0替换1，1替换2，9替换0；
 * <p>
 * 其他字符不做变化。
 * <p>
 * 解密方法为加密的逆过程。 数据范围：输入的两个字符串长度满足 1 \le n \le 1000 \1≤n≤1000  ，保证输入的字符串都是只由大小写字母或者数字组成 输入描述： 第一行输入一串要加密的密码 第二行输入一串加过密的密码
 * <p>
 * 输出描述： 第一行输出加密后的字符 第二行输出解密后的字符
 * <p>
 * 示例1 输入： abcdefg BCDEFGH 复制 输出： BCDEFGH abcdefg
 *
 * @author shiqiu
 * @date 2022/04/11
 */
public class HJ29 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String str1 = br.readLine();
        System.out.println(decode(str, true));
        System.out.println(decode(str1, false));
    }

    private static String decode(String str, boolean isEncrypt) {
        if (str == null || str.length() == 0) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'a' && c <= 'z') {
                char ch = (char)((c - 'a' + (isEncrypt ? 1 : -1))%26 + 'A');
                stringBuilder.append(ch);
            } else if (c >= 'A' && c <= 'Z') {
                char ch = (char)((c - 'A' + (isEncrypt ? 1 : -1))%26 + 'a');
                stringBuilder.append(ch);
            } else if (c >= '0' && c <= '9') {
                char ch = (char)((c - '0' + (isEncrypt ? 1 : -1))%10 + '0');
                stringBuilder.append(ch);
            } else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

}
