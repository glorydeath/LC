package com.company.Problems;

import com.company.Utils.TreeNode;

public class P110 {

    public boolean isBalanced(TreeNode root) {
        if (getHeight(root) == -1) {
            return false;
        }
        return true;
    }

    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = getHeight(root.right);
        if (rightHeight == -1) {
            return -1;
        }
        int diff = Math.abs(leftHeight - rightHeight);
        if (diff > 1) {
            return -1;
        }
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
