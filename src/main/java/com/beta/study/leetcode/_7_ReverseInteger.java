package com.beta.study.leetcode;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example 1:
 *
 * Input: 123
 * Output: 321
 * Example 2:
 *
 * Input: -123
 * Output: -321
 * Example 3:
 *
 * Input: 120
 * Output: 21
 * Note:
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [?231,  231 ? 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 *
 * @author shiqiu
 * @date 2019/05/06
 */
public class _7_ReverseInteger {
    public static void main( String[] args ) {
        int num = Integer.MAX_VALUE;

        System.out.println( reverse( num ) );

    }

    public static int reverse( int x ) {
        Long result = 0L;

        int temp = x, mod = 0;

        while ( temp > 0 ) {
            mod = temp % 10;

            temp = temp / 10;

            result = result * 10 + mod;

            if ( result > Integer.MAX_VALUE || result < Integer.MIN_VALUE ) {
                result = 0l;
                break;
            }
        }

        return result.intValue( );
    }
}
