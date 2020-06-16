package com.company.Problems;

import java.util.HashSet;
import java.util.Set;

/**
 * 260. Single Number III
 *
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.
 *
 * Example:
 *
 * Input:  [1,2,1,3,2,5]
 * Output: [3,5]
 * Note:
 *
 * The order of the result is not important. So in the above example, [5, 3] is also correct.
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 */
// todo: not optimal
public class P260 {
    public int[] singleNumber(int[] nums) {
        Set<Integer> set = new HashSet();
        int[] results = new int[2];
        for(int i=0; i<nums.length; i++) {
            if (set.contains(nums[i])) {
                set.remove(nums[i]);
            } else {
                set.add(nums[i]);
            }
        }
        int i = 0;
        for(int r : set) {
            results[i++] = r;
        }
        return results;
    }
}
