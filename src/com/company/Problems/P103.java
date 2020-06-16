package com.company.Problems;


import com.company.Utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 103. Binary Tree Zigzag Level Order Traversal

 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */
// todo: find a better solution
public class P103 {

    class QueueEle {
        TreeNode node;
        int         level;
        QueueEle(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (root == null) {
            return results;
        }
        Queue<QueueEle> queue = new LinkedList<QueueEle>();
        queue.offer(new QueueEle(root, 1));
        List<Integer> r = new ArrayList<Integer>();
        int level = 1;
        while(!queue.isEmpty()) {
            QueueEle ele = queue.poll();
            if (ele.level > level) {
                if (level % 2 != 0) {
                    results.add(r);
                } else {
                    List<Integer> reverseR = new ArrayList<Integer>();
                    for (int i=r.size() - 1; i>=0; i--) {
                        reverseR.add(r.get(i));
                    }
                    results.add(reverseR);
                }
                r = new ArrayList<Integer>();
                level++;
            }

            r.add(ele.node.val);
            if (ele.node.left != null) {
                queue.offer(new QueueEle(ele.node.left, level + 1));
            }
            if (ele.node.right != null) {
                queue.offer(new QueueEle(ele.node.right, level + 1));
            }
        }
        level++;
        if (level % 2 != 0) {
            results.add(r);
        } else {
            List<Integer> reverseR = new ArrayList<Integer>();
            for (int i=r.size() - 1; i>=0; i--) {
                reverseR.add(r.get(i));
            }
            results.add(reverseR);
        }
        return results;
    }
}
