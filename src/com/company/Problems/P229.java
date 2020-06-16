package com.company.Problems;

import java.util.ArrayList;
import java.util.List;

/**
 * 229. Majority Element II
 *
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 *
 * Note: The algorithm should run in linear time and in O(1) space.
 *
 * Example 1:
 *
 * Input: [3,2,3]
 * Output: [3]
 * Example 2:
 *
 * Input: [1,1,1,3,3,2,2,2]
 * Output: [1,2]
 */
public class P229 {
    public static List<Integer> majorityElement(int[] nums) {
        long groupA = (long)Integer.MAX_VALUE + 1;
        long groupB = (long)Integer.MAX_VALUE + 1;
        int cntA = 0;
        int cntB = 0;
        int n = nums.length;
        for(int i=0; i<n; i++) {
            if (nums[i] == groupA) {
                cntA++;
            } else if (nums[i] == groupB) {
                cntB++;
            } else if (cntA == 0) {
                groupA = nums[i];
                cntA = 1;
            } else if (cntB == 0) {
                groupB = nums[i];
                cntB = 1;
            } else {
                cntA--;
                cntB--;
            }
        }
        cntA = 0;
        cntB = 0;
        List<Integer> results = new ArrayList<Integer>();
        for(int i=0; i<n; i++) {
            if (nums[i] == groupA) {
                cntA ++;
            }
            if (nums[i] == groupB) {
                cntB ++;
            }
        }
        if (cntA > n / 3) {
            results.add((int)groupA);
        }
        if (cntB > n / 3) {
            results.add((int)groupB);
        }
        return results;
    }
}
