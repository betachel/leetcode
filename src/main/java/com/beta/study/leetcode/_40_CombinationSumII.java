package com.beta.study.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author betachel
 * @date 2022/05/22
 */
public class _40_CombinationSumII {
    public static void main(String[] args) {
        _40_CombinationSumII instance = new _40_CombinationSumII();
        int[] candidates = new int[] {2, 5, 2, 1, 2};
        int target = 5;
        List<List<Integer>> result = instance.combinationSum(candidates, target);
        System.out.println(result.size());
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            throw new IllegalArgumentException("error");
        }
        //注意本题需要去重
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(candidates);
        dfs(candidates, 0, target, 0, new LinkedList<>(), result);
        return result;
    }

    private void dfs(int[] candidates, int prefixSum, int target, int start, List<Integer> path, List<List<Integer>> result) {
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
                return;
            }
            //去重关键步骤
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            path.add(candidates[i]);
            dfs(candidates, prefixSum + candidates[i], target, i + 1, path, result);
            path.remove(path.size() - 1);
        }

    }
}
