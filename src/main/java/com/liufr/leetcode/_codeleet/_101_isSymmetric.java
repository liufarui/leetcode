package com.liufr.leetcode._codeleet;

/**
 * @author lfr
 * @date 2020/8/11 15:17
 *
 * 101. 对称二叉树
 *
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 解题思路：
 * 思路很简单，就是递归。
 * 比较左右子树，如果都为null，返回true；
 * 如果只有一个为null或者值不相等，返回false；
 * 如果值相等，则递归其左左和右右，左右和右左。
 * 代码如下：
 */
public class _101_isSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }

        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
