package com.liufr.leetcode._codeleet;

/**
 * @author lfr
 * @date 2020/7/31 14:33
 *
 * 70. 爬楼梯
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 解题思路：
 * 斐波那契；
 * 楼梯一共有n个，我们可以爬到（n-2）这个楼梯上，然后跨两步上去；
 * 也可以爬（n-1）这个楼梯上，然后跨一步上去。
 */
public class _70_climbStairs {
    public int climbStairs(int n) {
        int[] stairs = new int[n + 1];
        stairs[0] = 1;
        stairs[1] = 2;
        for (int i = 3; i <= n; i++) {
            stairs[i] = stairs[i - 1] + stairs[i - 2];
        }
        return stairs[n - 1];
    }
}
