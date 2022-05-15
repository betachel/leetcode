package com.beta.study.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.beta.study.model.TreeNode;

/**
 * @author shiqiu
 * @date 2022/05/15
 */
public class _113_PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        List<Integer> path = new LinkedList<>();
        view(root, 0, targetSum, path, result);
        return result;
    }

    private void view(TreeNode root, int pathSum, int targetSum, List<Integer> path, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        int sum = pathSum + root.val;
        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (sum == targetSum) {
                result.add(new ArrayList<Integer>(path));
            }
            return;
        }
        if (root.left != null) {
            view(root.left, pathSum + root.val, targetSum, path, result);
            //注意这里为啥要移除最后一个元素，因为递归最后结束时path最后一个元素是当前节点的最后遍历孩子，对于下一次遍历，需要把该孩子移除，递归当前节点的其他孩子
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            view(root.right, pathSum + root.val, targetSum, path, result);
            path.remove(path.size() - 1);
        }
    }
}
