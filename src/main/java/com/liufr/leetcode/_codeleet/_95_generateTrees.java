package com.liufr.leetcode._codeleet;

import java.util.LinkedList;
import java.util.List;

/**
 * @author lfr
 * @date 2020/7/21 10:51
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 *
 * 解题思路：
 * 分治法，基础思维是：
 * 让每一个节点都做一次根节点，因为二分查找树是有序的，所以每个节点左边和右边的数字集合都是确定的；
 * 在这种情况下，分别对左子树和右子树进行讨论，递归上一步的思想；
 *
 * 当开始的节点比结束的节点大的时候，说明这个时候此子树（可能是左，可能是右）没有数字集合了，只能为空；
 * 当开始的节点和结束的节点相等的时候，说明这个时候此子树（可能是左，可能是右）只有一个数字，那么就只能是这个节点，
 * 当然这个节点的左子节点和右子节点都为空，故不需要打印。
 */
public class _95_generateTrees {
    public List<TreeNode> generateTrees(int n) {
        /* 边界值 */
        if (n == 0) {
            return new LinkedList<TreeNode>();
        }

        /* 枚举所有的根节点 */
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> retList = new LinkedList<TreeNode>();

        /* 如果开始大于结束，直接返回null，只有这一种情况
        * 如果开始等于结束的话，只有一个节点，直接返回这个节点的指针，同样也是只有这一种情况（不论此节点是左子节点还是右子节点） */
        if (start > end) {
            retList.add(null);
            return retList;
        } else if (start == end) {
            retList.add(new TreeNode(start));
            return retList;
        }

        /* 遍历所有的根节点 */
        for (int i = start; i <= end; i++) {

            /* 递归找出所有的左子树集合和右子树集合 */
            List<TreeNode> leftList = generateTrees(start, i - 1);
            List<TreeNode> rightList = generateTrees(i + 1, end);

            /* 对于所有的左子树和右子树集合，将其做笛卡尔乘积；
            * 将每一条链表中的头指针（在此也就是左右子树的根节点），作为现在根节点的左右子节点 */
            for (TreeNode left : leftList) {
                for (TreeNode right : rightList) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    retList.add(node);
                }
            }
        }
        return retList;
    }
}
