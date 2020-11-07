package com.liufr.leetcode._codeleet;

/**
 * @author lfr
 * @date 2020/8/16 19:01
 *
 * 283. 移动零
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 解题思路：
 * 设置两个flag，一个一直往后读，一个写;
 * 如果读flag不等于零，两个flag全部++，将读flag的数字赋值给写flag的位置；
 * 如果读flag等于零，不做操作，读flag++；
 * 一直到读flag读到尾部；
 * 把write后面的数字都设置为0.
 */
public class _283_moveZeroes {
    public void moveZeroes(int[] nums) {
        int write = 0;
        int read = 0;
        while (read < nums.length) {
            if (nums[read] != 0) {
                nums[write++] = nums[read];
            }
            read++;
        }
        while (write < nums.length) {
            nums[write++] = 0;
        }
    }
}
