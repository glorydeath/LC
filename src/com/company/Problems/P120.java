package com.company.Problems;

import java.util.ArrayList;
import java.util.List;

/**
 * 120. Triangle
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 *
 * For example, given the following triangle
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 *
 * Note:
 *
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 */
// TODO: optimize the space complexity
public class P120 {

    public static void runProblem() {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        List<Integer> row1 = new ArrayList<Integer>();
        row1.add(2);
        triangle.add(row1);
        List<Integer> row2 = new ArrayList<Integer>();
        row2.add(3);
        row2.add(4);
        triangle.add(row2);
        List<Integer> row3 = new ArrayList<Integer>();
        row3.add(6);
        row3.add(5);
        row3.add(7);
        triangle.add(row3);
        List<Integer> row4 = new ArrayList<Integer>();
        row4.add(4);
        row4.add(1);
        row4.add(8);
        row4.add(3);
        triangle.add(row4);
        System.out.println(minimumTotal(triangle));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] result = new int[n][n];
        result[0][0] = triangle.get(0).get(0);
        for (int i=1; i<n; i++) {
            result[i][0] = result[i-1][0] + triangle.get(i).get(0);
            for (int j=1; j<i; j++) {
                result[i][j] = Math.min(result[i-1][j-1], result[i-1][j]) + triangle.get(i).get(j);
            }
            result[i][i] = result[i-1][i-1] + triangle.get(i).get(i);
        }
        int min = Integer.MAX_VALUE;
        for(int i=0; i<n; i++) {
            min = Math.min(result[n-1][i], min);
        }
        return min;
    }
}
