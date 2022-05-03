package com.beta.study.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.beta.study.model.TreeNode;

/**
 * @author shiqiu
 * @date 2022/05/03
 */
public class _199_BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new LinkedList<Integer>();
        }
        //右视图，可以转换为层序遍历的，每次只取每层的最后一个元素
        List<Integer> list = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelCount = queue.size();
            int value = queue.peek().val;
            while (levelCount > 0) {
                TreeNode node = queue.poll();
                value = node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                levelCount--;
            }
            list.add(value);

        }
        return list;
    }

}
