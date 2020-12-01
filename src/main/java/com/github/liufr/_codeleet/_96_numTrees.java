package com.github.liufr._codeleet;
/**
 * @author lfr
 * @date 2020/7/15 17:08
 * 96. 不同的二叉搜索树
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 *
 * 解题思路：
 * 卡特兰数公式
 * 首先初始化节点只有0和1个的情况；
 * 然后通过动态规划思维：
 * 2个节点的时候，可以如此计算：
 * X[0]*X[1] + X[1]*X[0]
 * 总有一个节点是根节点，所以其实可能性的总和就等于左边的可能性数乘以右边的可能性数。
 * 同理3个节点的时候：
 * X[0]*X[2] + X[1]*X[1] + X[2]*X[0]
 */

public class _96_numTrees {
    public static int numTrees(int n) {
        int[] X = new int[n + 1];
        X[0] = X[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                // X[j]是根节点左侧的节点数目，X[i - j - 1]是根节点右侧的节点数目（左侧右侧都有可能为0）
                X[i] += X[j] * X[i - j - 1];
            }
        }
        return X[n];
    }

    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }
}
