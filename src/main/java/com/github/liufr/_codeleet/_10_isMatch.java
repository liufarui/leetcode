package com.github.liufr._codeleet;

/**
 * @author lfr
 * @date 2020/7/24 22:08
 * 
 * 10. 正则表达式匹配
 * 
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * 
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * 
 * 说明:
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 
 * 解题思路：
 * 其实这道题呢，和44题是很像的，但是呢，因为需要回溯，所以相对更复杂了一些。
 * 核心思想和44题一样，都是动态规划，使用dp将所有的字串都遍历完成，直到结束。
 * 但是要做好每一步不同条件的构思，以及边界条件的判断。
 * 
 * 如果节点是'.'或者普通字符是比较简单的，只需要考虑是否满足条件即可。
 * 但是如果是'*'，则需要回溯。
 * 如果上一个节点是普通字符，则回溯到上两行，然后判断后面是否有匹配的字符，因为*可以是0的意思。
 * 如果上一个字符是'.'，则回溯到上两行，记录第一个产生true的列，然后从这列开始（包含此列），以后的值全为true。
 * 整体来讲比较复杂，难点在于情况比较多，需要多debug去查漏补缺，详细思路见代码。
 */
public class _10_isMatch {
    public static void main(String[] args) {
        System.out.println(isMatch("aab", "c*a*b"));
        System.out.println(isMatch("mississippi", "mis*is*p*."));
        System.out.println(isMatch("ab", ".*"));
        System.out.println(isMatch("a", "a*"));
        System.out.println(isMatch("abceb", "c*e*b"));
        System.out.println(isMatch("abbabbbaabaaabbbbbabbabbabbbabbaaabbbababbabaaabbab", "a*aabb*aa*a*aa*"));
    }

    public static boolean isMatch(String s, String p) {
        char[] s_char = s.toCharArray();
        char[] p_char = p.toCharArray();

        /* boolean类型的数组默认为false */
        boolean[][] ret = new boolean[p_char.length + 1][s_char.length + 1];

        /* 设置第一个值 */
        ret[0][0] = true;

        for (int i = 0; i < p_char.length; i++) {
            /* 首先考虑字符为'*'的情况 */
            if (p_char[i] == '*') {
                /* 如果上一个字符为'.' */
                if (p_char[i - 1] == '.') {
                    /* 考虑上两行的情况，从第一个为true的值开始，后面的值都设置为true
                     * 这里为什么不从上一行开始考虑呢？是因为从上一行开始考虑的话有可能会漏掉一个值
                     * 因为上一个字符为'.'，此时必须要有一个值与之匹配，但是后面如果有'*'的话，是不需要的，有没有都可以 */
                    boolean start = false;
                    for (int j = 0; j < s_char.length + 1; j++) {
                        if (start) {
                            ret[i + 1][j] = true;
                        } else if (ret[i - 1][j]) {
                            start = true;
                            j--;
                        }
                    }
                } else {
                    /* 如果上一个字符是普通字符 */
                    for (int j = 0; j < s_char.length + 1; j++) {
                        /* 如果上两行位置是匹配的，或者上一行位置是匹配的，当前位置均匹配 */
                        if (ret[i - 1][j] || ret[i][j]) {
                            ret[i + 1][j] = true;
                        }

                        /* 首先设置好临界值，避免溢出
                         * 如果左上角是匹配的，而且'*'前的那个正则值（p_char[i - 1]）又和当前字符串值相等，则将当前位置设置为true */
                        if (j < s_char.length && ret[i][j] && p_char[i - 1] == s_char[j]) {
                            ret[i + 1][j + 1] = true;
                        }
                    }
                }
            }

            /* 如果满足相等要求，则将此值与左上角的值设置相等 */
            for (int j = 0; j < s_char.length; j++) {
                if (p_char[i] == s_char[j] || p_char[i] == '.') {
                    ret[i + 1][j + 1] = ret[i][j];
                }
            }
        }

        return ret[p_char.length][s_char.length];
    }
}
