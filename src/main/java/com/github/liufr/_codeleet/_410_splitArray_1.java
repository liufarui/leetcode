package com.github.liufr._codeleet;

/**
 * @author lfr
 * @date 2020/7/25 22:23
 *
 * 410. 分割数组的最大值
 *
 * 给定一个非负整数数组和一个整数 m，你需要将这个数组分成 m 个非空的连续子数组。
 * 设计一个算法使得这 m 个子数组各自和的最大值最小。
 *
 * 解题思路：
 * 动态规划；
 * 也是二刷了，但是和原来的解法如出一辙
 * 主要是设置一个区间值；
 * 假设所求的结果是X，则这个X一定在数组最大值和总和值之间；
 * 则我们通过二分查找的方法，看是否满足条件；如果满足，则在左边继续找，如果不满足，则在右边继续找；
 * 需要满足的条件则为：
 * 以X为上限，将数组分成很多段，记录段数，最后查看这个段数是否小于等于所给的m。
 */
public class _410_splitArray_1 {
    public static void main(String[] args) {
//        int[] aaa = {7, 2, 5, 10, 8};
        int[] aaa = {1, 2, 3, 4, 5};
        System.out.println(splitArray(aaa, 1));
    }


    public static int splitArray(int[] nums, int m) {
        long left = 0;
        long right = 0;

        /* 初始化left和right */
        for (int num : nums) {
            right += num;
            left = Math.max(left, num);
        }
        long ret = right;

        while (left < right) {
            long total = (left + right) >> 1;
            long tmp_total = 0;
            long max_total = 0;
            /* 记录当前的段数 */
            int num = 1;
            for (int i = 0; i < nums.length; i++) {
                /* 比当前测试值低，则继续累加 */
                if ((nums[i] + tmp_total) <= total) {
                    tmp_total += nums[i];
                } else {
                    /* 比当前测试值高，则记录到最高值，然后将当前数组记录到临时总和里面 */
                    max_total = Math.max(max_total, tmp_total);
                    tmp_total = nums[i];
                    num++;
                }
            }
            /* 补充计算最后一次的总和 */
            max_total = Math.max(max_total, tmp_total);

            /* 如果满足，则在左边继续找，如果不满足，则在右边继续找； */
            if (num <= m) {
                ret = Math.min(ret, max_total);
                right = total;
            } else {
                left = total + 1;
            }
        }

        return (int) ret;
    }
}
