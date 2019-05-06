package com.beta.study.leetcode;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: "cbbd"
 * Output: "bb"
 *
 * @author shiqiu
 * @date 2019/05/06
 */
public class _5_LongestPalindromicSubstring {
    public static void main( String[] args ) {
        String str = "";

    }

    public static String longestPalindrome( String s ) {
        String result = "";

        if ( s == null || s.length( ) == 0 ) {
            result = "";
        } else {
            int maxLength = 0;
            for ( int i = 0 ; i < s.length( ) ; i++ ) {
                char c = s.charAt( i );

                for ( int j = i + 1 ; j < s.length( ) ; j++ ) {
                    char b = s.charAt( j );

                }
            }
        }

        return result;

    }
}
