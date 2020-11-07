package com.liufr.leetcode._codeleet;

import java.util.HashSet;

/**
 * @author lfr
 * @date 2020/8/16 18:48
 *
 * 解题思路：
 * 将所有的节点列入set中，然后当发现有节点已经存在，则返回。
 * 时间复杂度：O（n），非最优解。
 */
public class _142_detectCycle_2 {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<ListNode>();
        if (head == null) {
            return null;
        }

        while (head != null && !set.contains(head)) {
            set.add(head);
            head = head.next;
        }

        return head;
    }
}
