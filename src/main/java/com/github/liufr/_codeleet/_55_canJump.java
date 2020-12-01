package com.github.liufr._codeleet;

/**
 * @author lfr
 * @date 2020/8/6 11:09
 *
 * 55. 跳跃游戏
 *
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 *
 * 解题思路：
 * 纯逻辑算法；
 * 从后往前算，对于每个坐标到末尾需要跳多少次；
 * 有一个needJump记录当前坐标需要跳多远才有可能到达末尾；
 * 如果当前坐标满足条件，可以跳到末尾，那么说明前面只要能跳到此坐标，就一定能到末尾，needJump置为0；
 * 最后看头部，如果等于1，说明可以成功。
 */
public class _55_canJump {
    public boolean canJump(int[] nums) {
        int needJump = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > needJump) {
                needJump = 0;
            }
            needJump++;
        }
        return needJump == 1;
    }
}
