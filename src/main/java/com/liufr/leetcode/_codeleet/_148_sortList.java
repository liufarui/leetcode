package com.liufr.leetcode._codeleet;

/**
 * @author lfr
 * @date 2020/8/17 11:26
 *
 * 148. 排序链表
 *
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 *
 * 解题思路：
 * 归并排序；
 * 排序算法还是不够熟悉，需要加强。
 */
public class _148_sortList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        System.out.println(sortList(node1));
    }

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode mid = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        ListNode ret = new ListNode();
        ListNode flag = ret;
        while (left != null && right != null) {
            if(left.val < right.val) {
                flag.next = left;
                left = left.next;
            } else {
                flag.next = right;
                right = right.next;
            }
            flag = flag.next;
        }
        if(left != null) {
            flag.next = left;
        }
        if(right != null) {
            flag.next = right;
        }

        return ret.next;
    }
}
