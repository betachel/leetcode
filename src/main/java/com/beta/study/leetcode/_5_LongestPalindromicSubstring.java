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
        String str = "abaccdcc";

        System.out.println(longestPalindrome_dp( str ) );

    }

    /**
     * dp 解法
     * 设置一个二维数组 dp[i][j] , 表示子串i~j是一个回文串
     * 那么，dp[i-1][j+1] = s[i-1] == s[j+1] && dp[i][j] == true
     *
     * @param s
     * @return
     */
    public static String longestPalindrome_dp( String s ) {
        String result = "";

        if ( s == null || s.length( ) <= 1 ) {
            result = s;
        } else {
            int length = s.length( );
            boolean[][] dp = new boolean[ length ][ length ];
            for ( int i=0;i<length;i++ ) {
                dp[i][i] = true;
            }
            int maxLength = 0 , begin = 0;
            for ( int i = 1 ; i < length ; i++ ) {
                for ( int j = 0 ; j < i ; j++ ) {
                    if ( s.charAt( i ) == s.charAt( j ) )  {
                        if ( (i-1) >= 0 && (j+1) < length && (dp[j+1][i-1]  || (i-j == 1))) {
                            dp[j][i] = true;
                           if ( maxLength < (i-j+1) ) {
                               maxLength = i-j+1;
                               begin = j;
                           }
                        }
                    }

                }
            }

            if ( maxLength == 0 && begin == 0 ) {
                result = s.charAt( 0 ) + "";
            }else {
                result = s.substring( begin , begin + maxLength );
            }
        }

        return result;

    }
}
