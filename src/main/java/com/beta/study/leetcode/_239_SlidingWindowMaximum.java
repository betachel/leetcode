package com.beta.study.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shiqiu
 * @date 2022/04/02
 */
public class _239_SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = new int[] {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = (new _239_SlidingWindowMaximum()).maxSlidingWindow_v1(nums, k);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    /**
     * 每次都去找当前滑动窗口的最大值 毫不客气的是：提交后超时了，参考：https://leetcode-cn.com/submissions/detail/293501601/
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow_v1(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1 || k > nums.length) {
            throw new IllegalArgumentException("error");
        }
        List<Integer> list = new ArrayList<>(nums.length);
        for (int i = 0; i <= nums.length - k; i++) {
            int max = getMax(nums, i, k);
            list.add(max);
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private int getMax(int[] nums, int start, int k) {
        int max = nums[start];
        for (int i = 1; i < k; i++) {
            max = Math.max(max, nums[start + i]);
        }
        return max;
    }
}
