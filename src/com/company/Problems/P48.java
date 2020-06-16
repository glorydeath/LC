package com.company.Problems;

public class P48 {
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n == 0 || n == 1) {
            return;
        }
        int n2 = n / 2;
        for (int i=0; i < n2; i++) {
            for (int j=i; j < n - 1 - i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = tmp;
            }
        }

    }
}
