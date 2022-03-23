package com.beta.study.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * <p>
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
 *
 * @author shiqiu
 * @date 2019/06/02
 */
public class _1_TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[] {};

        int target = 22;

        int[] result = twoSum_1(nums, target);

    }

    public static int[] twoSum_1(int[] nums, int target) {
        int length = nums.length;
        if (length < 1) {
            throw new RuntimeException("array invalid!!!");
        }
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }

        throw new RuntimeException("there is no pair that sum is " + target);
    }

    public static int[] twoSum_2(int[] nums, int target) {
        int length = nums.length;
        if (length < 1) {
            throw new RuntimeException("array invalid!!!");
        }
        Map<Integer, Integer> map = new HashMap<>(length);

        for (int i = 0; i < length; i++) {
            Integer sub = target - nums[i];

            if (map.containsKey(sub)) {
                return new int[] {map.get(sub), i};
            } else {
                map.put(nums[i], i);
            }
        }
        throw new RuntimeException("there is no pair that sum is " + target);
    }
}
