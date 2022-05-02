package com.beta.study.leetcode;

import java.util.stream.Stream;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 *
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 *
 * The replacement must be in-place and use only constant extra memory.
 *
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 *
 * 1,2,3 → 1,3,2
 * 1,3,2 → 2,1,3
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * @author shiqiu
 * @date 2019/07/02
 */
public class _31_NextPermutation {
    public static void main(String[] args) {
        int[] nums = new int[] {1, 1, 1, 2};

        nextPermutation(nums);

        for ( int i = 0; i < nums.length; i++ ) {
            System.out.print(nums[i]);
            if ( i + 1 != nums.length ) {
                System.out.print(" , ");
            }
        }
    }

    public static void nextPermutation(int[] nums) {
        if ( nums != null && nums.length > 0 ) {
            int length = nums.length;
            int last = nums[length - 1];
            int i = length - 2;
            for ( ; i >= 0; i-- ) {
                if ( nums[i] < last ) {
                    int temp = nums[length - 1];
                    nums[length - 1] = nums[i];
                    nums[i] = temp;

                    if ( i > 0 && nums[i - 1] < nums[i] ) {
                        temp = nums[i - 1];
                        nums[i - 1] = nums[i];
                        nums[i] = temp;
                        break;
                    }

                    break;
                }
            }
            if ( i < 0 ) {
                i = 0;
                while ( i < ( length - i - 1 ) ) {
                    int temp = nums[i];
                    nums[i] = nums[length - i - 1];
                    nums[length - i - 1] = temp;
                    i++;
                }
            }
        }
    }
}
