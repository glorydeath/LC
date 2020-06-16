package com.company.Problems;

public class P33 {
    public static int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = n-1;
        while(l <= r) {
            int m = (l + r) / 2;
            if (nums[m] == target) {
                return m;
            }
            if (nums[m] < nums[r]) {
                // right part is sorted
                if (nums[m] < target && target <= nums[r]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            } else {
                // left part is sorted
                if (nums[l] <= target && target < nums[m]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
        }
        return -1;
    }
}
