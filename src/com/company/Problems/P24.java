package com.company.Problems;

import com.company.Utils.ListNode;

/**
 * 24. Swap Nodes in Pairs
 *
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 *
 *
 * Example:
 *
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 */
public class P24 {
    public ListNode swapPairs(ListNode head) {
        ListNode h = new ListNode(0);
        h.next = head;
        ListNode pre = h;
        ListNode curNode = head;
        while (curNode != null && curNode.next != null) {
            ListNode tmp = curNode.next;
            pre.next = tmp;
            curNode.next = tmp.next;
            tmp.next = curNode;
            pre = curNode;
            curNode = curNode.next;
        }
        return h.next;
    }
}
