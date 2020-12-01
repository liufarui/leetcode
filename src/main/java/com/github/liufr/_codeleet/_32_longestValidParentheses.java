package com.github.liufr._codeleet;

import java.util.Stack;

/**
 * @author lfr
 * @date 2020/8/3 9:33
 * 
 * 32. 最长有效括号
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * 
 * 解题思路：
 * 栈；
 */
public class _32_longestValidParentheses {
    public int longestValidParentheses(String s) {
        char[] cs = s.toCharArray();
        int longest = 0;
        Stack<Integer> stack = new Stack<>();

        /* 记录初始位置 */
        stack.push(-1);
        for (int i = 0; i < cs.length; i++) {
            /* 如果元素为（，入栈并记录值 */
            if (cs[i] == '(') {
                stack.push(i);
            } else {
                /* 如果元素为），出栈 */
                stack.pop();
                if (stack.empty()) {
                    /* 如果栈为空，则将当前位置记录为初始位置
                     * 由于有初始栈底，所以栈为空则说明）多于（；
                     * 前面已然不满足有效字符串规则 */
                    stack.push(i);
                } else {
                    /* 如果栈不为空，则使用当前值减去栈顶的值
                     * 因为满足条件的字符串push和pop是成对存在的
                     * 当前字符减去栈顶则为符合条件的子字符串的长度 */
                    longest = Math.max(longest, i - stack.peek());
                }
            }
        }

        return longest;
    }
}
