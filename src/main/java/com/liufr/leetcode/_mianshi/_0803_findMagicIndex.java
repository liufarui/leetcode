package com.liufr.leetcode._mianshi;

/**
 * @author lfr
 * @date 2020/7/31 10:16
 * 
 * 面试题 08.03. 魔术索引
 * 
 * 魔术索引。
 * 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。
 * 给定一个有序整数数组，编写一种方法找出魔术索引，若有的话，在数组A中找出一个魔术索引，如果没有，则返回-1。
 * 若有多个魔术索引，返回索引值最小的一个。
 * 
 * 解题思路：
 * 遍历时间复杂度是O(n)，但是执行结果是0m，100%。
 * 可以很容易想到二分法，但是因为本题元素可以重复，所以正常的二分法是不行的。
 * 本题用了一种变相的二分法：
 * 由于题目的要求是找到最小的满足条件的元素，所以我们使用递归，将每一段分成两段，去找左边的满足条件的点，
 * 因为如果左边找到了，右边就不需要继续找了。
 */
public class _0803_findMagicIndex {
    public static void main(String[] args) {
        int[] aaa = {0, 2, 3, 4, 5};
        findMagicIndex(aaa);
    }

    public static int findMagicIndex(int[] nums) {
        return magicIndex(nums, 0, nums.length - 1);
    }

    public static int magicIndex(int[] nums, int start, int end) {
        if (start < 0 || end >= nums.length) {
            return -1;
        }
        if (start == end) {
            if (nums[start] == start) {
                return start;
            }
            return -1;
        }
        int mid = (start + end) >> 1;
        int left = magicIndex(nums, start, mid);
        if (left != -1) {
            return left;
        }
        return magicIndex(nums, mid + 1, end);
    }
}
