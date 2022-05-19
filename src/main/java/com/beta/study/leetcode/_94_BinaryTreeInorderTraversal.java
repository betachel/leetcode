package com.beta.study.leetcode;

import java.util.LinkedList;
import java.util.List;

import com.beta.study.model.TreeNode;

/**
 * @author shiqiu
 * @date 2022/04/05
 */
public class _94_BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> valuePath = new LinkedList<>();
        if (root == null) {
            return valuePath;
        }
        inorderTraversal(root, valuePath);
        return valuePath;

    }

    private void inorderTraversal(TreeNode root, List<Integer> valuePath) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, valuePath);
        valuePath.add(root.val);
        inorderTraversal(root.right, valuePath);

    }
}
