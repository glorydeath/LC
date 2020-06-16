package com.company.Problems;

import java.util.*;

/**
 * 90. Subsets II
 *
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 * Input: [1,2,2]
 * Output:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 */
public class P90 {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        Set<List<Integer>> dupSet = new HashSet<List<Integer>>();
        List<Integer> r = new ArrayList<Integer>();
        dupSet.add(r);
        results.add(r);
        List<Integer> subset = new ArrayList<Integer>();
        getSubset(results, dupSet, subset, nums, 0);
        return results;
    }

    public static void getSubset(List<List<Integer>> results, Set<List<Integer>> dupSet, List<Integer> subset, int[] nums, int index) {
        if (index >= nums.length) {
            return;
        }
        for (int i=index; i<nums.length; i++) {
            subset.add(nums[i]);
            if (!dupSet.contains(subset)) {
                dupSet.add(subset);
                results.add(new ArrayList<Integer>(subset));
                getSubset(results, dupSet, subset, nums, i + 1);
            }
            subset.remove(subset.size() - 1);
        }
    }
}
