package com.beta.study.huawei.nowcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author shiqiu
 * @date 2022/04/11
 */
public class HJ26 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();
        if (string == null || string.length() == 0) {
            return;
        }

        List<Character> list = new LinkedList<>();
        for (int i = 0; i < string.length(); i++) {
            if (isLetter(string.charAt(i))) {
                list.add(string.charAt(i));
            }
        }
        list.sort(Comparator.comparingInt(c -> chatToInt(c)));
        for (int i = 0,j=0; i < string.length(); i++) {
            if (isLetter(string.charAt(i))) {
                System.out.print(list.get(j++));
            } else {
                System.out.print(string.charAt(i));
            }
        }

    }

    private static boolean isLetter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    private static int chatToInt(char c) {
        if (c >= 'a' && c <= 'z') {
            return c - 'a';
        }
        return c - 'A';
    }
}
