package com.company.Problems;

import com.company.Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. Path Sum II

 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \    / \
 * 7    2  5   1
 * Return:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */
public class P113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        int sumSoFar = 0;
        List<Integer> path = new ArrayList<Integer>();
        path.add(root.val);
        sumSoFar += root.val;
        findSum(root, sum, sumSoFar, path, results);
        return results;
    }

    public void findSum(TreeNode root, int sum, int sumSoFar, List<Integer> path, List<List<Integer>> results) {
        if (isLeaf(root)) {
            if (sumSoFar == sum) {
                results.add(new ArrayList<Integer>(path));
            }
            return;
        }
        if (root.left != null) {
            sumSoFar += root.left.val;
            path.add(root.left.val);
            findSum(root.left, sum, sumSoFar, path, results);
            sumSoFar -= root.left.val;
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            sumSoFar += root.right.val;
            path.add(root.right.val);
            findSum(root.right, sum, sumSoFar, path, results);
            sumSoFar += root.right.val;
            path.remove(path.size() - 1);
        }
    }

    public boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
