package com.liufr.leetcode._codeleet;

/**
 * @author lfr
 * @date 2020/7/27 13:24
 * 
 * 19. 删除链表的倒数第N个节点
 * 
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 
 * 解题思路：
 * 其实题目很简单：
 * 使用两个指针，初始化都是头指针，第一个指针向后移动n次，然后两个指针同时向后移动；
 * 当第二个指针到最后一个节点的时候，第一个指针的下一个指针指向自己下下个节点。
 * 
 * 问题的难点在于，如果确定边界值，一共有n个节点，需要删除的是倒数第n个节点。
 */
public class _19_removeNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode x1 = head;
        ListNode x2 = head;
        /* 由题目可知，链表一定不是空的，所以x2肯定不是null */
        while (n > 0) {
            x2 = x2.next;
            n--;
        }
        /* 如果往后跳了n次后，x2成为了null，说明需要删除的是第一个节点 */
        if (x2 == null) {
            return head.next;
        }

        /* 当x2的next是null的时候，x1的下一个节点就是需要删除的节点，
         * 因为当x2为null的时候，x1当前所在的节点是需要删除的节点，
         * 但是因为删除x1无法删除，所以我们要少跳一次*/
        while (x2.next != null) {
            x2 = x2.next;
            x1 = x1.next;
        }
        x1.next = x1.next.next;

        return head;
    }
}
