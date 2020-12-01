package com.github.liufr._codeleet;

import java.util.Stack;

/**
 * @author lfr
 * @date 2020/8/24 10:08
 *
 * 234. 回文链表
 *
 * 请判断一个链表是否为回文链表。
 */
public class _234_isPalindrome {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode mid = head;
        ListNode tail = head;
        Stack<Integer> stack = new Stack<Integer>();
        while (tail != null && tail.next != null) {
            stack.push(mid.val);
            mid = mid.next;
            tail = tail.next.next;
        }
        if (tail != null) {
            mid = mid.next;
        }
        while (mid != null && !stack.empty()) {
            if (mid.val != stack.pop()) {
                return false;
            }
            mid = mid.next;
        }
        return mid == null && stack.empty();
    }
}
