package com.beta.study.leetcode;

import com.beta.study.model.TreeNode;

/**
 * @author shiqiu
 * @date 2022/05/04
 */
public class _129_SumRoottoLeafNumbers {

    public static void main(String[] args) {
        _129_SumRoottoLeafNumbers instance = new _129_SumRoottoLeafNumbers();
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;

        int sum = instance.sumNumbers(root);
        System.out.println(sum);
    }

    Integer sum = new Integer(0);

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            throw new IllegalArgumentException("error");
        }
        view(root, 0);
        return sum;
    }

    private void view(TreeNode root, int pathNum) {
        if (root == null) {
            return;
        }
        int sub = pathNum * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum += sub;
        }
        view(root.left, sub);
        view(root.right, sub);
    }
}
