package com.liufr.leetcode._mianshi.sort;

public class sortInsert {
    public static void main(String[] args) {
        int[] nums = {-1, 3, 3, 7, 9, 10, 10, 14, 14, 56, 8, 0, 49, 2, 3, 6};
//        int[] nums = {-1, 2, 0};

        sortInsert(nums);

        for (int x=0; x<nums.length; x++) {
            System.out.println(nums[x]);
        }
    }
    public static void sortInsert(int[] nums) {
        int size = nums.length;
        for (int i = 1; i<size; i++) {
            int temp = nums[i];
            int j=i-1;
            for (; j>=0; j--) {
                if (temp < nums[j]) {
                    nums[j+1] = nums[j];
                } else  {
                    break;
                }
            }
            nums[j+1] = temp;
        }
    }
}
