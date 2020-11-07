package com.liufr.leetcode._codeleet;

/**
 * @author lfr
 * @date 2020/7/27 10:31
 * 
 * 21. 合并两个有序链表
 * 
 * 将两个升序链表合并为一个新的 升序 链表并返回。
 * 新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 解题思路：
 * 很简单的链表拼接，不写思路了。
 */
public class _21_mergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(1);
        ListNode head = l;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                l.next = l2;
                break;
            } else if (l2 == null) {
                l.next = l1;
                break;
            }
            if (l1.val < l2.val) {
                l.next = l1;
                l1 = l1.next;
            } else {
                l.next = l2;
                l2 = l2.next;
            }
            l = l.next;
        }
        return head.next;
    }
}
