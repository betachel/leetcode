package com.beta.study.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shiqiu
 * @date 2022/04/02
 */
public class _347_TopKFrequentElements {
    public static void main(String[] args) {
        int[] nums = new int[] {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] result = (new _347_TopKFrequentElements()).topKFrequent(nums, k);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1 || k > nums.length) {
            throw new IllegalArgumentException("error");
        }
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        int maxCount = 0;
        for (int i = 0; i < nums.length; i++) {
            Integer count = map.get(nums[i]);
            count = count == null ? 1 : count + 1;
            map.put(nums[i], count);
            maxCount = Math.max(maxCount, count);
        }
        //用数组存储元素，出现次数为下标，值为原数组元素，可以预见，数组最大长度等于原数组长度
        //int[] countArray = new int[nums.length];
        String[] countArray = new String[maxCount+1];
        map.forEach((item, count) -> {
            String vv = countArray[count];
            if (vv == null) {
                vv = String.valueOf(item);
            } else {
                vv = vv + "," + item;
            }
            countArray[count] = vv;
        });

        int[] result = new int[k];
        int index = 0;
        for (int i = maxCount; i >=0; i--) {
            String vv = countArray[i];
            if (vv != null && vv.length() > 0) {
                for (String v :vv.split(",")) {
                    if (index+1<=k) {
                        result[index++] = Integer.valueOf(v);
                        continue;
                    }
                    return result;
                }
            }
        }
        return result;
    }
}
