package com.beta.study.leetcode;

/**
 * @author shiqiu
 * @date 2022/05/02
 */
public class _53_MaximumSubarray {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("error");
        }
        int sum = nums[0], len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i] = dp[i - 1] > 0 ? dp[i - 1] + nums[i] : nums[i];
            sum = Math.max(sum, dp[i]);
        }
        return sum;
    }
}
