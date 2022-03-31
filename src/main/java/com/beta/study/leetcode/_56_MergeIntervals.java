package com.beta.study.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author shiqiu
 * @date 2022/03/27
 */
public class _56_MergeIntervals {

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        _56_MergeIntervals mergeIntervals = new _56_MergeIntervals();
        int[][] result = mergeIntervals.merge(intervals);
        //for (int i = 0; i < result.length; i++) {
        //    System.out.println(result[i][0] + " " + result[i][1]);
        //}
    }

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return intervals;
        }
        int n = intervals.length;
        Map<Integer, Set<Integer>> map = new java.util.HashMap<>();
        for (int i = 0; i < n; i++) {
            int[] interval = intervals[i];
            for (int j = 0; j < interval.length; j++) {
                Set<Integer> set = map.getOrDefault(interval[j], new java.util.HashSet<>());
                set.add(i);
                map.put(interval[j], set);
            }
        }
        List<Set<Integer>> result = new ArrayList<>();
        map.forEach((k, v) -> {
            Set<Integer> set = new HashSet<>();
            result.add(set);
            for(int i: v) {
                int[] interval = intervals[i];
                for(int value : interval) {
                    if(value != k) {
                        set.add(value);
                    }
                }
            }

        });
        return null;
    }
}
