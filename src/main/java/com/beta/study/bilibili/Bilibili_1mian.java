package com.beta.study.bilibili;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * two sum变种题 给你一个有序数据，找对应的两个数，使得它们的和为0； 注意有重复元素，也算做不同的组合
 *
 * @author shiqiu
 * @date 2022/04/14
 */
public class Bilibili_1mian {
    public static void main(String[] args) {
        int[] nums = new int[] {-3, -3, 0, 0, 0, 3, 3};

        System.out.println(process(nums));
        System.out.println(process_v2(nums));
    }

    /**
     * 借助map，和two sum解法差不多
     *
     * @param nums
     * @return
     */
    private static int process(int[] nums) {
        if (null == nums || nums.length < 2) {
            return 0;
        }
        int len = nums.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < len; i++) {
            int key = nums[i];
            int sub = 0 - key;
            if (map.containsKey(sub)) {
                List<Integer> values = map.get(sub);
                count += values.size();

            }
            List<Integer> values = Optional.ofNullable(map.get(key)).orElseGet(LinkedList::new);
            values.add(key);
            map.put(key, values);

        }
        return count;
    }

    /**
     * 数组有序，考虑双指针
     *
     * @param nums
     * @return
     */
    private static int process_v2(int[] nums) {
        if (null == nums || nums.length < 2) {
            return 0;
        }
        int len = nums.length;
        int start = 0, end = len - 1;
        int count = 0;

        while (start < end && start < len && end > 0) {
            int left = nums[start];
            int right = nums[end];
            int sum = nums[start] + nums[end];
            if (sum == 0) {
                int leftStep = 1, rightStep = 1;
                while (start < end && nums[start] == left) {
                    start++;
                    leftStep++;
                }
                while (start < end && nums[end] == right) {
                    end--;
                    rightStep++;
                }
                count += left == 0 ? (leftStep * rightStep) / 2 : leftStep * rightStep;

            } else if (sum > 0) {
                end--;
            } else {
                start++;
            }
        }
        return count;
    }
}
