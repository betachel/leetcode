package com.beta.study.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Example 1:
 * <p>
 * Input: "abcabcbb" Output: 3 Explanation: The answer is "abc", with the length of 3. Example 2:
 * <p>
 * Input: "bbbbb" Output: 1 Explanation: The answer is "b", with the length of 1. Example 3:
 * <p>
 * Input: "pwwkew" Output: 3 Explanation: The answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * @author shiqiu
 * @date 2019/06/02
 */
public class _3_LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String str = "abba";

        System.out.println(lengthOfLongestSubstring(str));
        System.out.println(lengthOfLongestSubstring_2(str));
        System.out.println(lengthOfLongestSubstring_3(str));

    }

    /**
     * 时间复杂度有点高啊
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int length = 1, i = 0;

        String subString = "";

        int strLength = s.length();
        while (i < strLength) {
            char c = s.charAt(i++);

            int index = subString.indexOf(c);
            if (index > -1) {
                subString = (index + 1) > subString.length() ? "" : subString.substring(index + 1);
            }
            subString = subString + c;

            length = Math.max(length, subString.length());

        }
        return length;
    }

    /**
     * 如果字符串只包含英文字母A-Za-z,可用这个方法
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring_2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int length = 1;
        int strLength = s.length();
        int[] charIndex = new int[26 * 2];

        int start = 0, i = 0;
        while (i < strLength) {
            char c = s.charAt(i++);

            int index = c < 'a' ? c - 'A' : c - 'a' + 26;

            start = Math.max(charIndex[index], start);
            charIndex[index] = i;

            length = Math.max(length, i - start);
        }
        return length;
    }

    public static int lengthOfLongestSubstring_3(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int length = 1, i = 0;
        int strLength = s.length();

        Map<Character, Integer> map = new HashMap<>(s.length());

        int start = 0;
        while (i < strLength) {
            Character c = s.charAt(i++);
            Integer index = map.get(c);
            start = Math.max(index == null ? 0 : index, start);
            length = Math.max(length, i - start);
            map.put(c, i);
        }
        return length;
    }
}
