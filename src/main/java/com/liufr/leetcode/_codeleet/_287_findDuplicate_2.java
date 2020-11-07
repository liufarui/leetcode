package com.liufr.leetcode._codeleet;

/**
 * @author lfr
 * @date 2020/8/26 15:30
 *
 * 解题思路：
 * 假设这个数组是一个链表，下标代表自己，数值代表next；
 * 有一个数字重复，那么说明此链表有且只有一个环。
 * 我们按照之前的_142_detectCycle_3里面的解法，去寻找环的入口即可。
 */
public class _287_findDuplicate_2 {
    public int findDuplicate(int[] nums) {
        int X1 = 0;
        int X2 = 0;
        do {
            X1 = nums[X1];
            X2 = nums[nums[X2]];
        } while (X1 != X2);
        X1=0;
        do {
            X1 = nums[X1];
            X2 = nums[X2];
        } while (X1 != X2);
        return X1;
    }
}
