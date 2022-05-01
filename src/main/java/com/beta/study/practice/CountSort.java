package com.beta.study.practice;

import com.beta.study.utils.ArrayUtils;

/**
 * 基于计数排序
 *
 * @author shiqiu
 * @date 2022/05/01
 */
public class CountSort {

    public static void main(String[] args) {
        int[] nums = new int[] {78, 98, 2, 0, 83, 78, 54, 32, 78, 8};
        CountSort instance = new CountSort();
        instance.countSort(nums);
        System.out.println("after sort : ");
        ArrayUtils.print(nums);
    }

    /**
     * 对数组进行排序，已知数组的每个元素都在0-100之间，无需考虑内存溢出情况 因为元素范围确定，所以可以基于计数排序，时间复杂度O(max(nums[i])) , 空间复杂度O(max(nums[i]))
     *
     * @param nums
     */
    public void countSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int len = nums.length;
        //用一个数组记录每个元素出现频率，因为原数组元素值在0-100，所以，此数组元素最多101个
        int countLen = 101;
        int[] countArray = new int[countLen];
        for (int i = 0; i < len; i++) {
            countArray[nums[i]]++;
        }
        for (int i = 0, j = 0; i < countLen && j < len; i++) {
            int count = countArray[i];
            if (count == 0) {
                continue;
            }
            int temp = 0;
            while (temp++ < count) {
                nums[j++] = i;
            }
        }
    }

}
