package com.github.liufr._codeleet;

public class findKthLargest {
    public int findKthLargest(int[] nums, int k) {
        fastFind(nums, 0, nums.length - 1, k-1);
        return nums[k];
    }

    public static void main(String[] args) {
        int targetNumb = 9;
//        int[] nums = {-1, 3, 3, 7, 9, 10, 10, 14, 14, 56, 8, 0, 49, 2, 3, 6};
        int[] nums = {-1, 2, 0};

        fastFind(nums, 0, nums.length - 1, 0);

//        for (int x=0; x<nums.length; x++) {
//            System.out.println(nums[x]);
//        }
        System.out.println(nums[0]);

    }

    public static void fastFind(int[] nums, int start, int end, int k) {

        int low = start;
        int high = end;

        int standData = nums[start];
        while (low < high) {
            while (low < high && nums[high] <= standData) {
                high--;
            }
            while (low < high && nums[low] >= standData) {
                low++;
            }
            int temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;
        }
        nums[start] = nums[low];
        nums[low] = standData;
        if(low == k) {
            return;
        }

        if(low - 1 >= k && k >= start) {
            fastFind(nums, start, low - 1, k);
        } else if (high + 1 <= k && k <= end) {
            fastFind(nums, high + 1, end, k);
        }
    }
}
