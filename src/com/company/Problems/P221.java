package com.company.Problems;

/**
 * 221. Maximal Square
 *
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 *
 * Example:
 *
 * Input:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * Output: 4
 */

// DP formula: dp[i][j] represents the right down corner of a square's edge.
// dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1  if (matrix[i][j] = 1)
// dp[i][j] = 0   if (matrix[i][j] = 0)
public class P221 {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        if (n == 0) {
            return 0;
        }
        int m = matrix[0].length;
        int maxlength = 0;
        int[][] dp = new int[n][m];
        for(int i=0; i<n; i++) {
            dp[i][0] = matrix[i][0] - '0';
            if (dp[i][0] > maxlength) {
                maxlength = dp[i][0];
            }
        }
        for(int j=0; j<m; j++) {
            dp[0][j] = matrix[0][j] - '0';
            if (dp[0][j] > maxlength) {
                maxlength = dp[0][j];
            }
        }

        for(int i=1; i<n; i++) {
            for(int j=1; j<m; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                    if (dp[i][j] > maxlength) {
                        maxlength = dp[i][j];
                    }
                }
            }
        }
        return maxlength * maxlength;
    }
}
