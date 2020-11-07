package com.liufr.leetcode._codeleet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author lfr
 * @date 2020/8/11 10:21
 *
 * 102. 二叉树的层序遍历
 *
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 解题思路：
 * 递归遍历，新建一个map或者数组（由于map的key是连续的，所以两者时间复杂度应该差不多）去记录深度，以及每个深度的List头
 * 通过维护一个深度值，将同深度的节点值保存在同一个list中
 * 递归天然具有有序性
 */
public class _102_levelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> retList = new ArrayList<List<Integer>>();
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

        if (root == null) {
            return retList;
        }
        levelOrder(root, map, 0);

        Integer depth=0;
        while (map.containsKey(depth)) {
            retList.add(map.get(depth++));
        }

        return retList;
    }

    void levelOrder(TreeNode node, HashMap<Integer, List<Integer>> map, int depth) {
        if (map.containsKey(depth)) {
            map.get(depth).add(node.val);
        } else {
            List<Integer> list = new ArrayList<Integer>();
            list.add(node.val);
            map.put(depth, list);
        }

        if (node.left != null) {
            levelOrder(node.left, map, depth + 1);
        }
        if (node.right != null) {
            levelOrder(node.right, map, depth + 1);
        }
    }
}
