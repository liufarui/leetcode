package com.liufr.leetcode._codeleet;

/**
 * @author lfr
 * @date 2020/8/14 16:33
 *
 * 141. 环形链表
 *
 * 给定一个链表，判断链表中是否有环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。
 */
public class _141_hasCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode node1 = head.next;
        ListNode node2 = head;
        while (node1 != null && node1.next != null && node1 != node2) {
            node1 = node1.next.next;
            node2 = node2.next;
        }

        return node1 == node2;
    }
}
