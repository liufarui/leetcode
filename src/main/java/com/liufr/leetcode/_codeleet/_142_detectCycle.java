package com.liufr.leetcode._codeleet;

import java.util.HashSet;

/**
 * @author lfr
 * @date 2020/8/16 17:09
 *
 * 142. 环形链表 II
 *
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。
 * 说明：不允许修改给定的链表。
 *
 * 解题思路：
 * 先判断是否为循环列表，然后使用set将所有的环内的节点记录下来，最后再从头开始寻找。
 * 时间复杂度O（n），非最优解。
 */
public class _142_detectCycle {
    public ListNode detectCycle(ListNode head) {
        ListNode cycNode = hasCycle(head);
        if (cycNode == null) {
            return null;
        }

        ListNode start = cycNode;
        HashSet<ListNode> set = new HashSet<ListNode>();

        do {
            set.add(start);
            start = start.next;
        } while (start != cycNode);

        start = head;
        while (!set.contains(start)) {
            start = start.next;
        }
        return start;
    }

    public ListNode hasCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode node1 = head.next;
        ListNode node2 = head;
        while (node1 != null && node1.next != null && node1 != node2) {
            node1 = node1.next.next;
            node2 = node2.next;
        }

        if (node1 == node2) {
            return node1;
        }
        return null;
    }
}
