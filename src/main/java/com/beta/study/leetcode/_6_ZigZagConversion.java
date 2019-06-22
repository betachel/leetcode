package com.beta.study.leetcode;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string s, int numRows);
 * Example 1:
 *
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 *
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 *
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * @author shiqiu
 * @date 2019/06/02
 */
public class _6_ZigZagConversion {
    public static void main( String[] args ) {
        String str = "";
        int numRows = 3;

        System.out.println(convert( str , numRows ) );

    }

    public static  String convert(String s , int numRows) {
        if ( s == null || s.length() < 0 || numRows < 1 ) {
            return s;
        }

        return "";
    }
}
