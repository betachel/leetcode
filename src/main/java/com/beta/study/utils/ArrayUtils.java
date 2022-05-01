package com.beta.study.utils;

/**
 * @author shiqiu
 * @date 2022/05/01
 */
public class ArrayUtils {

    public static void print(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            if (i < nums.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println();
    }
}
