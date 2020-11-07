package com.liufr.leetcode._codeleet;

/**
 * @author lfr
 * @date 2020/8/30 5:09 下午
 *
 * 309. 最佳买卖股票时机含冷冻期
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 *
 * 解题思路：
 * 1 ms  99.59%
 * 动态规划；
 * f0表示当天持有股票的最大收益（不包含股票本身的价值）
 * f1表示当天将股票卖出，所得的最大收益
 * f2表示当天之前将股票卖出，所得的最大收益
 * 新的一天，f0等于前一天的f0和（f2-当天股票价格）的最大值；
 * f1等于f0加上当前股票价格；
 * f2等于前一天的f1和f2的最大值。
 */
public class _309_maxProfit {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }

        int f0 = -prices[0];
        int f1 = 0;
        int f2 = 0;
        for (int price : prices) {
            int new_f0 = Math.max(f0, f2 - price);
            int new_f1 = f0 + price;
            int new_f2 = Math.max(f1, f2);
            f0 = new_f0;
            f1 = new_f1;
            f2 = new_f2;
        }
        return Math.max(f1, f2);
    }
}
