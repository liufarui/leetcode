package com.liufr.leetcode._codeleet;

import java.util.HashMap;

/**
 * @author lfr
 * @date 2020/8/12 10:39
 *
 * 105. 从前序与中序遍历序列构造二叉树
 *
 * 解决思路：
 * 使用递归的思想，遍历中序序列；
 * 然后根据前序序列判断左右子树的位置；
 * 使用空间换时间，因为树中，字符不会相同，所以在寻找前序序列位置时，用map替代遍历整个数组的方式
 * 代码如下：
 */
public class _105_buildTree {
    private int[] pre;
    private int preS = 0;
    private final HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        pre = preorder;
        preS = 0;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTree(0, preorder.length - 1);
    }

    private TreeNode buildTree(int inS, int inE) {
        TreeNode node = new TreeNode(pre[preS]);
        if (inS == inE) {
            return node;
        }
        int inAddr = map.get(pre[preS]);

        if (inAddr > inS) {
            preS++;
            node.left = buildTree(inS, inAddr - 1);
        }
        if (inAddr < inE) {
            preS++;
            node.right = buildTree(inAddr + 1, inE);
        }
        return node;
    }
}
