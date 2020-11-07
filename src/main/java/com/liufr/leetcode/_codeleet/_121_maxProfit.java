package com.liufr.leetcode._codeleet;

/**
 * @author lfr
 * @date 2020/8/14 16:19
 *
 * 121. 买卖股票的最佳时机
 *
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 * 注意：你不能在买入股票前卖出股票。
 *
 * 解题思路：
 * 纯数学思维：
 * 两个记录分别记录最低点和最高点；
 * 找到最低点的时候，重置最高点也为最低点的值（避免先卖后买）；
 * 当新值大于最高值的时候，重置最高值并计算最大收益。
 */
public class _121_maxProfit {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int pre = prices[0];
        int post = prices[0];
        int maxProfit = 0;

        for (int price : prices) {
            if (price < pre) {
                pre = price;
                post = price;
            }
            if (price > post) {
                post = price;
                maxProfit = Math.max(maxProfit, post - pre);
            }
        }

        return maxProfit;
    }
}
