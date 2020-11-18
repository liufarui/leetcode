package com.liufr.leetcode._codeleet;

import org.junit.Test;

/**
 * @author lfr
 * @date 2020/11/18 20:39
 *
 * 437. 路径总和 III
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 * 找出路径和等于给定数值的路径总数。
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 *
 * 执行用时：23 ms, 在所有 Java 提交中击败了69.20%的用户
 * 内存消耗：38.4 MB, 在所有 Java 提交中击败了77.63%的用户
 *
 * 解题思路：
 * 分类递归计算
 * 首先递归计算从每个节点开始向下寻找，满足条件的路径总数
 * 当从某一个节点向下寻找的时候，继续向下寻找满足条件的（sum-当前值）的个数
 * 当sum等于当前节点的值的时候，增加1.
 */


public class _437_pathSum {
    public int pathSum(TreeNode root, int sum) {
        /* 如果根节点为空，则直接返回0 */
        if (root == null) {
            return 0;
        }
        int num = 0;
        /* 如果当前节点等于和，说明仅仅当前节点便满足条件，总数+1 */
        if (sum == root.val) {
            num++;
        }
        if (root.left != null) {
            /* 计算以左子树作为起点，满足条件的路径个数 */
            num += pathSum(root.left, sum);
            /* 计算以当前节点作为起点，路径向左发散的满足条件的路径个数 */
            num += pathSubSum(root.left, sum - root.val);
        }
        if (root.right != null) {
            /* 计算以右子树作为起点，满足条件的路径个数 */
            num += pathSum(root.right, sum);
            /* 计算以当前节点作为起点，路径向右发散的满足条件的路径个数 */
            num += pathSubSum(root.right, sum - root.val);
        }
        return num;
    }

    public int pathSubSum(TreeNode root, int sum) {
        int num = 0;
        /* 如果当前节点和sum相同，说明到此节点为止，满足条件，num+1 */
        if (root.val == sum) {
            num++;
        }
        if (root.left != null) {
            /* 继续向左下寻找 */
            num += pathSubSum(root.left, sum - root.val);
        }
        if (root.right != null) {
            /* 继续向右下寻找 */
            num += pathSubSum(root.right, sum - root.val);
        }
        return num;
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);
        root.right = new TreeNode(-3);
        root.right.right = new TreeNode(11);
        System.out.println(pathSum(root, 8));
    }
}
