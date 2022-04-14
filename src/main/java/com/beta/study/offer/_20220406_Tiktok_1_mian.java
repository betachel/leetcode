package com.beta.study.offer;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author shiqiu
 * @date 2022/04/06
 */
public class _20220406_Tiktok_1_mian {
    /**
     * 输入：i use java not use golang ，要求输出：golang use not java use i
     *
     * @param args
     */
    public static void main(String[] args) {
        _20220406_Tiktok_1_mian instance = new _20220406_Tiktok_1_mian();
        /**
         * 下面代码就是面试手写的，没问题；
         * 当时还提了解法二：双指针原地交换元素，没实现
         */
        String s = "i use java not use golang";

        String result = instance.stringProcessor(s);
        System.out.println(result);
        result = instance.stringProcessor_v2(s);
        System.out.println(result);
    }

    /**
     * 拆分，然后数组替换
     *
     * @param string
     * @return
     */
    private String stringProcessor(String string) {
        if (null == string || string.isEmpty()) {
            return string;
        }
        String[] arrays = string.split(" ");
        for (int i = 0, j = arrays.length - 1; i < arrays.length / 2; i++, j--) {
            String temp = arrays[i];
            arrays[i] = arrays[j];
            arrays[j] = temp;
        }
        String result = "";
        for (int i = 0; i < arrays.length; i++) {
            result += arrays[i];
            if (i < arrays.length - 1) {
                result += " ";
            }
        }

        return result;
    }

    /**
     * 利用栈
     * @param string
     * @return
     */
    private String stringProcessor_v2(String string) {
        if (null == string || string.isEmpty()) {
            return string;
        }
        Deque<String> stack = new LinkedList<String>();
        for (int i = 0; i < string.length(); ) {
            int j =i+1;
            while (j<string.length() && string.charAt(j) != ' ') j++;
            stack.push(string.substring(i,j));
            i=j;
        }

        StringBuilder stringBuilder = new StringBuilder();
        while(!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.toString();
    }
}
