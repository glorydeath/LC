package com.company.Problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 *
 * Example:
 *
 * Input: n = 4, k = 2
 * Output:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */
public class P77 {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        List<Integer> curComb = new ArrayList<Integer>();
        cal(results, curComb, 0, n, k);
        return results;
    }

    public static void cal(List<List<Integer>> results, List<Integer> curComb, int curNum, int n, int k) {
        if (curComb.size() >= k) {
            List<Integer> comb = new ArrayList<Integer>(curComb);
            results.add(comb);
            return;
        }
        for (int i=curNum + 1; i<=n; i++) {
            curComb.add(i);
            cal(results, curComb, i, n, k);
            curComb.remove(curComb.size()-1);
        }
    }
}
