package com.company.Problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 3Sum
 *
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class P15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i=0; i<n-2; i++) {
            // if it is the same, we don't calculate it again
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    List<Integer> triple = new ArrayList<Integer>();
                    triple.add(nums[i]);
                    triple.add(nums[j]);
                    triple.add(nums[k]);
                    results.add(triple);
                    while (j < n - 1 && nums[j] == nums[j+1]) {
                        j++;
                    }
                    j++;
                    while (nums[k] == nums[k-1]) {
                        k--;
                    }
                    k--;
                } else if (sum > 0) {
                    while (nums[k] == nums[k-1]) {
                        k--;
                    }
                    k--;
                } else {
                    while (j < n - 1 && nums[j] == nums[j+1]) {
                        j++;
                    }
                    j++;
                }
            }

        }
        return results;
    }
}
