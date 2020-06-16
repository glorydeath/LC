package com.company.Problems;

import com.company.Utils.ListNode;

/**
 * 86. Partition List
 *
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * Example:
 *
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
 */
public class P86 {
    public static void runProblem() {
        ListNode head = new ListNode(1);
        ListNode cur = head;
        cur.next = new ListNode(4);
        cur = cur.next;
        cur.next = new ListNode(3);
        cur = cur.next;
        cur.next = new ListNode(2);
        cur = cur.next;
        cur.next = new ListNode(5);
        cur = cur.next;
        cur.next = new ListNode(2);
        partition(head, 3);
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode smallerHead = new ListNode(-1);
        ListNode smallerTail = smallerHead;

        ListNode largerHead = new ListNode(-1);
        ListNode largerTail = largerHead;
        while(head != null) {
            if (head.val < x) {
                smallerTail.next = head;
                smallerTail = head;
            } else {
                largerTail.next = head;
                largerTail = head;
            }
            head = head.next;
        }
        largerTail.next = null;
        smallerTail.next = largerHead.next;
        return smallerHead.next;
    }
}
