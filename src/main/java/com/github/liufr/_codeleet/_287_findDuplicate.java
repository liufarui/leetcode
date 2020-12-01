package com.github.liufr._codeleet;

import org.junit.Test;

/**
 * @author lfr
 * @date 2020/8/26 14:22
 *
 * 287. 寻找重复数
 *
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
 * 假设只有一个重复的整数，找出这个重复的数。
 *
 * 解题思路：
 * 二分法，遍历所有的数字，比之等/小则count++，如果count大于这个数字，说明比这个数字大的数字都只出现过一次。
 */
public class _287_findDuplicate {
    @Test
    public void test() {
        System.out.println(findDuplicate(new int[]{1, 3, 4, 2, 2}));
    }

    public int findDuplicate(int[] nums) {
        int start = 1;
        int end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) >> 1;
            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }
            if (count > mid) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return (start + end) >> 1;
    }
}
