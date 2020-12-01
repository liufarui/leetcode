package com.github.liufr._codeleet;

/**
 * @author lfr
 * @date 2020/8/13 9:47
 *
 * 124. 二叉树中的最大路径和
 *
 * 给定一个非空二叉树，返回其最大路径和。
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。
 * 该路径至少包含一个节点，且不一定经过根节点。
 *
 * 解题思路：
 * 动态规划；
 * 维护一个maxPathX，记录当前最大值；
 * 从根节点开始：
 * 如果左右子节点都为空，则直接返回自己本身的值；
 * 如果左右子节点有不为空的，则递归计算左子树的最长路径和右子树的最长路径；
 * 本身加上左右子树最长路径的大值，则是当前节点的最长路径（当前节点非根或者当前节点只连一个子树）
 * 值得注意的是，本身和左右子树最大路径的和，以及本身分别和左右子树的和，也是路径长度的可能性之一，需要计算。
 */
public class _124_maxPathSum {
    private static int maxPathX;

    public int maxPathSum(TreeNode root) {
        maxPathX = Integer.MIN_VALUE;
        maxPathSumTemp(root);
        return maxPathX;
    }

    private int maxPathSumTemp(TreeNode root) {
        if (root.left == null && root.right == null) {
            maxPathX = Math.max(maxPathX, root.val);
            return root.val;
        }
        int maxPath = root.val;

        int tempLeft = 0;
        int tempRight = 0;
        if (root.left != null) {
            tempLeft = maxPathSumTemp(root.left);
        }
        if (root.right != null) {
            tempRight = maxPathSumTemp(root.right);
        }
        if (tempLeft > 0 || tempRight > 0) {
            maxPath += Math.max(tempLeft, tempRight);
            maxPathX = Math.max(maxPathX, root.val + tempLeft + tempRight);
            maxPathX = Math.max(maxPathX, root.val + tempLeft);
            maxPathX = Math.max(maxPathX, root.val + tempRight);
        }

        maxPathX = Math.max(maxPathX, maxPath);

        return maxPath;
    }
}
