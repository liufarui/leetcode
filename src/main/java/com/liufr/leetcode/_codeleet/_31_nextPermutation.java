package com.liufr.leetcode._codeleet;

/**
 * @author lfr
 * @date 2020/8/3 15:14
 * left
 * 31. 下一个排列
 * left
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * left
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * left
 * 必须原地修改，只允许使用额外常数空间。
 * left
 * 解题思路：
 * 方法很土，首先定义两个点，right和left：
 * left指的是，从后往前找，第一个不符合升序的数（也就是第一个满足后面的数可能比前面的数大的情况的数）
 * right指的是，从后往前找，第一个比left大的数（也就是比left大的最小的数）
 * 然后将left和right交换位置
 * 然后将left后面的数重新进行排序
 * 主要难点在于，理解下一个排列题意
 */
public class _31_nextPermutation {
    public void nextPermutation(int[] nums) {
        int end = nums.length - 1;
        int left = -1;
        int right = -1;
        for (int i = end; i > 0; i--) {
            /* 找到第一个不满足升序的数 */
            if (nums[i - 1] < nums[i]) {
                left = i - 1;
                break;
            }
        }

        /* 没找到left，说明数组满足从后往前升序，本身就是最大的排列
         * 我们直接将数组反转为最小的排列 */
        if (left == -1) {
            for (int i = 0; i <= end / 2; i++) {
                swap(i, end - i, nums);
            }
        } else {
            /* 寻找right
             * 就是第一个比left大的数的下标 */
            for (int i = end; i >= 0; i--) {
                if (nums[i] > nums[left]) {
                    right = i;
                    break;
                }
            }
            /* 交换 */
            swap(left, right, nums);
            /* 将left后面的数字重新排序，使其满足从后到前升序 */
            for (int i = left + 1; i <= end; i++) {
                for (int j = i + 1; j <= end; j++) {
                    if (nums[i] > nums[j]) {
                        swap(i, j, nums);
                    }
                }
            }
        }
    }

    public void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
