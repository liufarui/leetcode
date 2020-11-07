package com.liufr.leetcode._codeleet;

import java.util.List;

/**
 * @author lfr
 * @date 2020/8/1 11:12
 *
 * 你有 k 个升序排列的整数数组。
 * 找到一个最小区间，使得 k 个列表中的每个列表至少有一个数包含在其中。
 *
 * 我们定义如果 b-a < d-c 或者在 b-a == d-c 时 a < c，则区间 [a,b] 比 [c,d] 小。
 */
public class _XXXX632_smallestRange {
    public int[] smallestRange(List<List<Integer>> nums) {
        int left = Integer.MIN_VALUE >> 1;
        int right = Integer.MAX_VALUE >> 1;
        int diff = right - left;

        for (List<Integer> list : nums) {
            for (Integer num : list) {
                left = num;
            }
        }
        return new int[2];
    }
}
