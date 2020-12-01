package com.github.liufr._codeleet;

import java.util.Arrays;
import java.util.List;

/**
 * @author lfr
 * @date 2020/8/14 10:33
 *
 * 139. 单词拆分
 *
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 * 解题思路：
 * 辣鸡智商，毁我青春！！！
 * 刚开始的时候使用的是堆的思想方法，通过一棵树去确认的是否存在，效率确实是高，但是在以下这种情况会出错：
 * 字典里面同时存在"a"和"abc"的情况，这样就极其容易忽略掉"a"；
 * 所以后来也只能使用动态规划：
 * 设置结果数组，然后将坐标为0的点设置为true；
 * 然后从第一个位置开始遍历，如果当前节点为false，直接拿下一次循环；
 * 如果当前位置为true，则将当前位置加上字典里面的单词，将下一个满足条件的位置设置为true；
 * 最后返回最后坐标的值。
 */
public class _139_wordBreak {
    public static void main(String[] args) {
        System.out.println(wordBreak("leetcode", Arrays.asList("leet", "code")));
        System.out.println(wordBreak("abcd", Arrays.asList("a", "abc", "b", "cd")));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        int size = s.length();
        boolean[] ret = new boolean[size + 1];
        ret[0] = true;
        for (int i = 1; i < size + 1; i++) {
            if (!ret[i - 1]) {
                continue;
            }
            for (String word : wordDict) {
                int start = i - 1;
                int end = i - 1 + word.length();
                if (end <= size && word.equals(s.substring(start, end))) {
                    ret[end] = true;
                }
            }
        }
        return ret[size];
    }
}
