package com.liufr.leetcode._codeleet;

import org.junit.Test;

/**
 * @author lfr
 * @date 2020/8/25 20:47
 *
 * 279. 完全平方数
 *
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。
 * 你需要让组成和的完全平方数的个数最少。
 *
 * 解题思路：
 * 动态规划；
 * 从dp[0]=0开始，遍历所有的平方值：
 * dp[i] = Math.min(dp[i], dp[i - sq[s]] + 1);
 */
public class _279_numSquares {
    @Test
    public void test() {
        System.out.println(numSquares(12));
    }

    public int numSquares(int n) {
        int[] sq = new int[(int) Math.sqrt(n) + 1];
        for (int i = 2; i < sq.length; i++) {
            sq[i] = i * i;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            int s = 2;
            dp[i] = dp[i - 1] + 1;
            while (s < sq.length && sq[s] <= i) {
                dp[i] = Math.min(dp[i], dp[i - sq[s]] + 1);
                s++;
            }
        }
        return dp[n];
    }
}
