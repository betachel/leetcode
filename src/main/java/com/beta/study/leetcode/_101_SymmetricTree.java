package com.beta.study.leetcode;

import com.beta.study.model.TreeNode;

/**
 * @author shiqiu
 * @date 2022/05/08
 */
public class _101_SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return compare(root.left, root.right);
    }

    private boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if ((left != null && right == null) || (left == null && right != null)) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        boolean isOutEqual = compare(left.left, right.right);
        boolean isInEqual = compare(left.right, right.left);
        return isOutEqual && isInEqual;

    }
}
