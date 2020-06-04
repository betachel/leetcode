package com.beta.study.offer;

import java.util.Arrays;

/**
 * 给定一个长度为N的数组，找出一个最长的单调自增子序列（不一定连续，但是顺序不能乱）。
 * 例如：给定一个长度为6的数组A{5， 6， 7， 1， 2， 8}，则其最长的单调递增子序列为{5，6，7，8}，长度为4.
 *
 * @author shiqiu
 * @date 2020/06/02
 */
public class LongestIncreaseSubsequence {
    public static void main(String[] args) {
        int[] arrays = new int[] {5, 6, 7, 1, 2, 8};

        int max = new LongestIncreaseSubsequence().getLongestLength(arrays);

        System.out.println(max);
    }

    private int getLongestLength(int[] arrays) {
        if ( arrays == null || arrays.length == 0 ) {
            return -1;
        }

        int[] dp = new int[arrays.length];
        Arrays.fill(dp, 1);

        for ( int i = 0; i < arrays.length; i++ ) {
            for ( int j = 0; j < i; j++ ) {
                if ( arrays[i] > arrays[j] ) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 1;
        for ( int i = 0; i < dp.length; i++ ) {
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
