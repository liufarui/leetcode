package com.liufr.leetcode._codeleet;

import org.junit.Test;

/**
 * @author lfr
 * @date 2020/8/28 20:04
 *
 * 解题思路：
 * 0 ms 100.00%
 * 将上一种方法继续优化，二分查找。
 */
public class _300_lengthOfLIS_4 {
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
            int left = 0;
            int right = tail - 1;
            while (left <= right) {
                int mid = (right + left) >> 1;
                if ((num <= list[mid] && mid == 0) || (num <= list[mid] && num > list[mid - 1])) {
                    list[mid] = num;
                    break;
                } else if (num > list[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return tail;
    }
}
