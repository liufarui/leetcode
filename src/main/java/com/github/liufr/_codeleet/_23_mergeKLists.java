package com.github.liufr._codeleet;

/**
 * @author lfr
 * @date 2020/7/31 11:28
 * 23. 合并K个排序链表
 * 
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 解题思路：
 * 方法和两个有序链表拼接基本一致，通过优先队列，每次找到所有队列里面最小的val,作为下一个指针的地址；
 * 但是这样做完之后，发现耗时308ms，时间复杂度相对较高，所以需要想办法做优化；
 * 考虑到链表数字很有可能重复的情况，所以我们维护一个叫node的int数组，里面保存那些头节点val相同的链表信息；
 * 然后在拼接的时候一次性将这些全部拼接，再进行下一次循环，当index为0的时候，说明节点全部遍历结束，跳出循环。
 */
public class _23_mergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode();
        ListNode temp = head;

        while (true) {
            /* 记录当前最小值 */
            int tempMin = Integer.MAX_VALUE;
            /* 记录当前头节点val等于当前最小值的链表位置 */
            int[] node = new int[lists.length];
            int index = 0;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null && tempMin >= lists[i].val) {
                    /* 如果找到新的最小值，则记录最小值，并将index重置 */
                    if (tempMin > lists[i].val) {
                        tempMin = lists[i].val;
                        index = 0;
                    }
                    node[index++] = i;
                }
            }
            /* 如果index没有增加，说明链表数组里面的链表已经全部为null */
            if (index == 0) {
                break;
            } else {
                /* 循环添加头指针 */
                for (int i = 0; i < index; i++) {
                    temp = temp.next = lists[node[i]];
                    lists[node[i]] = lists[node[i]].next;
                }
            }
        }
        /* 返回头指针的下一个指针（真正的头指针） */
        return head.next;
    }
}
