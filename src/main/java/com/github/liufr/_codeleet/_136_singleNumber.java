package com.github.liufr._codeleet;

/**
 * @author lfr
 * @date 2020/7/29 14:28
 * 
 * 136. 只出现一次的数字
 * 
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 解题思路：
 * 按位异或。
 */
public class _136_singleNumber {
    public int singleNumber(int[] nums) {
        int ret=0;
        for (int num : nums) {
            ret = ret ^ num;
        }
        return ret;
    }
}
