package com.github.liufr._codeleet;

/**
 * @author lfr
 * @date 2020/7/27 22:38
 * 
 * 53. 最大子序和
 * 
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 解题思路：
 * 首先考虑边界值，如果全为负值，则找出里面最大的值并返回。
 * 然后我们从头开始遍历，找到第一个非负值，从这个值开始向后加。
 * 每次记录最大值。
 * 当和小于0的时候，重新开始计数。
 *
 * 因为只有前面一半的和为正时，才会对后半段产生增益。
 */
public class _53_maxSubArray {
    public static void main(String[] args) {
        int[] aaa = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(aaa));
    }
    public static int maxSubArray(int[] nums) {
        int maxTotal = Integer.MIN_VALUE;
        int tempTotal = 0;
        /* 记录是否为正 */
        boolean flag = false;
        for (int num : nums) {
            if (!flag && num < 0) {
                /* 考虑全为负值的情况 */
                maxTotal = Math.max(maxTotal, num);
                continue;
            }

            flag = true;
            tempTotal += num;
            if (tempTotal < 0) {
                tempTotal = 0;
                flag = false;
            } else {
                maxTotal = Math.max(maxTotal, tempTotal);
            }
        }

        return maxTotal;
    }
}
