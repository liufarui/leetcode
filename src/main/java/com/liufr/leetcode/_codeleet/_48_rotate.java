package com.liufr.leetcode._codeleet;

/**
 * @author lfr
 * @date 2020/8/5 11:18
 *
 * 48. 旋转图像
 *
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * 将图像顺时针旋转 90 度。
 * 说明：
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 *
 * 解题思路：
 * 思路很简单，就是从矩阵最外圈开始转，一直转到内圈；
 * 难点在于，这个算法太恶心了，要画好久才画的出来；
 * 需要注意：第二层循环，j是从i开始，到length - i（这里的长度指的是行数，比如size为5，length为4）
 *
 * 还有一种更简单的办法，先转置矩阵，然后将行反转。
 * 转置：将矩阵的行与列互换。
 */
public class _48_rotate {
    public void rotate(int[][] matrix) {
        int length = matrix.length - 1;
        int m = length >> 1;
        for (int i = 0; i <= m; i++) {
            for (int j = i; j < length - i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] =  matrix[length - j][i];
                matrix[length - j][i] = matrix[length - i][length - j];
                matrix[length - i][length - j] = matrix[j][length - i];
                matrix[j][length - i] = tmp;
            }
        }
    }
}
