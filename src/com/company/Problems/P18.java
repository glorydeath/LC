package com.company.Problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 4Sum
 *
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 *
 * Note:
 *
 * The solution set must not contain duplicate quadruplets.
 *
 * Example:
 *
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 *
 * A solution set is:
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 */

public class P18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0; i<n-3; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            for (int j=i+1; j<n-2; j++) {
                if (j > i + 1 && nums[j] == nums[j-1]) {
                    continue;
                }
                int k = j + 1;
                int l = n - 1;
                while (k < l) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum < target) {
                        k++;
                        while(k < l && nums[k] == nums[k-1]) {
                            k++;
                        }
                    } else if (sum > target) {
                        l--;
                        while(l > k && nums[l] == nums[l+1]) {
                            l--;
                        }
                    } else {
                        ArrayList<Integer> quadruple = new ArrayList<Integer>();
                        quadruple.add(nums[i]);
                        quadruple.add(nums[j]);
                        quadruple.add(nums[k]);
                        quadruple.add(nums[l]);
                        results.add(quadruple);
                        k++;
                        l--;
                        while(k < l && nums[k] == nums[k-1]) {
                            k++;
                        }
                        while(l > k && nums[l] == nums[l+1]) {
                            l--;
                        }
                    }
                }
            }
        }
        return results;
    }
}
