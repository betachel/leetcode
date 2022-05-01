package com.beta.study.practice;

import java.util.Random;
import java.util.stream.Stream;

import com.beta.study.utils.ArrayUtils;

/**
 * @author shiqiu
 * @date 2022/04/28
 */
public class QuickSort {
    /**
     * 随机类
     */
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        int[] nums = new int[] {78, 98, 2, 0, 83, 78, 54, 32, 78, 8};
        System.out.println("before sort : ");
        ArrayUtils.print(nums);
        (new QuickSort()).quickSort(nums);
        System.out.println("after sort : ");
        ArrayUtils.print(nums);

    }

    public int[] quickSort(int[] nums) {
        if (null == nums || nums.length == 0) {
            throw new IllegalArgumentException("param is error!");
        }
        quickSort(nums, 0, nums.length - 1);

        return nums;

    }

    private void quickSort(int[] nums, int start, int end) {
        if (null == nums || nums.length == 0 || (start < 0 || start >= nums.length) || (end < 0 || end >= nums.length) || start > end) {
            return;
        }
        //判断当前数组段是否有序，如果有序，直接返回，对有序数组排序，快排性能严重下降，所以增加一个优化
        if (isSorted(nums, start, end)) {
            return;
        }
        int partitionIndex = partition(nums, start, end);
        //基于基准位置，左右递归循环
        quickSort(nums, start, partitionIndex - 1);
        quickSort(nums, partitionIndex + 1, end);

    }

    private int partition(int[] nums, int start, int end) {
        if (null == nums || nums.length == 0 || (start < 0 || start >= nums.length) || (end < 0 || end >= nums.length) || start > end) {
            return -1;
        }
        int left = start, right = end;
        //随机一下比较元素
        int randomIndex = RANDOM.nextInt(right - left + 1) + left;
        //记得交换，很重要
        swap(nums, left, randomIndex);
        int temp = nums[left];
        while (left < right) {
            //从右往左找第一个比基准元素小的元素
            while (left < right && nums[right] >= temp) {
                right--;
            }
            //把右边第一个比基准小的元素放到左边
            if (left < right) {
                nums[left] = nums[right];
            }
            //从左往右找第一个比基准元素大的元素
            while (left < right && nums[left] < temp) {
                left++;
            }
            //把左边第一个比基准大的元素放到右边
            if (left < right) {
                nums[right] = nums[left];
            }
        }
        //把基准元素放到合适位置
        nums[left] = temp;

        return left;
    }

    private boolean isSorted(int[] nums, int start, int end) {
        if (null == nums || nums.length == 0 || (start < 0 || start >= nums.length) || (end < 0 || end >= nums.length) || start > end) {
            return false;
        }
        for (int i = start; i < end; i++) {
            if (nums[i] > nums[i + 1]) {
                return false;
            }
        }
        return true;

    }

    private void swap(int[] nums, int from, int to) {
        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
    }
}
