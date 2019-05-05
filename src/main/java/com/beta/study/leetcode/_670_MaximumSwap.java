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
        int num = 9973;

        System.out.println(maximumSwap(num));
    }

    public static int maximumSwap(int num) {
        int result = 0;

        int[] array = new int[9];

        int temp = num , i = 0 , max = -1 , div = 0 , index = 0 ;

        while ( temp > 0 ) {
            div =  temp % 10;

            if ( div > max ) {
                max =  div > max ? div : max;
                index = i;
            }
           max =  div > max ? div : max;
            array[i++] =div ;

            temp = temp / 10;

        }

        temp = array[i-1];
        array[i-1] = array[index];
        array[index] = temp;

        while (i >= 0 ) {
            result = array[i]  + result * 10;
            i--;
        }

        return result;
    }
}
