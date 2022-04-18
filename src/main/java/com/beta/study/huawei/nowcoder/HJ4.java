package com.beta.study.huawei.nowcoder;

import java.util.Scanner;

/**
 * 描述 •输入一个字符串，请按长度为8拆分每个输入字符串并进行输出；
 * <p>
 * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。 输入描述： 连续输入字符串(每个字符串长度小于等于100)
 * <p>
 * 输出描述： 依次输出所有分割后的长度为8的新字符串
 * <p>
 * 示例1 输入： abc 复制 输出： abc00000
 *
 * @author shiqiu
 * @date 2022/04/10
 */
public class HJ4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String string = in.nextLine();
        if (string == null || string.length() == 0) {
            return;
        }
        for (int i = 0; i < string.length(); i += 8) {
            for(int j = 0; j < 8; j++) {
                if (i + j < string.length()) {
                    System.out.print(string.charAt(i + j));
                }else {
                    System.out.print("0");
                }
            }
            System.out.println();
        }
    }
}
