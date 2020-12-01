package com.github.liufr._codeleet;

/**
 * @author lfr
 * @date 2020/8/18 9:54
 *
 * 152. 乘积最大子数组
 *
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 * 解题思路：
 * 记录一个最小值，记录一个最大值；
 * 如果遇到负数，需要将最小值和最大值互换位置，然后再乘以当前value。
 */
public class _152_maxProduct {
    public int maxProduct(int[] nums) {
        int maxProduct = Integer.MIN_VALUE;
        int iMax = 1;
        int iMin = 1;
        for (int num : nums) {
            if (num < 0) {
                int temp = iMax;
                iMax = iMin;
                iMin = temp;
            }

            iMax = Math.max(iMax * num, num);
            iMin = Math.min(iMin * num, num);
            maxProduct = Math.max(maxProduct, iMax);
        }
        return maxProduct;
    }
}
