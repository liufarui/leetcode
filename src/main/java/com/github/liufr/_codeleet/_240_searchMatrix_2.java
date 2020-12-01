package com.github.liufr._codeleet;

/**
 * @author lfr
 * @date 2020/8/25 20:36
 *
 * 解题思路：
 * 从左下角开始，如果小，则右移，如果大，则上移，如果等于，则返回。
 */
public class _240_searchMatrix_2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int X = 0;
        int Y = matrix[0].length - 1;
        while (X < matrix.length && Y > -1) {
            if (matrix[X][Y] == target) {
                return true;
            } else if (matrix[X][Y] > target) {
                Y--;
            } else {
                X++;
            }
        }
        return false;
    }
}
