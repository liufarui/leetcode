package com.github.liufr._codeleet;

/**
 * @author lfr
 * @date 2020/7/28 16:53
 *
 * 206. 反转链表
 *
 * 反转一个单链表。
 *
 * 解题思路：
 * 三个锚点，依次往后移动，每次让中间锚点的next指向前一个锚点
 */
public class _206_reverseList {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode A = head;
        ListNode B = head.next;
        ListNode C = head.next.next;
        head.next = null;
        while (C != null) {
            B.next = A;
            A = B;
            B = C;
            C = C.next;
        }
        B.next = A;
        return B;
    }
}
