package com.beta.study.leetcode;

/**
 * @author shiqiu
 * @date 2022/05/02
 */
public class _121_BestTimetoBuyandSellStock {

    public int maxProfit(int[] prices) {
        if (null == prices || prices.length < 1) {
            throw new IllegalArgumentException("error");
        }
        int min = prices[0], max = 0, len = prices.length;
        for (int i = 1; i < len; i++) {
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return max;
    }
}
