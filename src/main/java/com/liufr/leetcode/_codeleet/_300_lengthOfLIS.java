package com.liufr.leetcode._codeleet;

import org.junit.Test;

/**
 * @author lfr
 * @date 2020/8/28 15:21
 *
 * 300. 最长上升子序列
 *
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 解题思路：
 * 14 ms 57.67%
 * 动态规划；
 * 记录一个数组，记录以当前数字为结尾的时候最长的升序长度。
 */
public class _300_lengthOfLIS {
    @Test
    public void test() {
        System.out.println(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] lengthOfLIS = new int[nums.length];
        int max = 1;
        lengthOfLIS[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            lengthOfLIS[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    lengthOfLIS[i] = Math.max(lengthOfLIS[i], lengthOfLIS[j] + 1);
                }
            }
            max = Math.max(max, lengthOfLIS[i]);
        }

        return max;
    }
}
