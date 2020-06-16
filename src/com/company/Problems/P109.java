package com.company.Problems;

import com.company.Utils.ListNode;
import com.company.Utils.TreeNode;

/**
 * 109. Convert Sorted List to Binary Search Tree
 *
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example:
 *
 * Given the sorted linked list: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
public class P109 {
    public static TreeNode sortedListToBST(ListNode head) {
        return convertToTree(head);
    }

    public static TreeNode convertToTree(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next;
            if (fast == null || fast.next == null) {
                break;
            }
            fast = fast.next;
        }
        pre.next = null;
        TreeNode newRoot = new TreeNode(slow.val);
        newRoot.left = convertToTree(head);
        newRoot.right = convertToTree(slow.next);
        return newRoot;
    }
}
