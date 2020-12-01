package com.github.liufr._codeleet;

/**
 * @author lfr
 * @date 2020/8/16 18:51
 *
 * 解题思路：
 * 看图
 */
public class _142_detectCycle_3 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode node1 = head;
        ListNode node2 = head;
        do {
            node1 = node1.next.next;
            node2 = node2.next;
        } while (node1 != null && node1.next != null && node1 != node2);

        if (node1 != node2) {
            return null;
        }
        while (head != node1) {
            head = head.next;
            node1 = node1.next;
        }

        return node1;
    }
}
