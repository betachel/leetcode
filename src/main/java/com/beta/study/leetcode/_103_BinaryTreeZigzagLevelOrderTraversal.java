package com.beta.study.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import com.beta.study.model.TreeNode;

/**
 * @author shiqiu
 * @date 2022/05/02
 */
public class _103_BinaryTreeZigzagLevelOrderTraversal {

    /**
     * 这个就是二叉树的S型遍历，双栈操作
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }
        Deque<TreeNode> leftStack = new LinkedList<>();
        Deque<TreeNode> rightStack = new LinkedList<>();
        leftStack.add(root);
        List<List<Integer>> result = new LinkedList<>();
        while (!leftStack.isEmpty() || !rightStack.isEmpty()) {
            if (!leftStack.isEmpty()) {
                List<Integer> subList = new LinkedList<>();
                result.add(subList);
                while (!leftStack.isEmpty()) {
                    TreeNode node = leftStack.pop();
                    subList.add(node.val);
                    if (node.left != null) {
                        rightStack.push(node.left);
                    }
                    if (node.right != null) {
                        rightStack.push(node.right);
                    }
                }
            }
            if (!rightStack.isEmpty()) {
                List<Integer> subList = new LinkedList<>();
                result.add(subList);
                while (!rightStack.isEmpty()) {
                    TreeNode node = rightStack.pop();
                    subList.add(node.val);
                    if (node.right != null) {
                        leftStack.push(node.right);
                    }
                    if (node.left != null) {
                        leftStack.push(node.left);
                    }
                }
            }
        }
        return result;
    }
}
