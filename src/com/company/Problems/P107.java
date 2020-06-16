package com.company.Problems;

import com.company.Utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P107 {
    class QueueEle {
        TreeNode node;
        int level;
        public QueueEle(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (root == null) {
            return results;
        }
        Queue<QueueEle> queue = new LinkedList<QueueEle>();
        queue.offer(new QueueEle(root, 0));
        while(!queue.isEmpty()) {
            QueueEle ele = queue.poll();
            int level = ele.level;
            TreeNode node = ele.node;
            if (results.size() <= level) {
                List<Integer> list = new ArrayList<Integer>();
                list.add(node.val);
                results.add(list);
            } else {
                results.get(level).add(node.val);
            }
            if (node.left != null) {
                queue.offer(new QueueEle(node.left, level+1));
            }
            if (node.right != null) {
                queue.offer(new QueueEle(node.right, level+1));
            }
        }
        int n = results.size();
        List<List<Integer>> realResults = new ArrayList<List<Integer>>();
        for(int i=0; i<n; i++) {
            realResults.add(results.get(n-i-1));
        }
        return realResults;
    }
}
