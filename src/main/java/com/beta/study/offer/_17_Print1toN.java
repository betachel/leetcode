package com.beta.study.offer;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author shiqiu
 * @date 2020/05/21
 */
public class _17_Print1toN {

    /**
     * 题目描述
     * 输入数字 n，按顺序打印出从 1 最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数即 999。
     *
     * 解法
     * 此题需要注意 n 位数构成的数字可能超出最大的 int 或者 long long 能表示的范围。因此，采用字符数组来存储数字。
     * @param args
     */
    public static void main(String[] args) {
        new _17_Print1toN().print1ToMaxOfNDigits(3);

        IntStream.rangeClosed(1,10).sum();
    }

    /**
     * 打印从1到最大的n位数
     *
     * @param n n位数
     */
    public void print1ToMaxOfNDigits(int n) {
        if (n < 1) {
            return;
        }
        char[] chars = new char[n];
        Arrays.fill(chars, '0');
        while (increment(chars)) {
            printNumber(chars);
        }
    }

    private boolean increment(char[] chars) {
        int n = chars.length;
        int carry = 1;
        for (int i = n - 1; i >= 0; --i) {
            int sum = chars[i] - '0' + carry;
            if (sum > 9) {
                if (i == 0) {
                    return false;
                }
                chars[i] = '0';
            } else {
                ++chars[i];
                break;
            }
        }
        return true;
    }

    /**
     * 打印字符数组表示的数字（需要省略前n个0）
     *
     * @param chars 字符数组
     */
    private void printNumber(char[] chars) {
        int i = 0, n = chars.length;
        for (; i < n; ++i) {
            if (chars[i] != '0') {
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (; i < n; ++i) {
            sb.append(chars[i]);
        }
        System.out.println(sb.toString());
    }




}
