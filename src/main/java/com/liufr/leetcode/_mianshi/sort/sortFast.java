package com.liufr.leetcode._mianshi.sort;

public class sortFast {
    public static void fastSort(int[] nums, int start, int end) {
        int low = start;
        int high = end;
        if (low >= high) {
            return;
        }

        int standData = nums[start];
        while (low < high) {
            while (low < high && nums[high] >= standData) {
                high--;
            }
            while (low < high && nums[low] <= standData) {
                low++;
            }
//            此时nums[low]比standData大，而nums[high]比standData小。
//            极端情况是nums[low]和nums[high]是同一条数据。
            int temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;
        }
//        由于先移动的是high节点，所以nums[high]/nums[low]一定比standData小。
//        极端情况是这俩为同一条数据。
        nums[start] = nums[low];
        nums[low] = standData;

        if(low - 1 > start) {
            fastSort(nums, start, low - 1);
        }
        if(high + 1 < end) {
            fastSort(nums, high + 1, end);
        }
    }
}
