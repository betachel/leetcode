package com.beta.study.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example 1:
 * <p>
 * Input: "babad" Output: "bab" Note: "aba" is also a valid answer. Example 2:
 * <p>
 * Input: "cbbd" Output: "bb"
 *
 * @author shiqiu
 * @date 2019/05/06
 */
public class _5_LongestPalindromicSubstring {
    public static void main(String[] args) {
        String str = "cbbd";

        //System.out.println(longestPalindrome_dp(str));

        System.out.println(longestPalindrome_v2(str));

    }

    /**
     * dp 解法 设置一个二维数组 dp[i][j] , 表示子串i~j是一个回文串 那么，dp[i-1][j+1] = s[i-1] == s[j+1] && dp[i][j] == true
     *
     * @param s
     * @return
     */
    public static String longestPalindrome_dp(String s) {
        String result = "";

        if (s == null || s.length() <= 1) {
            result = s;
        } else {
            int length = s.length();
            boolean[][] dp = new boolean[length][length];
            for (int i = 0; i < length; i++) {
                dp[i][i] = true;
            }
            int maxLength = 0, begin = 0;
            for (int i = 1; i < length; i++) {
                for (int j = 0; j < i; j++) {
                    if (s.charAt(i) == s.charAt(j)) {
                        if (dp[j + 1][i - 1] || (i - j == 1)) {
                            dp[j][i] = true;
                            if (maxLength < (i - j + 1)) {
                                maxLength = i - j + 1;
                                begin = j;
                            }
                        }
                    }

                }
            }

            if (maxLength == 0 && begin == 0) {
                result = s.charAt(0) + "";
            } else {
                result = s.substring(begin, begin + maxLength);
            }
        }

        return result;

    }

    /**
     * 暂未通过，sad。。。。。。
     * @param s
     * @return
     */
    private static String longestPalindrome_v2(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        Map<Character, Integer> map = new HashMap<>(s.length());
        int start = 0, maxLength = 0;
        String result = String.valueOf(s.charAt(0));
        for (int i = 0; i < s.length(); i++) {
            Character character = s.charAt(i);
            if (map.containsKey(character)) {
                start = map.get(character);
                if (isValid(s, start, i)) {
                    if (maxLength < (i - start + 1)) {
                        result = s.substring(start, i + 1);
                        maxLength = i - start + 1;
                    }
                }
            }
            map.put(character,i);
        }
        return result;
    }

    private static boolean isValid(String s, int start, int end) {
        if (s == null || s.isEmpty() || start < 0 || start > s.length() || end < 0 || end > s.length() || start > end) {return false;}
        int length = end - start + 1;
        for (int i = 0; i < length / 2; i++) {
            if (s.charAt(start + i) != s.charAt(end - i)) {return false;}
        }
        return true;
    }

}
