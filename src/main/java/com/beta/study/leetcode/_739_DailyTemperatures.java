package com.beta.study.leetcode;

/**
 * @author shiqiu
 * @date 2022/04/03
 */
public class _739_DailyTemperatures {
    public static void main(String[] args) {

    }

    /**
     * 暴力解法
     * 简单干脆~
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length <= 1) {
            throw new IllegalArgumentException("error");
        }
        int[] answer = new int[temperatures.length];
        int length = temperatures.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    answer[i] = j - i;
                    break;
                }
            }
        }
        return answer;
    }
}
