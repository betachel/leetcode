package com.beta.study.leetcode;

/**
 * @author shiqiu
 * @date 2022/05/08
 */
public class _162_FindPeakElement {

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3};
        _162_FindPeakElement instance = new _162_FindPeakElement();
        int index = instance.findPeakElement(nums);
        System.out.println(index);
    }

    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("error");
        }
        int len = nums.length, low = 0, high = len - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (mid == len - 1) {
                return mid;
            }
            if (nums[mid] > nums[mid + 1]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

}
