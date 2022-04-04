package com.beta.study.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author shiqiu
 * @date 2022/04/04
 */
public class _394_DecodeString {
    public static void main(String[] args) {
        _394_DecodeString instance = new _394_DecodeString();
        String s = "100[leetcode]";
        String result = instance.decodeString(s);
        System.out.println(result);
    }

    public String decodeString(String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }
        Deque<Character> stack = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            Character character = s.charAt(i);
            if (character.equals(']')) {
                //考虑出栈，构造字符串
                Character ch = null;
                LinkedList<Character> list = new LinkedList<>();
                while (!(ch = stack.pop()).equals('[')) {
                    list.addFirst(ch);
                }
                //获取数字
                String countString = "";
                while (!stack.isEmpty() && isDigital(ch = stack.pop())) {
                    countString = ch + countString;
                }
                //前面while退出时，取到了一个非数字，这里需要塞回去
                if (!stack.isEmpty()) {stack.push(ch);}

                int count = Integer.valueOf(countString), j = 0;
                while (j < count) {
                    for (Character ch2 : list) {
                        stack.push(ch2);
                    }
                    j++;
                }

            } else {
                stack.push(character);
            }
        }
        String result = "";
        while (!stack.isEmpty()) {
            result = stack.pop() + result;
        }

        return result;
    }

    private boolean isDigital(char ch) {
        return ch >= '0' && ch <= '9';
    }

}
