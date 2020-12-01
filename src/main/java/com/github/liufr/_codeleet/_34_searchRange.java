package com.github.liufr._codeleet;

/**
 * @author lfr
 * @date 2020/8/4 10:09
 *
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 *
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 解题思路：
 * 二分查找；
 * 首先二分查找到第一个与target相同的元素；
 * 如果没有找到，直接返回；
 * 如果找到了，继续二分查找第一个处于临界位置的元素。
 */
public class _34_searchRange {
    public static void main(String[] args) {
        System.out.println(searchRange(new int[]{2, 2}, 2));
    }

    public static int[] searchRange(int[] nums, int target) {
        int T = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                T = mid;
                break;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (T == -1) {
            return new int[]{-1, -1};
        }

        int start = T;
        int end = T;
        left = 0;
        right = T;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid - 1] < target) {
                    start = mid;
                    break;
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        left = T;
        right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                if (mid == nums.length - 1 || nums[mid + 1] > target) {
                    end = mid;
                    break;
                }
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return new int[]{start, end};
    }
}
