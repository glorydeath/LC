package com.company.Problems;

import java.util.ArrayList;
import java.util.List;

/**
 * 442. Find All Duplicates in an Array
 *
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 *
 * Find all the elements that appear twice in this array.
 *
 * Could you do it without extra space and in O(n) runtime?
 *
 * Example:
 * Input:
 * [4,3,2,7,8,2,3,1]
 *
 * Output:
 * [2,3]
 */
public class P442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> results = new ArrayList<Integer>();
        int n = nums.length;
        if (n == 0) {
            return results;
        }
        for (int i=0; i<n; i++) {
            if (nums[Math.abs(nums[i]) - 1] > 0) {
                nums[Math.abs(nums[i]) - 1] *= -1;
            } else {
                results.add(Math.abs(nums[i]));
            }
        }
        return results;
    }
}
