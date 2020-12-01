package com.github.liufr._codeleet;

/**
 * @author lfr
 * @date 2020/8/24 15:15
 *
 * 解题思路：
 * 先将索引左边的乘积算出来，然后从右边开始算的时候，借用一个product记录右边当前的乘积，然后和左边的乘积相乘。
 */
public class _238_productExceptSelf_2 {
    public int[] productExceptSelf(int[] nums) {
        int size = nums.length;
        int[] ret = new int[size];

        ret[0] = ret[size - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            ret[i] = ret[i - 1] * nums[i - 1];
        }
        int product = nums[size - 1];
        for (int i = nums.length - 2; i > -1; i--) {
            ret[i] = product * ret[i];
            product *= nums[i];
        }

        return ret;
    }
}
