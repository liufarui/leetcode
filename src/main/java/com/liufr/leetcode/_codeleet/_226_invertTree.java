package com.liufr.leetcode._codeleet;

/**
 * @author lfr
 * @date 2020/8/3 22:49
 *
 * 226. 翻转二叉树
 */
public class _226_invertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        invertTree(root.left);
        invertTree(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }
}
