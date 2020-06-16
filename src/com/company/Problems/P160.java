package com.company.Problems;

import com.company.Utils.ListNode;

public class P160 {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode cur = headA;
        while(cur.next != null) {
            cur = cur.next;
        }
        ListNode tailA = cur;
        tailA.next = headB;
        ListNode fast = headA;
        ListNode slow = headA;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            fast = fast.next;
            if (slow == fast) {
                break;
            }
        }
        if (slow != fast) {
            tailA.next = null;
            return null;
        }
        fast = headA;
        while(fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        tailA.next = null;
        return fast;
    }
}
