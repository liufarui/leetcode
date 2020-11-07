package com.liufr.leetcode._codeleet;

import org.junit.Test;

/**
 * @author lfr
 * @date 2020/8/28 20:04
 *
 * 解题思路：
 * 0 ms 100.00% 37.5 MB 84.10%等长数组优化方案
 * 通过一个等长数组，优化上一种算法，利用空间换取时间；
 * 其实时间复杂度依旧是n*n
 */
public class _300_lengthOfLIS_3 {
    @Test
    public void test() {
        System.out.println(lengthOfLIS(new int[]{4, 10, 4, 3, 8, 9}));
    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int[] list = new int[nums.length];
        list[0] = nums[0];
        int tail = 1;

        for (int num : nums) {
            if (num > list[tail - 1]) {
                list[tail++] = num;
                continue;
            }
            for (int i = 0; i < tail; i++) {
                if (num <= list[i]) {
                    list[i] = num;
                    break;
                }
            }
        }
        return tail;
    }
}
