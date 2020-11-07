package com.liufr.leetcode._codeleet;

/**
 * @author lfr
 * @date 2020/7/30 9:41
 *
 * 343. 整数拆分
 *
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。
 * 返回你可以获得的最大乘积。
 *
 * 解题思路：
 * 其实本题最好用的方法是通过数学思维，去寻求一个普适的公式，然后代码里面直接套用；
 * 但是参考了一下，发现数学解法求证过程比较繁琐，所以还是回到DP。
 * 我们遍历每一个数字，然后将其分为两部分j,i-j：
 * 第一部分为dp[j]，意思是之前求出来的j满足条件的最大乘积；
 * 第二部分（i-j）我们不做分割，直接相乘与第一部分相乘。
 * 但是这个就一定能求出最大值嘛？
 * 不一定，我们还漏掉了一个地方，就是j本身，是有可能比dp[j]要大的，在这种情况下，我们就不需要拆解j了，直接使用它本身即可。
 * 最后返回最后一个值。
 */
public class _343_integerBreak {
    public static void main(String[] args) {
        integerBreak(10);
    }

    public static int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            int temp_max = i - 1;
            for (int j = 1; j < i; j++) {
                /* Math.max(j, dp[j])：
                 * j本身，是有可能比dp[j]要大的 */
                /* i-j作为不再拆分的一部分，这样i-j的范围其实是1到i-1
                 * 就可以遍历到所有的情况了 */
                temp_max = Math.max(temp_max, Math.max(j, dp[j]) * (i - j));
            }
            dp[i] = temp_max;
        }
        return dp[n];
    }
}
