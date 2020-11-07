package com.liufr.leetcode._codeleet;

/**
 * @author lfr
 * @date 2020/8/4 9:27
 *
 * 33. 搜索旋转排序数组
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 你可以假设数组中不存在重复的元素。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 联想：153，154
 *
 * 解题思路：
 * 二分查找，不过有一点需要注意：
 * 二分查找的时候，只有一边是有序的，所以需要分类讨论，有序的那边正常二分查找，不完整有序的那边递归查找。
 */
public class _33_search {
    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    public int search(int[] nums, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) >> 1;
        if (nums[left] <= nums[mid]) {
            /* 二分查找 */
            if (target <= nums[mid] && target >= nums[left]) {
                int ret = binarySearch(nums, target, left, mid);
                if (ret > -1) {
                    return ret;
                }
            }
        } else {
            /* 递归查找 */
            int ret = Math.max(search(nums, target, left, mid), search(nums, target, mid + 1, right));
            if (ret > -1) {
                return ret;
            }
        }

        if (nums[right] >= nums[mid]) {
            /* 二分查找 */
            if (target >= nums[mid] && target <= nums[right]) {
                int ret = binarySearch(nums, target, mid, right);
                if (ret > -1) {
                    return ret;
                }
            }
        } else {
            int ret = Math.max(search(nums, target, left, mid), search(nums, target, mid + 1, right));
            if (ret > -1) {
                return ret;
            }
        }

        return -1;
    }

    public int binarySearch(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
