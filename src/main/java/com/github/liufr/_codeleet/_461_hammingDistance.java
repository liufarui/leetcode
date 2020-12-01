package com.github.liufr._codeleet;

/**
 * @author lfr
 * @date 2020/8/30 7:40 下午
 *
 * 461. 汉明距离
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 *
 * 解题思路：
 * 0 ms  100.00% 异或
 */
public class _461_hammingDistance {
    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        int ret = 0;
        while (z != 0) {
            if (z % 2 == 1) {
                ret++;
            }
            z = z / 2;
        }
        return ret;
    }
}
