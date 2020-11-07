package com.liufr.leetcode._codeleet;

/**
 * @author lfr
 * @date 2020/8/31 16:46
 *
 * 337. 打家劫舍 III
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。
 * 这个地区只有一个入口，我们称之为“根”。
 * 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。
 * 一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
 * 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 *
 * 1030 ms 6.68%
 */
public class _337_rob {
    public int rob(TreeNode root) {
        return Math.max(robC(root), robNC(root));
    }

    public int robC(TreeNode node) {
        if (node == null) {
            return 0;
        } else if (node.left == null && node.right == null) {
            return node.val;
        }

        return robNC(node.left) + robNC(node.right) + node.val;
    }

    public int robNC(TreeNode node) {
        if (node == null) {
            return 0;
        } else if (node.left == null && node.right == null) {
            return 0;
        }

        int robCL = robC(node.left);
        int robCR = robC(node.right);
        int robNCL = robNC(node.left);
        int robNCR = robNC(node.right);

        int robNC = Math.max(robCL + robCR, robNCL + robCR);
        robNC = Math.max(robNC, robCL + robNCR);
        robNC = Math.max(robNC, robNCL + robNCR);
        return robNC;
    }
}
