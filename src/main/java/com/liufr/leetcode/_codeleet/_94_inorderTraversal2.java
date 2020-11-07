package com.liufr.leetcode._codeleet;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author lfr
 * @date 2020/8/10 15:17
 *
 * 解题思路：
 * 方法二：
 * 迭代
 */
public class _94_inorderTraversal2 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.right = node2;
        node2.left = node3;
        System.out.println(inorderTraversal(node1));
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> retList = new ArrayList<>();
        if (root == null) {
            return retList;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode tmp = root;
        while (tmp != null || !stack.empty()) {
            while (tmp != null) {
                stack.push(tmp);
                tmp = tmp.left;
            }
            tmp = stack.pop();
            retList.add(tmp.val);
            tmp = tmp.right;
        }

        return retList;
    }
}
