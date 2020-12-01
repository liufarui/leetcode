package com.github.liufr._codeoffer;

/**
 * @author lfr
 * @date 2020/7/22 11:09
 * 剑指 Offer 11. 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 *
 * 解题思路：
 * 从第一个元素进行循环，找到第一个元素位置X满足：
 * X比X+1要大
 * 说明X+1便是我们要找的元素。
 * 如果一直没有找到，则说明数组本身单调递增，直接返回第一个元素。
 * 说来很好玩，其实直接循环遍历所有的元素，找到最小元素其实复杂度反而是超过了所有的其他解法。
 * 有时候，朴素不一定是坏事。
 */
public class _11_minArray {
    public int minArray(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {
                return numbers[i + 1];
            }
        }
        return numbers[0];
    }
}
