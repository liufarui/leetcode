package com.github.liufr._codeleet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lfr
 * @date 2020/7/29 21:06
 * 
 * 15. 三数之和
 * 
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？\
 * 请你找出所有满足条件且不重复的三元组。
 * 
 * 注意：答案中不可以包含重复的三元组。
 * 
 * 解题思路：
 * 主要方法是使用双指针法。
 * 首先将数组排序，因为之前做过快速排序，所以这里直接用jdk自带的排序函数；
 * 然后从小到大，遍历每一个元素（不允许重复，因为题目要求，数组内的数字可能会重复，但是结果不允许重复，每个值只遍历一次）；
 * 从这个元素下一个位置开始，一直到末尾，寻找两个数的和等于当前元素的负值（取这个值的负值的原因是三个数相加为0，这样当前值的负值就是剩下两个数的和）；
 * 
 * 关于search方法，首先设定一个当前的记录值，也是考虑到结果不允许重复；
 * 然后使用双指针法，两个指针一个从头遍历，一个从尾部遍历；
 * 当两个值的和较（当前元素的负值）小的时候，start指针加1；
 * 当两个值的和较大的时候，end指针减1；
 * 当两个值的和正好和当前元素的负值相等的时候，list增加一条。
 * 详细见注释。
 */
public class _15_threeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        threeSum(nums);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> retList = new ArrayList<>();
        int end = nums.length - 1;
        /* 先排序 */
        Arrays.sort(nums);

        /* 遍历每一个不重复值 */
        for (int i = 0; i < end; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            search(-nums[i], i + 1, end, nums, retList);
        }
        return retList;
    }

    public static void search(int sum, int start, int end, int[] nums, List<List<Integer>> retList) {
        /* 记录上一次满足条件的两个值
         * 后文中如果这两个值没有发生变化将两个指针同时移动 */
        int x_start = Integer.MAX_VALUE;
        int x_end = Integer.MAX_VALUE;
        while (start < end) {
            int tempSum = nums[start] + nums[end];
            /* 根据和的值决定移动哪个指针 */
            if (tempSum > sum) {
                end--;
            } else if (tempSum < sum) {
                start++;
            } else {
                List<Integer> list = new ArrayList<>();

                /* 如果满足条件，List增加一条；
                 * 如果和上一次结果相同，同时移动两个指针 */
                if (x_start == nums[start] && x_end == nums[end]) {
                    start++;
                    end--;
                    continue;
                }
                x_start = nums[start];
                x_end = nums[end];
                list.add(-sum);
                list.add(x_start);
                list.add(x_end);
                retList.add(list);
                start++;
            }
        }
    }
}
