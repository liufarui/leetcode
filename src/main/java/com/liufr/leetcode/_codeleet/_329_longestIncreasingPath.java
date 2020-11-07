package com.liufr.leetcode._codeleet;

/**
 * @author lfr
 * @date 2020/7/26 12:30
 *
 * 329. 矩阵中的最长递增路径
 *
 * 给定一个整数矩阵，找出最长递增路径的长度。
 *
 * 对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。
 *
 * 解题思路：
 * 随便想了一个法子，写着玩了玩，竟然就通过了，也是很惊讶。
 * 首先介绍一下最朴素的做法，就是遍历所有的节点，找到从这个节点出发的最长路径长度：
 * 节点只能向上下左右四个方向移动，所以我们需要比较[i + 1][j]，[i][j + 1]， [i - 1][j]，[i][j - 1]这四个节点是否满足要求
 * 如果满足要求，则递归满足要求的节点出发的最长路径，然后1，就是结果；
 * 例子：
 * 如果i + 1 ,j满足要求，则：
 * maxRoute(i, j) = maxRoute(i + 1, j) + 1
 * 注意：实际代码编写中，要注意边界条件的判定。
 *
 * 然后提交上去后发现，执行结果没有问题，但是最后的几个测试例超时了，
 * 所以就想了个办法去解决超时的问题：
 * 我们在比较的同时维护一张stg表，记录从每个节点开始的最大路径长度，这样，就避免了很多重复计算，详细请见代码注释
 */
public class _329_longestIncreasingPath {
    public static void main(String[] args) {
        int[][] X = {{1, 2}};
        System.out.println(longestIncreasingPath(X));
    }

    public static int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n;
        if (m == 0) {
            return 0;
        } else {
            n = matrix[0].length;
        }
        int max_route = 1;

        int[][] stg = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                /* 遍历每个节点的最大路径长度，记录最大路径 */
                max_route = Math.max(max_route, getMaxRoute(i, j, m, n, matrix, stg));
            }
        }
        return max_route;
    }

    public static int getMaxRoute(int i, int j, int m, int n, int[][] matrix, int[][] stg) {
        int route = 1;
        /* 如果此节点已经记录了最大路径，则直接返回 */
        if (stg[i][j] > 0) {
            return stg[i][j];
        }

        int value = matrix[i][j];

        /* 如果此值比右边的值小,则从此值出发，到右边节点的最大路径长度等于右边节点的最大路径长度 + 1
         * 要注意，有可能这个节点本来就是最右边的节点，所以边界值要考虑在内
         * 后面三个条件同理
         * */
        if (i + 1 < m && value < matrix[i + 1][j]) {
            int tmpRoute = getMaxRoute(i + 1, j, m, n, matrix, stg);
            route = Math.max(route, tmpRoute + 1);
        }
        if (j + 1 < n && value < matrix[i][j + 1]) {
            int tmpRoute = getMaxRoute(i, j + 1, m, n, matrix, stg);
            route = Math.max(route, tmpRoute + 1);
        }
        if (i - 1 >= 0 && value < matrix[i - 1][j]) {
            int tmpRoute = getMaxRoute(i - 1, j, m, n, matrix, stg);
            route = Math.max(route, tmpRoute + 1);
        }
        if (j - 1 >= 0 && value < matrix[i][j - 1]) {
            int tmpRoute = getMaxRoute(i, j - 1, m, n, matrix, stg);
            route = Math.max(route, tmpRoute + 1);
        }
        /* 记录当前节点的最大路径长度 */
        stg[i][j] = route;
        return route;
    }
}
