package com.beta.study.leetcode;

/**
 * @author shiqiu
 * @date 2019/07/02
 */
public class _172_FactorialTrailingZeroes {

    public static void main( String[] args ) {
        int n = 10;

        System.out.println(trailingZeroes( n ) );
    }

    public static int trailingZeroes( int n ) {
        int count = 0;

        while ( n > 0 ) {
            int temp = n / 5;
            count += temp;
            n = temp;

        }
        return count;
    }
}
