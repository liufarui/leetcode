//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
package com.liufr.leetcode._codeleet;

import java.util.HashSet;

public class lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<Character>();

        int longest = 0;
        int right;
        int left = 0;
        int n = s.length();

        for (right=0; right<n; right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt( left++ ));
            }

            set.add(s.charAt(right));
            longest = Math.max(longest, right - left + 1);
        }

        return longest;
    }
}
