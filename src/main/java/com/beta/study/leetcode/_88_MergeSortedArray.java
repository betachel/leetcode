package com.beta.study.leetcode;

import com.beta.study.utils.ArrayUtils;

/**
 * @author shiqiu
 * @date 2022/05/04
 */
public class _88_MergeSortedArray {
    public static void main(String[] args) {
        _88_MergeSortedArray instance = new _88_MergeSortedArray();
        int[] nums1 = new int[] {1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[] {2, 5, 6};
        instance.merge(nums1, 3, nums2, nums2.length);

        ArrayUtils.print(nums1);

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null || nums1.length < (m + n)) {
            return;
        }
        /**
         * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
         * 输出：[1,2,2,3,5,6]
         */
        int p1 = m - 1, p2 = n - 1, index = m + n - 1;
        while (p2 >= 0) {
            if (p1 >= 0 && p2 >= 0) {
                if (nums1[p1] < nums2[p2]) {
                    nums1[index] = nums2[p2];
                    p2--;
                    index--;
                } else {
                    nums1[index] = nums1[p1];
                    p1--;
                    index--;
                }
            } else {
                while (p2 >= 0) {
                    nums1[index] = nums2[p2];
                    p2--;
                    index--;
                }
            }
        }
    }
}
