package com.company.Problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P1260 {
    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
        // Calculate where the first element should be
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        int m = grid.length;
        int n = grid[0].length;
        int totalNum = m * n;
        int round = k % totalNum;
        int row = round / n;
        int col = round % n;
        Integer[][] resultsArr = new Integer[m][n];
        int newI = row;
        int newJ = col;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                resultsArr[newI][newJ] = grid[i][j];
                newJ++;
                if (newJ >= n) {
                    newJ = 0;
                    newI++;
                }
                if (newI >= m) {
                    newI = 0;
                }
            }
        }
        for (int i=0; i<m; i++) {
            results.add(Arrays.asList(resultsArr[i]));
        }
        return results;
    }
}
