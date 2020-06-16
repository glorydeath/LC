package com.company.Problems;

import java.util.Queue;

/**
 * 59. Spiral Matrix II
 *
 * Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 *
 * Example:
 *
 * Input: 3
 * Output:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 */
public class P59 {
    public static int[][] generateMatrix(int n) {
        int[][] results = new int[n][n];
        if (n == 0) {
            return results;
        }
        if (n == 1) {
            results[0][0] = 1;
            return results;
        }
        int numOffer = 1;
        int layer = 0;
        while (numOffer <= n*n) {
            for(int j=layer; j<n-1-layer; j++) {
                results[layer][j] = numOffer++;
            }
            for(int i=layer; i<n-1-layer; i++) {
                results[i][n-1-layer] = numOffer++;
            }
            for(int j=n-1-layer; j>layer; j--) {
                results[n-1-layer][j] = numOffer++;
            }
            for(int i=n-1-layer; i>layer; i--) {
                results[i][layer] = numOffer++;
            }
            layer++;
            if (numOffer == n*n) {
                results[layer][layer] = numOffer++;
            }
        }
        return results;
    }
}
