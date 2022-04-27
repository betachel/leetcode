package com.beta.study.leetcode;

import java.util.LinkedList;
import java.util.List;

import com.beta.study.model.TreeNode;

/**
 * @author shiqiu
 * @date 2022/04/27
 */
public class _257_BinaryTreePaths {

    List<String> path = new LinkedList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> subPath = new LinkedList<>();
        path(root, subPath);

        path_2(root,"");

        return path;
    }

    private void path(TreeNode root, List<Integer> subPath) {

        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            subPath.add(root.val);

            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < subPath.size(); i++) {
                stringBuilder.append(subPath.get(i));
                if (i < subPath.size() - 1) {
                    stringBuilder.append("->");
                }
            }
            path.add(stringBuilder.toString());
            subPath = new LinkedList<>();

            return;
        }
        subPath.add(root.val);

        if (root.left != null) {
            path(root.left, subPath);
            subPath.remove(subPath.size() - 1);
        }
        if (root.right != null) {
            path(root.right, subPath);
            subPath.remove(subPath.size() - 1);
        }
    }

    private void path_2(TreeNode root, String pathstr) {

        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            pathstr += root.val;
            path.add(pathstr);
            return;
        }
        path_2(root.left, pathstr + root.val + "->");
        path_2(root.right, pathstr + root.val + "->");

    }
}
