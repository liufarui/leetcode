//给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
//
//示例：
//
//输入：
//A: [1,2,3,2,1]
//B: [3,2,1,4,7]
//输出：3
//解释：
//长度最长的公共子数组是 [3, 2, 1] 。
//
//提示：
//
//1 <= len(A), len(B) <= 1000
//0 <= A[i], B[i] < 100
package com.liufr.leetcode._codeleet;

public class findLength {
    public int findLength(int[] A, int[] B) {
        int sizeA = A.length;
        int sizeB = B.length;
        int max = 0;
        int[][] AB = new int[sizeA+1][sizeB+1];
        AB[sizeA-1][sizeB-1] = AB[sizeA-1][sizeB] = AB[sizeA][sizeB-1] = 0;

        for(int i=sizeA-1; i>=0; i--) {
            for(int j=sizeB-1; j>=0; j--) {
                AB[i][j] = A[i] == B[j] ? AB[i+1][j+1] + 1 : 0;
                max = Math.max(AB[i][j], max);
            }
        }

        return max;
    }
}
