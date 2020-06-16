package com.company.Problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 47. Permutations II
 *
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 *
 * Example:
 *
 * Input: [1,1,2]
 * Output:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 */
public class P47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        HashSet<List> set = new HashSet<List>();
        List<Integer> curPerm = new ArrayList<Integer>();
        int n = nums.length;
        boolean[] visited = new boolean[n];
        getPerm(results, nums, set, curPerm, visited);
        return results;
    }

    public void getPerm(List<List<Integer>> results, int[] nums, HashSet<List> set, List<Integer> curPerm, boolean[] visited) {
        if (curPerm.size() == nums.length) {
            List<Integer> perm = new ArrayList<Integer>(curPerm);
            if (!set.contains(perm)) {
                set.add(perm);
                results.add(perm);
            }
            return;
        }
        int n = nums.length;
        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                curPerm.add(nums[i]);
                visited[i] = true;
                getPerm(results, nums, set, curPerm, visited);
                curPerm.remove(curPerm.size() - 1);
                visited[i] = false;
            }
        }
    }
}
