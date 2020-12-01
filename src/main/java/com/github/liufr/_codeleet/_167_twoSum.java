package com.github.liufr._codeleet;

/**
 * @author lfr
 * @date 2020/7/20 13:29
 * 167. 两数之和 II - 输入有序数组
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 */
public class _167_twoSum {
    public int[] twoSum(int[] numbers, int target) {
        int end = numbers.length - 1;
        int start = 0;
        while (start < end) {
            int temp = numbers[start] + numbers[end];
            if (temp == target) {
                return new int[]{start + 1, end + 1};
            } else if (temp < target) {
                start++;
            } else {
                end--;
            }
        }
        return null;
    }
}
