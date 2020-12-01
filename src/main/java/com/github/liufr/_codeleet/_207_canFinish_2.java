package com.github.liufr._codeleet;

import org.junit.Test;

/**
 * @author lfr
 * @date 2020/8/19 9:52
 *
 * 207. 课程表
 *
 * 你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
 * 在选修某些课程之前需要一些先修课程。
 * 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
 * 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
 */
public class _207_canFinish_2 {
    @Test
    public void test() {
//        System.out.println(canFinish(2, new int[][]{{1, 0}, {0, 1}}));
        System.out.println(canFinish(2, new int[][]{{1, 0}}));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[][] checks = new boolean[numCourses][numCourses];
        boolean[] finished = new boolean[numCourses];

        for (int[] prerequisite : prerequisites) {
            checks[prerequisite[0]][prerequisite[1]] = true;
        }

        for (int i = 0; i < checks.length; i++) {
            if (!finished[i]) {
                finish(i, checks, finished, new boolean[numCourses]);
            }
        }
        for (boolean f : finished) {
            if(!f) {
                return false;
            }
        }

        return true;
    }

    public boolean finish(int X, boolean[][] checks, boolean[] finish, boolean[] route) {
        if (finish[X]) {
            return true;
        }
        if (route[X]) {
            return false;
        } else {
            route[X] = true;
        }

        for (int i = 0; i < checks[X].length; i++) {
            if (checks[X][i] && !finish(i, checks, finish, route)) {
                return false;
            }
        }
        finish[X] = true;
        return true;
    }
}
