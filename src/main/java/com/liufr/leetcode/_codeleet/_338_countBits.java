package com.liufr.leetcode._codeleet;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author lfr
 * @date 2020/9/1 16:01
 *
 * 338. 比特位计数
 * 给定一个非负整数 num。
 * 对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 *
 * 1 ms 99.80%
 * 每次从头开始加1，到当前位置循环结束；
 * 然后再次从头开始加1
 * 0
 * 0+1
 * 0+1 0+1+1
 * 0+1 0+1+1 0+1+1 0+1+1+1
 * 0+1 0+1+1 0+1+1 0+1+1+1 0+1+1 0+1+1+1 0+1+1+1 0+1+1+1+1
 */
public class _338_countBits {
    @Test
    public void test() {
        System.out.println(Arrays.toString(countBits(15)));
    }


    public int[] countBits(int num) {
        int[] count = new int[num + 1];
        count[0] = 0;
        int pre = 0;
        int x = 1;
        int temp = x;
        while (x <= num) {
            if (temp == pre) {
                temp = x;
                pre = 0;
            }
            count[x] = count[pre] + 1;
            x++;
            pre++;
        }

        return count;
    }
}
