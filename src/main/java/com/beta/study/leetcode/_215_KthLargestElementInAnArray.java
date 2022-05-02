package com.beta.study.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author shiqiu
 * @date 2022/04/01
 */
public class _215_KthLargestElementInAnArray {
    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        _215_KthLargestElementInAnArray instance = new _215_KthLargestElementInAnArray();
        int result = instance.findKthLargest(nums, 4);
        System.out.println(result);
    }

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1 || k > nums.length) {
            throw new IllegalArgumentException("error");
        }
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public int findKthLargest_v2(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1 || k > nums.length) {
            throw new IllegalArgumentException("error");
        }
        //小顶堆，堆超过K后，只要后面发现比堆顶大的元素，移除堆顶，然后add，这样就能保证堆里面的元素都大于堆顶
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k);

        for (int i = 0; i < nums.length; i++) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(nums[i]);
            } else if (nums[i] > priorityQueue.peek()) {
                priorityQueue.poll();
                priorityQueue.add(nums[i]);
            }
        }
        return priorityQueue.peek();
    }
}
