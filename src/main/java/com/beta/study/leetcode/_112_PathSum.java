package com.beta.study.leetcode;

import com.beta.study.model.TreeNode;

/**
 * @author shiqiu
 * @date 2022/05/15
 */
public class _112_PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        boolean result = view(root,0,targetSum);
        return result;
    }

    private boolean view(TreeNode root, int pathSum, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return pathSum + root.val == targetSum;
        }
        boolean result = view(root.left, pathSum + root.val, targetSum);
        if (result) {
            return true;
        }
        return view(root.right, pathSum + root.val, targetSum);
    }
}
