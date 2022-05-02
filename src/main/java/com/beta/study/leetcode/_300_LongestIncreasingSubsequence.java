package com.beta.study.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shiqiu
 * @date 2022/04/02
 */
public class _300_LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = new int[] {0, 1, 0, 3, 2, 3};
        _300_LongestIncreasingSubsequence instance = new _300_LongestIncreasingSubsequence();
        int result = instance.lengthOfLIS(nums);
        System.out.println(result);
    }

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("error");
        }
        int len = nums.length, maxLength = 0;
        //动态规划，dp[i] 以元素i为结尾的上升子序列的长
        int[] dp = new int[len];

        for (int i = 0; i < len; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(dp[i], maxLength);
        }

        return maxLength;
    }
}
