package com.beta.study.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author shiqiu
 * @date 2022/05/13
 */
public class _22_GenerateParentheses {

    private List<String> result = new LinkedList<>();

    public List<String> generateParenthesis(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("error");
        }
        dfs("", 0, 0, n);
        return result;
    }

    private void dfs(String path, int leftCount, int rightCount, int n) {
        if (leftCount == n && rightCount == n) {
            result.add(path);
            return;
        }
        if (leftCount > rightCount) {
            return;
        }
        if (leftCount < n) {
            dfs(path + "(", leftCount + 1, rightCount, n);
        }
        if (rightCount < n) {
            dfs(path + ")", leftCount, rightCount + 1, n);
        }
    }
}
