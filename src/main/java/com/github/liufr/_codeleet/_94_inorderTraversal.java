package com.github.liufr._codeleet;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lfr
 * @date 2020/8/10 14:56
 *
 * 94. 二叉树的中序遍历
 *
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 解题思路：
 * 方法一：递归
 */
public class _94_inorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> retList = new ArrayList<>();
        if (root != null) {
            inorderTraversal(retList, root);
        }
        return retList;
    }

    public void inorderTraversal(List<Integer> retList, TreeNode root) {
        if (root.left != null) {
            inorderTraversal(retList, root.left);
        }
        retList.add(root.val);
        if (root.right != null) {
            inorderTraversal(retList, root.right);
        }
    }
}
