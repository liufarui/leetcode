package com.liufr.leetcode._codeleet;

import org.junit.Test;

/**
 * @author lfr
 * @date 2020/8/21 14:06
 *
 * 221. 最大正方形
 *
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 *
 * 解题思路：
 * 动态规划
 */
public class _221_maximalSquare {
    @Test
    void test() {
        System.out.println(maximalSquare(new char[][]{{'1'}}));
    }

    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }

        int[][] maximalSquare = new int[matrix.length][matrix[0].length];
        int ret = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '0') {
                    maximalSquare[i][j] = 0;
                } else if (maximalSquare[i][j] != 0) {
                    ret = Math.max(ret, maximalSquare[i][j]);
                } else {
                    ret = Math.max(ret, maximalSquare(maximalSquare, matrix, i, j));
                }
            }
        }

        return ret;
    }

    public int maximalSquare(int[][] maximalSquare, char[][] matrix, int x, int y) {
        if (matrix[x][y] == '0') {
            return 0;
        }
        if (maximalSquare[x][y] != 0) {
            return maximalSquare[x][y];
        }

        int side = 1;
        while (x + side < matrix.length && y + side < matrix[0].length && matrix[x + side][y] != '0' && matrix[x][y + side] != '0') {
            side++;
        }
        if (side == 1) {
            return 1;
        }

        int inside = (int) Math.sqrt(maximalSquare(maximalSquare, matrix, x + 1, y + 1));
        side = Math.min(side, inside + 1);
        maximalSquare[x][y] = side * side;
        return maximalSquare[x][y];
    }
}
