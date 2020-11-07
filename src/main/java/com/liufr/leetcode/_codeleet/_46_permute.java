package com.liufr.leetcode._codeleet;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lfr
 * @date 2020/8/5 9:35
 *
 * 46. 全排列
 *
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 解题思路：
 * 递归；
 * 遍历所有的元素，然后递归；
 * 将当前元素设置为Integer.MAX_VALUE，我们假定这个元素永远不会出现在数组中；
 * 循环体中如果出现了Integer.MAX_VALUE，则直接continue；
 * 遍历完成后，如果返回的列表为空，则新建一个只有当前元素的列表；
 * 遍历完成后，如果返回的列表不为空，则将返回的列表都加上自己返回。
 * 其实，还有一种思路，就是新建一个数组，专门保存哪些数字被使用了，哪些数字尚未使用，用空间换取时间。
 */
public class _46_permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> retList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == Integer.MAX_VALUE) {
                continue;
            }

            int[] tempNums = nums.clone();
            tempNums[i] = Integer.MAX_VALUE;
            List<List<Integer>> list = permute(tempNums);
            if(list.size() == 0) {
                List<Integer> l = new ArrayList<>();
                l.add(nums[i]);
                retList.add(l);
            }
            for(List<Integer> l:list) {
                l.add(nums[i]);
                retList.add(l);
            }
        }
        return retList;
    }
}
