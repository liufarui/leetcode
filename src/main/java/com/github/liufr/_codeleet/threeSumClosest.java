//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
//找出 nums 中的三个整数，
//使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。

package com.github.liufr._codeleet;

import java.util.Arrays;

public class threeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int sum = nums[0] + nums[1] + nums[2];
        int dValue = Math.abs(target - sum);

        for(int i=0; i<n; i++) {
            int j = i+1;
            int k = n - 1;
            while (j < k) {
                int temp = nums[i] + nums[j] + nums[k];
                if(Math.abs(target - temp) < dValue) {
                    dValue = Math.abs(target - temp);
                    sum = temp;
                }
                if (temp == target) {
                    return temp;
                } else if(temp > target) {
                        k--;
                } else {
                    j++;
                }
            }
        }
            return sum;
    }
}
