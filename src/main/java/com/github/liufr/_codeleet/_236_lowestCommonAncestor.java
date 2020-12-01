package com.github.liufr._codeleet;

import java.util.Stack;

/**
 * @author lfr
 * @date 2020/8/24 11:29
 *
 * 236. 二叉树的最近公共祖先
 *
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 */
public class _236_lowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> pl = new Stack<TreeNode>();
        Stack<TreeNode> ql = new Stack<TreeNode>();
        findRoute(root, p, pl);
        findRoute(root, q, ql);

        TreeNode ret = null;
        while (!pl.empty() && !ql.empty() && pl.peek() == ql.peek()) {
            ret = pl.peek();
            pl.pop();
            ql.pop();
        }
        return ret;
    }

    private boolean findRoute(TreeNode root, TreeNode X, Stack<TreeNode> route) {
        if (root == null) {
            return false;
        }
        if (X == root) {
            route.push(root);
            return true;
        }

        if (findRoute(root.left, X, route)) {
            route.push(root);
            return true;
        } else if (findRoute(root.right, X, route)) {
            route.push(root);
            return true;
        }
        return false;
    }
}
