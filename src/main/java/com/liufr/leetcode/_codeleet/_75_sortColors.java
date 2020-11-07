package com.liufr.leetcode._codeleet;

import java.util.Arrays;

/**
 * @author lfr
 * @date 2020/8/8 7:10 下午
 *
 * 75. 颜色分类
 *
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 解题思路：
 * 没有想到什么特别好的办法，就是两个指针，一个从左往右移动，一个从右往左移动；
 * 这两个指针分别代表0和2的边界；
 * 然后还有一个遍历指针，用来遍历数组中的0和2；
 * 如果遍历到了，则和边界指针的值进行互换。
 */
public class _75_sortColors {
    public static void main(String[] args) {
//        sortColors(new int[]{1, 2, 1, 2, 0, 0, 0, 2, 1, 0, 1, 2});
        sortColors(new int[]{2, 0, 2, 1, 1, 0});
    }

    public static void sortColors(int[] nums) {
        int left = moveLeft(nums, 0);
        int right = moveRight(nums, nums.length - 1);

        int point = left;
        while (point <= right) {
            if (nums[point] == 0) {
                nums[point] = nums[left];
                nums[left] = 0;
                point = left = moveLeft(nums, left);
            } else if (nums[point] == 2) {
                nums[point] = nums[right];
                nums[right] = 2;
                right = moveRight(nums, right);
            } else {
                point++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    private static int moveLeft(int[] nums, int p) {
        while (p < nums.length && nums[p] == 0) {
            p++;
        }
        return p;
    }

    private static int moveRight(int[] nums, int p) {
        while (p > -1 && nums[p] == 2) {
            p--;
        }
        return p;
    }
}
