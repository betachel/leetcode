package com.beta.study.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author shiqiu
 * @date 2022/03/27
 */
public class _56_MergeIntervals {

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {8, 10}, {2, 6}, {15, 18}};
        _56_MergeIntervals instance = new _56_MergeIntervals();
        int[][] result = instance.merge(intervals);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i][0] + " " + result[i][1]);
        }
    }

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return intervals;
        }
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        List<int[]> list = new LinkedList<>();
        int row = intervals.length;
        for (int i = 0; i < row; ) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            int j = i + 1;
            for (; j < row; j++) {
                if (end < intervals[j][0]) {
                    break;
                }
                end = Math.max(end, intervals[j][1]);
            }
            i = j;
            int[] array = new int[] {start, end};
            list.add(array);
        }

        int[][] array = new int[list.size()][2];
        int i = 0;
        while (i < list.size()) {
            int[] temp = list.get(i);
            array[i][0] = temp[0];
            array[i][1] = temp[1];
            i++;
        }
        return array;
    }
}
