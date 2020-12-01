package com.github.liufr._codeleet;

/**
 * @author lfr
 * @date 2020/7/27 9:07
 *
 * 392. 判断子序列
 *
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *
 * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
 *
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
 * （例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 * 解题思路：
 * 其实本解题方法挺没意思的，就是从头遍历，如果有匹配下标都加一，如果没匹配长串加一。
 * 最后判断短串下标是否到末尾就可以了。
 * 不过扩展挺有意思的。
 */
public class _392_isSubsequence {
    public boolean isSubsequence(String s, String t) {
        char[] sTL = s.toCharArray();
        char[] tTL = t.toCharArray();
        int sF = 0;
        int tF = 0;
        while (sF < sTL.length && tF < tTL.length) {
            if (sTL[sF] == tTL[tF]) {
                sF++;
            }
            tF++;
        }
        return tF == (tTL.length + 1);
    }
}
