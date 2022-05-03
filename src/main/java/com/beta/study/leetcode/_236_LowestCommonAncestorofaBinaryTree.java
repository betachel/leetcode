package com.beta.study.leetcode;

import com.beta.study.model.TreeNode;

/**
 * @author shiqiu
 * @date 2022/05/03
 */
public class _236_LowestCommonAncestorofaBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //root为null或者root为其中一个节点，那么不需要找了，返回
        if (root == null || root == p || root == q) {
            return root;
        }
        //分别在左右子树找p q
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //如果左右子树都不为空，说明p q分列root左右子树，那么root就是公共祖先
        if (left != null && right != null) {
            return root;
        }
        //如果左子树为空，说明p q不在root的左子树中，那么就看右子树是否存在
        //此时如果right != null ，说明p q是包含关系，返回节点就是公共祖先，否则就是null，没找到
        if (left == null) {
            return right;
        }
        return left;

    }
}
