package com.liufr.leetcode._codeleet;

/**
 * @author lfr
 * @date 2020/8/31 16:01
 *
 * 322. 零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。
 * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 15 ms   68.45% 动态规划
 */
public class _322_coinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int coin : coins) {
                int x = i - coin;
                if (x >= 0 && dp[x] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[x] + 1);
                }
            }
        }

        return dp[amount] != Integer.MAX_VALUE ? dp[amount] : -1;
    }
}
