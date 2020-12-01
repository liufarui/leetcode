package com.github.liufr._codeleet;

/**
 * @author lfr
 * @date 2020/7/23 21:21
 *
 * 64. 最小路径和
 *
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 *
 * 解题思路：
 * 其实本方法非常朴素，就是从【0，0】个节点开始，计算每个节点到【0，0】的最短路径；
 * 先创建一个和grid等大的二维数组；
 * 然后【0，0】这个节点的数字和grid相同；
 * 然后将第一行和第一列的距离填写完成；
 * 然后每个节点到【0，0】的最短距离，其实就是它上面节点的最短距离和左边节点的最短距离的最小值，加上它自己本身。
 * 最后返回最后一个节点的值即可，复杂度为m * n。
 */
public class _64_minPathSum {
    public static void main(String[] args) {
        int[][] saa= {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(saa));
    }

    public static int minPathSum(int[][] grid) {
        int length = grid.length;
        int height = grid[0].length;

        int[][] ret = new int[length][height];

        // 先设置第一个节点
        ret[0][0] = grid[0][0];
        // 设置第一行
        for (int i = 1; i < length; i++) {
            ret[i][0] = ret[i - 1][0] + grid[i][0];
        }
        // 设置第一列
        for (int j = 1; j < height; j++) {
            ret[0][j] = ret[0][j - 1] + grid[0][j];
        }

        // 每个节点到【0，0】的最短距离，其实就是它上面节点的最短距离和左边节点的最短距离的最小值，加上它自己本身。
        for (int i = 1; i < length; i++) {
            for (int j = 1; j < height; j++) {
                ret[i][j] = Math.min(ret[i - 1][j], ret[i][j - 1]) + grid[i][j];
            }
        }

        return ret[length - 1][height - 1];
    }
}
