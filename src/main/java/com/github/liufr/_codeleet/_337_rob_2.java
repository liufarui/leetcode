package com.github.liufr._codeleet;

import java.util.HashMap;

/**
 * @author lfr
 * @date 2020/8/31 17:26
 *
 * 4 ms 42.77%
 */
public class _337_rob_2 {
    HashMap<TreeNode, Integer> NC_map = new HashMap<TreeNode, Integer>();
    HashMap<TreeNode, Integer> C_map = new HashMap<TreeNode, Integer>();

    public int rob(TreeNode root) {
        return Math.max(robC(root), robNC(root));
    }

    public int robC(TreeNode node) {
        if (node == null) {
            return 0;
        } else if (node.left == null && node.right == null) {
            return node.val;
        } else if (C_map.containsKey(node)) {
            return C_map.get(node);
        }

        int robC = robNC(node.left) + robNC(node.right) + node.val;
        C_map.put(node, robC);
        return robC;
    }

    public int robNC(TreeNode node) {
        if (node == null) {
            return 0;
        } else if (node.left == null && node.right == null) {
            return 0;
        } else if (NC_map.containsKey(node)) {
            return NC_map.get(node);
        }

        int robNC = Math.max(robC(node.left) + robC(node.right), robNC(node.left) + robC(node.right));
        robNC = Math.max(robNC, robC(node.left) + robNC(node.right));
        robNC = Math.max(robNC, robNC(node.left) + robNC(node.right));
        NC_map.put(node, robNC);

        return robNC;
    }
}
