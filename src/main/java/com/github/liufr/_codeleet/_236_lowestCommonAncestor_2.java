package com.github.liufr._codeleet;

/**
 * @author lfr
 * @date 2020/8/24 13:55
 */
public class _236_lowestCommonAncestor_2 {
    TreeNode parent = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findRoute(root, p, q);
        return parent;
    }

    private boolean findRoute(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean find1 = findRoute(root.left, p, q);
        boolean find2 = findRoute(root.right, p, q);

        /* 后半个判断条件是处理两个节点，其中一个是另外一个节点的祖先节点的情况 */
        if (find1 && find2 || ((root == p || root == q) && (find1 || find2))) {
            parent = root;
            return true;
        }

        return root == p || root == q || find1 || find2;
    }
}
