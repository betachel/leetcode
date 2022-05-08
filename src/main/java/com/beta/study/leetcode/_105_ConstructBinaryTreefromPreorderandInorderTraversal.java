package com.beta.study.leetcode;

import com.beta.study.model.TreeNode;

/**
 * @author shiqiu
 * @date 2022/05/05
 */
public class _105_ConstructBinaryTreefromPreorderandInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0 || preorder.length != inorder.length) {
            throw new IllegalArgumentException("error");
        }
        //参考解析：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--22/
        TreeNode root = helper(preorder, inorder, 0, preorder.length, 0, inorder.length);
        return root;
    }

    private TreeNode helper(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart >= preEnd || inStart >= inEnd) {
            return null;
        }
        //preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        int inRootIndex = inStart;
        while (inRootIndex < inEnd && inorder[inRootIndex] != rootVal) {
            inRootIndex++;
        }
        int leftCount = inRootIndex - inStart;
        root.left = helper(preorder, inorder, preStart + 1, preStart + leftCount + 1, inStart, inRootIndex);
        root.right = helper(preorder, inorder, preStart + leftCount + 1, preEnd, inRootIndex + 1, inEnd);
        return root;
    }
}
