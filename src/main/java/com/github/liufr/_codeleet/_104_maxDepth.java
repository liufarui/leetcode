package com.github.liufr._codeleet;

/**
 * @author lfr
 * @date 2020/7/28 9:57
 *
 * 104. 二叉树的最大深度
 *
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 解题思路：
 * 递归深度，如果当前节点为null，返回0；
 * 如果当前节点不是null，返回它的左子节点和右子节点最大深度的最大值，然后加1（它本身的深度）。
 */
public class _104_maxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
