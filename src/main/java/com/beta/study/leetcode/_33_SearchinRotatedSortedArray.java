package com.beta.study.leetcode;

/**
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * <p>
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * <p>
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 *
 * @author shiqiu
 * @date 2022/05/03
 */
public class _33_SearchinRotatedSortedArray {

    public static void main(String[] args) {
        int[] nums = new int[] {3, 1};
        int target = 1;
        int result = (new _33_SearchinRotatedSortedArray()).search(nums, target);
        System.out.println(result);
    }

    public int search(int[] nums, int target) {
        //题目太啰嗦了，其实就是在数组中中目标值；因为要求O(logn)所以，只能用二分法
        if (null == nums || nums.length == 0) {
            throw new IllegalArgumentException("error");
        }
        int low = 0, high = nums.length - 1;
        //关键解法：如果左边小于中间数，那么左半部分有序，否则右半部分有序，然后需要确定target落在哪半部分，循环查找
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (nums[mid] == target) {
                return mid;
            }
            //左半部分有序
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && nums[mid] > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                //右半部分有序
                if (nums[mid] < target && nums[high] >= target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;

    }
}
