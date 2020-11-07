package com.liufr.leetcode._codeleet;

/**
 * @author lfr
 * @date 2020/8/19 13:42
 *
 * 广度优先，终于过了。
 */
public class _207_canFinish_3 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegrees = new int[numCourses];
        boolean[] finished = new boolean[numCourses];

        boolean[][] checks = new boolean[numCourses][numCourses];
        for (int[] prerequisite : prerequisites) {
            inDegrees[prerequisite[0]]++;
            checks[prerequisite[0]][prerequisite[1]] = true;
        }

        boolean operate = true;
        int sum = numCourses;
        while (operate && sum != 0) {
            operate = false;
            for (int i = 0; i < inDegrees.length; i++) {
                if (finished[i]) {
                    continue;
                }
                if (inDegrees[i] == 0) {
                    operate = true;
                    sum--;
                    finished[i] = true;
                    for (int j = 0; j < checks.length; j++) {
                        if (checks[j][i]) {
                            checks[j][i] = false;
                            inDegrees[j]--;
                        }
                    }
                }
            }
        }

        return sum == 0;
    }
}
