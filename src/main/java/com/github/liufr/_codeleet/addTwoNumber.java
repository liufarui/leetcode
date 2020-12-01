//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
//
//如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
//
//您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
//示例：
//
//输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807

package com.github.liufr._codeleet;

public class addTwoNumber {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode start = new ListNode(0);
        ListNode temp = start;
        int addVal = 0;
        while (l1 != null || l2 != null || addVal > 0) {
            int val = addVal;
            if (l1 != null) {
                val += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                val += l2.val;
                l2 = l2.next;
            }
            addVal = val / 10;
            temp.next = new ListNode(val % 10);
            temp = temp.next;

            if (addVal == 0 && l1 == null) {
                temp.next = l2;
                break;
            } else if (addVal == 0 && l2 == null) {
                temp.next = l1;
                break;
            }
        }
        return start.next;
    }
}
