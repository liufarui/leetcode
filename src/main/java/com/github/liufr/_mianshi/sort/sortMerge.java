package com.github.liufr._mianshi.sort;

public class sortMerge {
    public static void main(String[] args) {
        int[] nums = {-1, 3, 3, 7, 9, 10, 10, 14, 14, 56, 8, 0, 49, 2, 3, 6};
//        int[] nums = {-1, 2, 0};

        mergeSort(nums);

        for (int x=0; x<nums.length; x++) {
            System.out.println(nums[x]);
        }
    }

    public static void mergeSort(int[] arr) {
        int len = arr.length;
        int[] result = new int[len];
        merge(arr, result, 0, len - 1);
    }

    public static void merge(int[] arr, int[] result, int start, int end) {
        if (start >= end) {
            return;
        }
        int len = end - start;
        int mid = (len >> 1) + start;
        int start1 = start, end1 = mid;
        int start2 = mid + 1, end2 = end;
        merge(arr, result, start1, end1);
        merge(arr, result, start2, end2);
        int k = start;
        while (start1 <= end1 && start2 <= end2) {
            result[k++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
        }
        while (start1 <= end1){
            result[k++] = arr[start1++];
        }
        while (start2 <= end2){
            result[k++] = arr[start2++];
        }
        for (int i = start; i <= end; i++) {
            arr[i] = result[i];
        }
    }
}
