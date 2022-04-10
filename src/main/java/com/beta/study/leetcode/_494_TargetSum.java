package com.beta.study.leetcode;

/**
 * @author shiqiu
 * @date 2022/04/10
 */
public class _494_TargetSum {
    private int count = 0;

    public int findTargetSumWays(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        dfs(nums, target, 0, 0);
        return count;
    }

    private void dfs(int[] nums, int target, int sum, int index) {
        if (index == nums.length) {
            if (sum == target) {
                count++;
            }
            return;
        }
        dfs(nums, target, sum + nums[index], index + 1);
        dfs(nums, target, sum - nums[index], index + 1);

    }
}
