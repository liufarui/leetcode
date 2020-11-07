package com.liufr.leetcode._codeleet;

/**
 * @author lfr
 * @date 2020/7/29 14:37
 *
 * 160. 相交链表
 * 编写一个程序，找到两个单链表相交的起始节点。
 *
 * 解题思路：
 * 双指针，一个从A出发，一个从B出发；
 * 当到达末尾的时候，A跳到B的头部，B跳到A的头部；
 * 两个指针则一定会在某个时刻同时到达相交节点；
 * 因为他们走过的路程一样长，都是A+B.
 */
public class _160_getIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA;
        ListNode B = headB;
        if (A == null || B == null) {
            return null;
        }

        while (A != B) {
            if (A == null) {
                A = headB;
                B = B.next;
                continue;
            }
            if (B == null) {
                B = headA;
                A = A.next;
                continue;
            }
            A = A.next;
            B = B.next;
        }
        return A;
    }
}
