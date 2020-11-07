package com.liufr.leetcode._codeleet;

/**
 * @author lfr
 * @date 2020/7/24 21:31
 *
 * 44. 通配符匹配
 *
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 *
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * 两个字符串完全匹配才算匹配成功。
 * 说明:
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
 *
 * 解题思路：
 * 此题逻辑难度比较高，适合二刷。
 * 之前刷过一次，使用了一种非常复杂的递归方法，在本地跑是可以跑过的，但是leetcode里面一直是超时；
 * 二刷的时候，使用了动态规划的思维方式：
 * 			0	1	2	3	4
 *          X	a	b	c	e	b
 *      X	T
 * 0	*	T	T	T	T	T	T
 * 1	c				T
 * 2	*				T	T	T
 * 3	e					T
 * 4	*					T	T
 * 5	b						T
 *
 * 如上图：
 * 列代表通配符字符串，行代表被匹配字符串。
 * 创建一个[m+1][n+1]大小的二位数组
 * [i][j]的值代表p取前i个字符串，s取前j个字符串是否满足要求
 * 很明显，[0][0]的时候（两个字符串长度都为0），结果是正确的，我们设置为true
 *
 * 然后我们依次遍历：
 * 如果p为"*"，则从上一行的第一个数据开始数到第一个为true的数据，然后从这个数据正下方的那个数据开始，一直到行末，都置为true；
 *
 * 如果p为"?"或者p和s相等，则此位置[i+1][j+1]的数据和[i][j]的保持一致，因为如果[i][j]为true，说明p取前i个字符串，s取前j个字符串，是可以满足要求的
 * 在这种情况下，p为"?"或者p和s相等，则[i+1][j+1]也是可以满足要求的。
 *
 * 最后返回右下角的值即可。
 */
public class _44_isMatch {
    public static void main(String[] args) {
        System.out.println(isMatch("", "*"));
        System.out.println(isMatch("a", "a*"));
        System.out.println(isMatch("abceb", "*c*e*b"));
        System.out.println(isMatch("\"abbabbbaabaaabbbbbabbabbabbbabbaaabbbababbabaaabbab", "*aabb***aa**a******aa*"));
    }


    public static boolean isMatch(String s, String p) {
        char[] s_char = s.toCharArray();
        /* 进行预处理，将连续的'*'替换为单个的'*',
        因为效果是一样的， 这样可以简易算法 */
        char[] p_char = prepare(p);

        /* boolean类型的数组默认为false */
        boolean[][] ret = new boolean[p_char.length + 1][s_char.length + 1];

        /* 设置第一个值 */
        ret[0][0] = true;

        for (int i = 0; i < p_char.length; i++) {
            /* 如果p的值为 '*' ，则寻找上一行第一个为true的值，
            * 然后从这个值的正下方开始，后面的值全部设置为true */
            if (p_char[i] == '*') {
                boolean start = false;
                for (int j = 0; j < s_char.length + 1; j++) {
                    if (start) {
                        ret[i + 1][j] = true;
                    } else if (ret[i][j]) {
                        start = true;
                        ret[i + 1][j] = true;
                    }
                }
                continue;
            }

            /* 如果满足相等要求，则将此值与左上角的值设置相等 */
            for (int j = 0; j < s_char.length; j++) {
                if (p_char[i] == s_char[j] || p_char[i] == '?') {
                    ret[i + 1][j + 1] = ret[i][j];
                }
            }
        }

        return ret[p_char.length][s_char.length];
    }

    public static char[] prepare(String p) {
        char[] p_char = p.toCharArray();

        if (p_char.length == 0) {
            return p_char;
        }

        StringBuilder sb = new StringBuilder();
        char pre = p_char[0];
        sb.append(pre);

        for (int i = 1; i < p_char.length; i++) {
            if (pre != '*' || p_char[i] != '*') {
                sb.append(p_char[i]);
                pre = p_char[i];
            }
        }
        return sb.toString().toCharArray();
    }
}
