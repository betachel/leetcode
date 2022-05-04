package com.beta.study.leetcode;

import com.beta.study.utils.ArrayUtils;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * <p>
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * <p>
 * The replacement must be in-place and use only constant extra memory.
 * <p>
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * <p>
 * 1,2,3 → 1,3,2 1,3,2 → 2,1,3 3,2,1 → 1,2,3 1,1,5 → 1,5,1
 *
 * @author shiqiu
 * @date 2019/07/02
 */
public class _31_NextPermutation {
    public static void main(String[] args) {
        int[] nums = new int[] {1, 3, 2};
        _31_NextPermutation instance = new _31_NextPermutation();

        instance.nextPermutation(nums);

        ArrayUtils.print(nums);
    }

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int length = nums.length;
        //思路，从后往前找，找到第一个比最后元素小的元素，二者交换；然后把该元素到末尾元素升序
        //参考解析：https://leetcode-cn.com/problems/next-permutation/solution/xia-yi-ge-pai-lie-suan-fa-xiang-jie-si-lu-tui-dao-/
        int i = length - 2;
        //从后往前找相邻的降序元素
        for (; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                break;
            }
        }
        if (i >= 0) {
            //从i+1到结尾，找第一个比i大的元素
            int j = length - 1;
            for (; j > i; j--) {
                if (nums[j] > nums[i]) {
                    break;
                }
            }
            if (j > i) {
                swap(nums, i, j);
            }
        }
        //此时i+1到结尾，一定是降序的（分析：num[i+1]最大，num[j-1] > num[j] > num[i] > num[j+1] ），所以逆序i+1到结尾元素（原本应该是排序，但是因为是降序，直接逆序就好）
        reverse(nums, i + 1, length-1);

    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
