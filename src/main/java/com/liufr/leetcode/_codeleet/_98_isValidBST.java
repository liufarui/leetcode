package com.liufr.leetcode._codeleet;

/**
 * @author lfr
 * @date 2020/8/11 9:44
 *
 * 98. 验证二叉搜索树
 *
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 假设一个二叉搜索树具有如下特征：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * 解题思路：
 * 原本用的简单递归的方法，但是发现就算所有节点都满足左节点小于自己，右节点大于自己，也不一定能满足要求，
 * 比如：
 *       10
 *    5       15
 *           6  20
 * 以上这种情况。
 * 所以作比较的时候，需要用左子树中最大的元素和右子树中最小的元素和根元素作比较。
 * 此时时间复杂度为nlogn
 */
public class _98_isValidBST {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (root.left != null && (getLeftLargest(root.left) >= root.val || !isValidBST(root.left))) {
            return false;
        }
        if (root.right != null && (getRightSmallest(root.right) <= root.val || !isValidBST(root.right))) {
            return false;
        }
        return true;
    }

    int getLeftLargest(TreeNode node) {
        while (node.right != null) {
            node = node.right;
        }
        return node.val;
    }

    int getRightSmallest(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.val;
    }
}
