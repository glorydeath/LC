package com.company.Problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *
 * Example 1:
 *
 * Input:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 *
 * Input:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class P54 {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> results = new ArrayList<Integer>();
        int n = matrix.length;
        if (n == 0) {
            return null;
        }
        int m = matrix[0].length;
        int row = 0;
        int col = 0;
        while(n > 0 && m > 0) {
            if (n == 1) {
                for(int i=0; i<=m-1; i++) {
                    results.add(matrix[row][col++]);
                }
                break;
            } else if (m == 1) {
                for(int i=0; i<n-1; i++) {
                    results.add(matrix[row++][col]);
                }
                break;
            }
            for(int i=0; i<m-1; i++) {
                results.add(matrix[row][col++]);
            }
            for(int i=0; i<n-1; i++) {
                results.add(matrix[row++][col]);
            }
            for(int i=0; i<m-1; i++) {
                results.add(matrix[row][col--]);
            }
            for(int i=0; i<n-1; i++) {
                results.add(matrix[row--][col]);
            }
            row++;
            col++;
            m -= 2;
            n -= 2;
        }
        return results;
    }
}
