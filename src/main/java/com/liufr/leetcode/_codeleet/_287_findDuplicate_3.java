package com.liufr.leetcode._codeleet;

/**
 * @author lfr
 * @date 2020/8/26 15:41
 *
 * 解题思路：
 * 这种思路有限制，只能重复一次。
 */
public class _287_findDuplicate_3 {
    public int findDuplicate(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int size = nums.length - 1;
        return sum - nums.length * (nums.length - 1) / 2;
    }
}
