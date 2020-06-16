package com.company.Problems;

import com.company.Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 101. Symmetric Tree
 *
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 *
 * But the following [1,2,2,null,3,null,3] is not:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 */
public class P101 {
    public boolean isSymmetric(TreeNode root) {
        List<Integer> midOrderList = new ArrayList<Integer>();
        midOrderTraversal(midOrderList, root);
        int i = 0;
        int j = midOrderList.size() - 1;
        while (i < j) {
            if (midOrderList.get(i++) != midOrderList.get(j--)) {
                return false;
            }
        }
        System.out.println(midOrderList);
        return true;
    }

    public void midOrderTraversal(List<Integer> result, TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            midOrderTraversal(result, root.left);
        }
        result.add(root.val);
        if (root.right != null) {
            midOrderTraversal(result, root.right);
        }
    }
}
