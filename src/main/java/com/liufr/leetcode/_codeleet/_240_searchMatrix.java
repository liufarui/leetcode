package com.liufr.leetcode._codeleet;

import org.junit.Test;

/**
 * @author lfr
 * @date 2020/8/25 19:45
 *
 * 240. 搜索二维矩阵 II
 *
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 *
 * 解题思路：
 * 不断缩小遍历范围。
 */
public class _240_searchMatrix {
    @Test
    public void test() {
        searchMatrix(new int[][]{{-1, 3}}, 3);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int length = matrix.length;
        int height = matrix[0].length;

        int X = 0;
        while (X < length && matrix[X][0] <= target) {
            X++;
        }
        int Y = 0;
        while (Y < height && matrix[0][Y] <= target) {
            Y++;
        }
        int M = 0;
        while (M < length && M < height && matrix[M][M] < target) {
            M++;
        }
        int N=M;
        while (M < length && N < height && matrix[M][N] < target) {
            M++;
        }
        while (M < length && N < height && matrix[M][N] < target) {
            N++;
        }

        if (M != 0) {
            M--;
        }
        if (N != 0) {
            N--;
        }

        for (int i = M; i < X; i++) {
            for (int j = N; j < Y; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        for (int i = 0; i < M; i++) {
            for (int j = N; j < Y; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        for (int i = M; i < X; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }

        return false;
    }
}
