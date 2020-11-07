package com.liufr.leetcode._codeleet;

/**
 * @author lfr
 * @date 2020/7/20 13:53
 * LCP 12. 小张刷题计划
 * 为了提高自己的代码能力，小张制定了 LeetCode 刷题计划，他选中了 LeetCode 题库中的 n 道题，编号从 0 到 n-1，
 * 并计划在 m 天内按照题目编号顺序刷完所有的题目（注意，小张不能用多天完成同一题）。
 * 在小张刷题计划中，小张需要用 time[i] 的时间完成编号 i 的题目。此外，小张还可以使用场外求助功能，
 * 通过询问他的好朋友小杨题目的解法，可以省去该题的做题时间。为了防止“小张刷题计划”变成“小杨刷题计划”，小张每天最多使用一次求助。
 * 我们定义 m 天中做题时间最多的一天耗时为 T（小杨完成的题目不计入做题总时间）。
 * 请你帮小张求出最小的 T是多少。
 */
public class _LCP12_minTime {
    public static void main(String[] args) {
        System.out.println(minTime(new int[]{1, 2, 3}, 2));
    }

    public static int minTime(int[] time, int m) {
        long right = 0, left = 0;
        int length = time.length;
        int maxNum = 0;

        for (int t : time) {
            maxNum = Math.max(maxNum, t);
            right += t;
        }
        right = right - maxNum;

        long ans = right;
        while (left < right) {
            int nowNum = 1;
            long nowSum = 0;
            long nowLargestSum = 0;

            long mid = (left + right) >> 1;

            int nowMaxNum = 0;
            int i;
            for (i = 0; i < length; i++) {
                if (nowSum + time[i] - Math.max(nowMaxNum, time[i]) <= mid) {
                    nowMaxNum = Math.max(nowMaxNum, time[i]);
                    nowSum += time[i];
                } else {
                    nowLargestSum = Math.max(nowLargestSum, nowSum - nowMaxNum);
                    nowMaxNum = time[i];
                    nowSum = time[i];
                    nowNum++;
                }
            }

            if (nowNum <= m) {
                nowLargestSum = Math.max(nowLargestSum, nowSum - nowMaxNum);
                ans = Math.min(ans, nowLargestSum);
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return (int) ans;
    }
}
