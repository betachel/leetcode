package com.beta.study.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author shiqiu
 * @date 2022/04/03
 */
public class _448_FindAllNumbersDisappearedInAnArray {

    /**
     * 已通过，但不是O(n)空间复杂度
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums == null || nums.length < 1) {
            throw new IllegalArgumentException("error");
        }
        byte[] array = new byte[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            array[nums[i]] = 1;
        }
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 1) {
                result.add(i);
            }
        }
        return result;
    }

}
