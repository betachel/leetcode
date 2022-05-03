package com.beta.study.leetcode;

/**
 * @author shiqiu
 * @date 2022/05/03
 */
public class _42_TrappingRainWater {
    public static void main(String[] args) {
        int[] height = new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        _42_TrappingRainWater instance = new _42_TrappingRainWater();
        int sum = instance.trap_2(height);
        System.out.println(sum);
    }

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

    public int trap_2(int[] height) {
        if (null == height || height.length == 0) {
            throw new IllegalArgumentException("error");
        }
        int length = height.length, sum = 0;
        /**
         * 解题思路：按列求，对于每一列，找其左边最高的高度和其右边最高的高度，而且去最小，然后与当前高度相减，大于0，则计算在总和中，否则丢弃
         * 还是基于上述思路，每次找左右最高都需要循环找，其实不用
         * 当前下标i左边最高其实等于max(i-1左边最高，height[i-1])；右边最高同理，所以考虑用两个数字来存储
         * 优化效果明显
         */
        int[] leftHeight = new int[length];
        leftHeight[0] = 0;
        for (int i = 1; i < length; i++) {
            leftHeight[i] = Math.max(leftHeight[i - 1], height[i - 1]);
        }
        int[] rightHeight = new int[length];
        rightHeight[length - 1] = 0;
        for (int i = length - 2; i >= 0; i--) {
            rightHeight[i] = Math.max(rightHeight[i + 1], height[i + 1]);
        }

        for (int i = 0; i < length; i++) {
            //左右最高取最小
            int minHight = Math.min(leftHeight[i], rightHeight[i]);
            if (minHight > height[i]) {
                sum += minHight - height[i];
            }
        }
        return sum;
    }
}
