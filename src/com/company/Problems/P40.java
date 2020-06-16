package com.company.Problems;

import java.util.*;

/**
 * 40. Combination Sum II
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations
 * in candidates where the candidate numbers sums to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 */
public class P40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        Set<List> set = new HashSet<List>();
        List<Integer> curComb = new ArrayList<Integer>();
        Arrays.sort(candidates);
        calComb(candidates, 0, target, curComb, results, set);
        return results;
    }

    public void calComb(int[] candidates, int index, int curVal, List<Integer> curComb, List<List<Integer>> results,
                        Set<List> set) {
        if (curVal == 0) {
            List<Integer> newComb = new ArrayList<Integer>(curComb);
            if (!set.contains(newComb)) {
                set.add(newComb);
                results.add(newComb);
            }
            return;
        }
        int n = candidates.length;
        for (int i=index; i<n; i++) {
            if (candidates[i] <= curVal) {
                curVal -= candidates[i];
                curComb.add(candidates[i]);
                calComb(candidates, +1, curVal, curComb, results, set);
                curVal += candidates[i];
                curComb.remove(curComb.size() - 1);
            }
        }
        return;

    }
}
