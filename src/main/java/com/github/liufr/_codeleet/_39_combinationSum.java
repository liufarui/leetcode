package com.github.liufr._codeleet;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lfr
 * @date 2020/8/4 22:39
 *
 * 39. 组合总和
 *
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 * 说明：
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 * 
 * 解题思路：
 * 递归；
 * 从数组第一个元素开始，计算和target的差值，如果大于0；则将target置为差值递归查找；
 * 如果等于0，则说明这条分支满足条件，将自己算进list，返回；
 * 如果小于0，则说明这条分支不满足条件，返回；
 * 
 * 但是此时还有一定的问题，就是2-2-3和3-2-2算成了两条不同的路，所以我们需要去重：
 * 由于数组本身是有序的，所以我们每次设置一个开始的坐标，然后依次向后计算，这样最后输出的列表也是有序的，就不存在重复的问题了。
 * 这个开始的坐标是当前计算的数字的下标。
 */
public class _39_combinationSum {
    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        return combinationSum(candidates, target, 0);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target, int start) {
        List<List<Integer>> retList = new ArrayList<List<Integer>>();
        for (int i = start; i < candidates.length; i++) {
            List<Integer> list;
            int X = target - candidates[i];
            if (X == 0) {
                list = new ArrayList<Integer>();
                list.add(candidates[i]);
                retList.add(list);
            } else if (X > 0) {
                List<List<Integer>> tempList = combinationSum(candidates, X, i);
                for (List<Integer> l : tempList) {
                    l.add(candidates[i]);
                    retList.add(l);
                }
            }
        }
        return retList;
    }
}
