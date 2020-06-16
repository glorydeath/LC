package com.company.Problems;

import java.util.*;

/**
 * 39. Combination Sum
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique
 * combinations in candidates where the candidate numbers sums to target.
 *
 * The same repeated number may be chosen from candidates unlimited number of times.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 */
public class P39 {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        List<Integer> curComb = new ArrayList<Integer>();
        Arrays.sort(candidates);
        calculateCombination(candidates, 0, target, curComb, results);
        return results;
    }

    public static void calculateCombination(int[] candidates, int index, int current, List<Integer> curComb,
                                     List<List<Integer>> results) {
        if (current == 0) {
            List<Integer> comb = new ArrayList<Integer>(curComb);
            results.add(comb);
            return;
        }
        int n = candidates.length;
        for (int i=index; i<n; i++) {
            if (current >= candidates[i]) {
                current -= candidates[i];
                curComb.add(candidates[i]);
                calculateCombination(candidates, i, current, curComb, results);
                current += candidates[i];
                curComb.remove(curComb.size() - 1);
            }
        }
        return;
    }
}
