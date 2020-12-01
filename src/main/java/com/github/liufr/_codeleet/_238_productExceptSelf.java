package com.github.liufr._codeleet;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author lfr
 * @date 2020/8/24 14:42
 *
 * 238. 除自身以外数组的乘积
 *
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，
 * 其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 *
 * 请不要使用除法
 *
 * 解题思路：
 * 引入左乘积和右乘积，最后遍历数组，将左乘积乘以右乘积，得到当前索引的值
 * */
public class _238_productExceptSelf {
    @Test
    public void test() {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
    }

    public int[] productExceptSelf(int[] nums) {
        int size = nums.length;
        int[] productL = new int[size];
        int[] productR = new int[size];
        int[] ret = new int[size];
        productL[0] = nums[0];
        productR[size - 1] = nums[size - 1];
        for (int i = 1; i < size; i++) {
            productL[i] = productL[i - 1] * nums[i];
        }
        for (int i = size - 2; i > -1; i--) {
            productR[i] = productR[i + 1] * nums[i];
        }

        ret[0] = productR[1];
        ret[size - 1] = productL[size - 2];
        for (int i = 1; i < size - 1; i++) {
            ret[i] = productL[i - 1] * productR[i + 1];
        }

        return ret;
    }
}
