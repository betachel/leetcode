package com.beta.study.practice;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.beta.study.model.TreeNode;

/**
 * @author shiqiu
 * @date 2022/04/18
 */
public class TreeTraversal {

    /**
     * 树的层序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> levelTraversal(TreeNode root) {
        if (null == root) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<Integer> list = new LinkedList<Integer>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.getVal());
            if (node.getLeft() != null) {
                queue.add(node.getLeft());
            }
            if (node.getRight() != null) {
                queue.add(node.getRight());
            }
        }
        return list;

    }

    /**
     * 树的S型层序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> levelSshapeTraversal(TreeNode root) {
        if (null == root) {
            return null;
        }
        //利用双栈
        Deque<TreeNode> oddStack = new LinkedList<>();
        Deque<TreeNode> evenStack = new LinkedList<>();

        List<Integer> list = new LinkedList<Integer>();
        oddStack.add(root);
        while (!oddStack.isEmpty() || !evenStack.isEmpty()) {
            if (!oddStack.isEmpty()) {
                while (!oddStack.isEmpty()) {
                    TreeNode node = oddStack.pop();
                    list.add(node.getVal());
                    if (node.getRight() != null) {
                        evenStack.push(node.getRight());
                    }
                    if (node.getLeft() != null) {
                        evenStack.push(node.getLeft());
                    }
                }
            } else if (!evenStack.isEmpty()) {
                while (!evenStack.isEmpty()) {
                    TreeNode node = evenStack.pop();
                    list.add(node.getVal());
                    if (node.getLeft() != null) {
                        oddStack.push(node.getLeft());
                    }
                    if (node.getRight() != null) {
                        oddStack.push(node.getRight());
                    }
                }
            }
        }
        return list;

    }

}
