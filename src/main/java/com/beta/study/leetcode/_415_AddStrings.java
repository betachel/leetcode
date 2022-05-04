package com.beta.study.leetcode;

/**
 * @author shiqiu
 * @date 2022/05/04
 */
public class _415_AddStrings {
    public String addStrings(String num1, String num2) {
        if (num1 == null || num2 == null) {
            return num1 == null ? num2 : num1;
        }
        int len1 = num1.length(), len2 = num2.length();
        int add = 0;
        StringBuilder sb = new StringBuilder();
        int i = len1 - 1, j = len2 - 1;
        while (i >= 0 || j >= 0 || add != 0) {
            int a = 0, b = 0;
            if (i >= 0) {
                a = Integer.valueOf(num1.charAt(i) - '0');
                i--;
            }
            if (j >= 0) {
                b = Integer.valueOf(num2.charAt(j) - '0');
                j--;
            }
            int val = (a + b + add) % 10;
            sb.append(val);
            add = (a + b + add) / 10;
        }

        len1 = sb.length();
        String result = "";
        for (i = len1 - 1; i >= 0; i--) {
            result += sb.charAt(i);
        }
        return result;
    }
}
