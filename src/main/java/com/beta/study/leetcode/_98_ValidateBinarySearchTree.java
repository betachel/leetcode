package com.beta.study.leetcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.beta.study.model.TreeNode;

/**
 * 本题最容易理解出错的地方：一个节点的所有左子树的值都小于该节点的值！ 二叉搜索树的中序遍历的结果是一个有序数组；所以一个节点的左子树遍历的最后一个节点（要么是本身，要么是其右子树节点）的值都比该节点值小！
 *
 * @author shiqiu
 * @date 2022/04/05
 */
public class _98_ValidateBinarySearchTree {

    public boolean isValidBST_v1(TreeNode root) {
        //中序遍历
        if (root == null) {
            return true;
        }
        //传统操作，中序遍历，然后判断是否有序
        List<Integer> list = new LinkedList<>();
        inorder(root, list);
        Iterator<Integer> iterator = list.iterator();
        int prev = iterator.next();
        while (iterator.hasNext()) {
            int cur = iterator.next();
            if (cur <= prev) {
                return false;
            }
            prev = cur;
        }
        return true;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    public boolean isValidBST(TreeNode root) {
        //中序遍历
        if (root == null) {
            return true;
        }
        //参考思路：https://leetcode.cn/problems/validate-binary-search-tree/solution/yi-zhang-tu-rang-ni-ming-bai-shang-xia-jie-zui-da-/
        boolean flag = dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
        return flag;
    }

    private boolean dfs(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        if (!dfs(root.left, min, root.val)) {
            return false;
        }
        if (!dfs(root.right, root.val, max)) {
            return false;
        }
        return true;
    }

}
