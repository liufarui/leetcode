package com.liufr.leetcode._codeleet;

/**
 * @author lfr
 * @date 2020/8/18 13:30
 *
 * 200. 岛屿数量
 *
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 * 解题思路：
 * 遍历所有节点：
 * 当发现节点为1的时候，结果加一，然后将其所有的“周围”节点设置为0；
 * 然后将周围节点的周围节点设置为0.
 */
public class _200_numIslands {
    public int numIslands(char[][] grid) {
        int ret = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    ret++;
                    check(grid, i, j);
                }
            }
        }
        return ret;
    }

    private void check(char[][] grid, int i, int j) {
        grid[i][j] = '0';
        if (i + 1 < grid.length && grid[i + 1][j] == '1') {
            check(grid, i + 1, j);
        }
        if (i - 1 > -1 && grid[i - 1][j] == '1') {
            check(grid, i - 1, j);
        }
        if (j + 1 < grid[0].length && grid[i][j + 1] == '1') {
            check(grid, i, j + 1);
        }
        if (j - 1 > -1 && grid[i][j - 1] == '1') {
            check(grid, i, j - 1);
        }
    }
}
