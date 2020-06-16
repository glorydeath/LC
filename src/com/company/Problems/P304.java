package com.company.Problems;

import java.util.ArrayList;
import java.util.List;

/**
 * 304. Range Sum Query 2D - Immutable
 *
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
 *
 * Range Sum Query 2D
 * The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.
 *
 * Example:
 * Given matrix = [
 *   [3, 0, 1, 4, 2],
 *   [5, 6, 3, 2, 1],
 *   [1, 2, 0, 1, 5],
 *   [4, 1, 0, 1, 7],
 *   [1, 0, 3, 0, 5]
 * ]
 *
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 * Note:
 * You may assume that the matrix does not change.
 * There are many calls to sumRegion function.
 * You may assume that row1 ≤ row2 and col1 ≤ col2.
 */

// sum[i][j] meaning the sum for the matrix: (0,0), (i,j)
// so sumRegion(i,j,k,l) = sum[k][l] - sum[i][j] - sum

public class P304 {
    int[][] sum;
    int n;
    int m;
    public P304(int[][] matrix) {
        this.n = matrix.length;
        if (n == 0) {
            return;
        }
        this.m = matrix[0].length;
        this.sum = new int[n+1][m+1];
        for(int i=0; i<this.n; i++) {
            this.sum[i][0] = 0;
        }
        for(int j=0; j<=this.m; j++) {
            this.sum[0][j] = 0;
        }
        for(int i=1; i<=this.n; i++) {
            for(int j=1; j<this.m; j++) {
                this.sum[i][j] = this.sum[i-1][j] + this.sum[i][j-1] - this.sum[i-1][j-1] + matrix[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return this.sum[row2 + 1][col2 + 1] - this.sum[row1][col2 + 1] - this.sum[row2 + 1][col1] + this.sum[row1][col1];
    }
}
