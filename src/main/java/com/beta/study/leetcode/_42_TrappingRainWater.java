package com.beta.study.leetcode;

/**
 * @author shiqiu
 * @date 2022/05/03
 */
public class _42_TrappingRainWater {

    public int trap(int[] height) {
        if (null == height || height.length == 0) {
            throw new IllegalArgumentException("error");
        }
        int length = height.length, sum = 0;
        /**
         * 解题思路：按列求，对于每一列，找其左边最高的高度和其右边最高的高度，而且去最小，然后与当前高度相减，大于0，则计算在总和中，否则丢弃
         */
        for (int i = 0; i < length; i++) {
            //找左边最高
            int maxLeft = 0;
            for (int j = 0; j < i; j++) {
                maxLeft = Math.max(maxLeft, height[j]);
            }
            //找右边最高
            int maxRight = 0;
            for (int j = i + 1; j < length; j++) {
                maxRight = Math.max(maxRight, height[j]);
            }
            int minHight = Math.min(maxRight, maxLeft);
            if (minHight > height[i]) {
                sum += minHight - height[i];
            }
        }
        return sum;
    }
}
