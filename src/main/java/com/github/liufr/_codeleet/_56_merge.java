package com.github.liufr._codeleet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author lfr
 * @date 2020/8/7 9:33
 *
 * 56. 合并区间
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 解题思路：
 * 先排序，后聚合。
 */
public class _56_merge {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        List<int[]> tmp = new ArrayList<>();
        int index = 0;
        if (intervals.length > 0) {
            tmp.add(intervals[0]);
        } else {
            return new int[0][];
        }

        for (int[] x : intervals) {
            if (x[0] <= tmp.get(index)[1]) {
                tmp.get(index)[1] = Math.max(x[1], tmp.get(index)[1]);
            } else {
                tmp.add(x);
                index++;
            }
        }
        return tmp.toArray(new int[index + 1][]);
    }
}
