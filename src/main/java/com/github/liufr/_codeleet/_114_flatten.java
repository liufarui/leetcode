package com.github.liufr._codeleet;

/**
 * @author lfr
 * @date 2020/8/12 16:12
 *
 * 114. 二叉树展开为链表
 *
 * 给定一个二叉树，原地将它展开为一个单链表。
 *
 * 解题思路：
 * 花了三分钟就写完了，纪念一下；
 * 递归；
 * 如果根为空，则直接返回。
 * 如果根的左子树不为空，则递归flatten左子树（将左子树变成链表）；
 * 左子树全部变成链表之后，将左子节点替到右子节点，然后一直寻找原左子树的最后一个右子节点；
 * 寻找到之后，将最后一个节点的右子节点指向原来的根节点的右子节点，然后递归此右子节点。
 */
public class _114_flatten {
    public void flatten(TreeNode root) {
        if(root == null) {
            return;
        }
        if(root.left != null) {
            flatten(root.left);
        }
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = null;
        while (root.right != null) {
            root = root.right;
        }
        root.right = tmp;
        flatten(root.right);
    }
}
