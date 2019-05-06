package com.beta.study.leetcode;

/**
 * Given a non-negative integer, you could swap two digits at most once to get the maximum valued number. Return the maximum valued number you could get.
 *
 * Example 1:
 * Input: 2736
 * Output: 7236
 * Explanation: Swap the number 2 and the number 7.
 * Example 2:
 * Input: 9973
 * Output: 9973
 * Explanation: No swap.
 * Note:
 * The given number is in the range [0, 10^8]
 *
 * @author shiqiu
 * @date 2019/05/05
 */
public class _670_MaximumSwap {
    public static void main(String[] args) {
        int num = 993886;

        System.out.println(maximumSwap(num));
    }

    public static int maximumSwap(int num) {
        int result = 0;

        int[] array = new int[ 9 ];

        int temp = num, length = 0, max = -1, mod = 0;

        while ( temp > 0 ) {
            mod = temp % 10;

            max = mod > max ? mod : max;
            array[ length++ ] = mod;

            temp = temp / 10;

        }

        boolean flag = true;
        for ( int i = length - 1 ; i > 0 && flag ; i-- ) {
            if ( array[ i ] != max ) {
                int max2 = -1, index = i;
                for ( int j = i - 1 ; j >= 0 ; j-- ) {
                    if ( array[ j ] >= max2 ) {
                        max2 = array[ j ];
                        index = j;
                    }
                }

                if ( array[ i ] < max2 ) {
                    temp = array[ index ];
                    array[ index ] = array[ i ];
                    array[ i ] = temp;
                    flag = false;

                }
            }
        }

        while ( ( length-- ) > 0 ) {
            result = array[ length ] + result * 10;
        }

        return result;
    }
}
