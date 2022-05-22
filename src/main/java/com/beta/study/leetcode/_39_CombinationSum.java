package com.beta.study.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author betachel
 * @date 2022/05/22
 */
public class _39_CombinationSum {
    public static void main(String[] args) {
        _39_CombinationSum instance = new _39_CombinationSum();
        int[] candidates = new int[] {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> result = instance.combinationSum(candidates, target);
        System.out.println();
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            throw new IllegalArgumentException("error");
        }
        //注意本题需要去重

        List<List<Integer>> result = new LinkedList<>();
        dfs(candidates, 0, target, 0, new LinkedList<>(), result);
        return result;
    }


    private void dfs(int[] candidates, int prefixSum, int target, int start, List<Integer> path, List<List<Integer>> result) {
        //注意本题需要去重，使用start就是用来做去重使用的
        if (start >= candidates.length) {
            return;
        }
        if (prefixSum >= target) {
            if (prefixSum == target) {
                result.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            /**
             * 下面这个if对于提升性能很关键啊！！
             * 不加时间空间超过人数很少
             * 加完直接超过很多人！！！
             */
            if (prefixSum + candidates[i] > target) {
                continue;
            }
            path.add(candidates[i]);
            dfs(candidates, prefixSum + candidates[i], target, i, path, result);
            path.remove(path.size() - 1);
        }
    }
}
