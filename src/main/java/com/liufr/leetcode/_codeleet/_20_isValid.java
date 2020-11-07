package com.liufr.leetcode._codeleet;

import java.util.Stack;

/**
 * @author lfr
 * @date 2020/7/26 15:35
 *
 * 20. 有效的括号
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 解题思路：
 * 很简单的入栈出栈操作，不做过多解释；
 * 需要注意的是，特殊字符才会进行入栈和出栈操作，出栈的时候要注意栈是否为空
 */
public class _20_isValid {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char c : chars) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' && stack.empty()) {
                return false;
            } else if (c == ')' && !('(' == stack.pop())) {
                return false;
            } else if (c == ']' && stack.empty()) {
                return false;
            } else if (c == ']' && !('[' == stack.pop())) {
                return false;
            } else if (c == '}' && stack.empty()) {
                return false;
            } else if (c == '}' && !('{' == stack.pop())) {
                return false;
            }
        }
        return stack.empty();
    }
}
