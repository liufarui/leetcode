package com.liufr.leetcode._codeleet;

/**
 * @author lfr
 * @date 2020/7/29 10:32
 *
 * 11. 盛最多水的容器
 *
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 * 解题思路：
 * 很经典的双指针问题；
 * 标记两个指针，一个指向头，一个指向尾；
 * 计算完当前容积后，移动两个指针高度低的那个指针；（因为移动高度低的指针，容积才有可能变大，深度是由小的高度确定的）
 * 然后循环。
 *
 * 本算法可优化，通过两个数值记录上一次计算容积的时候的指针高度；
 * 如果某指针移动后，高度降低，那么，容积肯定会减少，所以，直接将此指针移动即可，减少了计算次数。
 */
public class _11_maxArea {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int mArea = 0;
        int preS = 0;
        int preE = 0;

        while (start < end) {
            /* 如果某个指针移动之后，高度降低，那么继续移动，不做计算。 */
            if (height[start] < preS) {
                start++;
                continue;
            } else if (height[end] < preE) {
                end--;
                continue;
            }

            /* 计算容积 */
            mArea = Math.max(mArea, Math.min(height[start], height[end]) * (end - start));

            /* 记录当前指针的高度 */
            preS = height[start];
            preE = height[end];

            /* 移动高度比较低的那个指针 */
            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }
        return mArea;
    }
}
