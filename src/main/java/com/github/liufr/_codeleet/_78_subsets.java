package com.github.liufr._codeleet;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lfr
 * @date 2020/8/8 10:23 下午
 *
 * 78. 子集
 *
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 *
 * 解题思路：
 * 暴力解法，递归
 */
public class _78_subsets {
    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 3, 4}));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> retList = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            retList.addAll(subsets(nums, i));
        }

        retList.add(new ArrayList<>());
        return retList;
    }

    public static List<List<Integer>> subsets(int[] nums, int start) {
        List<List<Integer>> retList = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        l.add(nums[start]);
        retList.add(l);

        for (int i = start + 1; i < nums.length; i++) {
            List<List<Integer>> list = subsets(nums, i);
            for (List<Integer> a : list) {
                a.add(nums[start]);
            }
            retList.addAll(list);
        }

        return retList;
    }
}
