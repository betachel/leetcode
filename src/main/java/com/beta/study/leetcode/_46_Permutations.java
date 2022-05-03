package com.beta.study.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author shiqiu
 * @date 2022/05/03
 */
public class _46_Permutations {
    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3};
        _46_Permutations instance = new _46_Permutations();
        List<List<Integer>> list = instance.permute(nums);
        System.out.println();
    }
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("error");
        }
        int[] visited = new int[nums.length];
        List<Integer> path = new ArrayList<>(nums.length);
        List<List<Integer>> list = new LinkedList<>();
        view(nums, visited, path, list);

        return list;
    }

    private void view(int[] nums, int[] visited, List<Integer> path, List<List<Integer>> list) {
        if (path.size() == nums.length) {
            list.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                path.add(nums[i]);
                view(nums, visited, path, list);
                path.remove(path.size() - 1);
                visited[i] = 0;
            }
        }
    }
}
