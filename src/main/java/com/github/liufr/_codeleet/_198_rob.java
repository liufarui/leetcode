package com.github.liufr._codeleet;

/**
 * @author lfr
 * @date 2020/8/18 11:28
 *
 * 198. 打家劫舍
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋。
 * 每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 * 解题思路：
 * 斐波那契函数变式（动态规划思想）
 */
public class _198_rob {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        int[] X = new int[nums.length];
        X[0] = nums[0];
        X[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            X[i] = Math.max(X[i - 2] + nums[i], X[i - 1]);
        }
        return X[nums.length - 1];
    }
}
