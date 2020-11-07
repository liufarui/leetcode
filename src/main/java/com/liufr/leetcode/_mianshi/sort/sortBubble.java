package com.liufr.leetcode._mianshi.sort;

public class sortBubble {
    public static void main(String[] args) {
        int[] nums = {-1, 3, 3, 7, 9, 10, 10, 14, 14, 56, 8, 0, 49, 2, 3, 6};
//        int[] nums = {-1, 2, 0};

        bubbleSort(nums);

        for (int x=0; x<nums.length; x++) {
            System.out.println(nums[x]);
        }
    }
    public static void bubbleSort(int[] nums) {
        int size = nums.length;
        for (int i=0; i<size; i++) {
            for (int j=i; j<size; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }
}
