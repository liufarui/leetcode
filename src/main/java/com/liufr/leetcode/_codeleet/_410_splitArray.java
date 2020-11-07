package com.liufr.leetcode._codeleet;

/**
 * @author lfr
 * @date 2020/7/20 14:17
 * 410. 分割数组的最大值
 * 给定一个非负整数数组和一个整数 m，你需要将这个数组分成 m 个非空的连续子数组。
 * 设计一个算法使得这 m 个子数组各自和的最大值最小。
 */
public class _410_splitArray {
    public static void main(String[] args) {
        int[] aaa = {1, 2, 3, 4, 5};
        System.out.println(splitArray(aaa, 1));
    }

    public static int splitArray(int[] nums, int m) {
        long right = 0;
        long left = 0;
        int length = nums.length;

        for (int num : nums) {
            right += num;
            left = Math.max(num, left);
        }

        long ans = right;

        while (left < right) {
            long mid = (left + right) >> 1;

            long nowSum = 0;
            int nowNum = 1;
            long nowLargestSum = 0;

            for (int i = 0; i < length; i++) {
                if (nowSum + nums[i] <= mid) {
                    nowSum += nums[i];
                } else {
                    nowLargestSum = Math.max(nowLargestSum, nowSum);
                    nowSum = nums[i];
                    nowNum++;
                }
            }

            if (nowNum <= m) {
                nowLargestSum = Math.max(nowLargestSum, nowSum);
                ans = Math.min(ans, nowLargestSum);
                right = ans;
            } else {
                left = mid + 1;
            }
        }

        return (int) ans;
    }
}
