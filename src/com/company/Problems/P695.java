package com.company.Problems;

/**
 * 695. Max Area of Island
 *
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 *
 * Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)
 *
 * Example 1:
 *
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,1,1,0,1,0,0,0,0,0,0,0,0],
 *  [0,1,0,0,1,1,0,0,1,0,1,0,0],
 *  [0,1,0,0,1,1,0,0,1,1,1,0,0],
 *  [0,0,0,0,0,0,0,0,0,0,1,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
 * Example 2:
 *
 * [[0,0,0,0,0,0,0,0]]
 * Given the above grid, return 0.
 * Note: The length of each dimension in the given grid does not exceed 50.
 */
public class P695 {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        if (n == 0) {
            return 0;
        }
        int m = grid[0].length;
        if (m == 0) {
            return 0;
        }
        int maxArea = 0;
        boolean[][] visited = new boolean[n][m];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    maxArea = Math.max(maxArea, explore(grid, visited, i, j, n, m));
                }
            }
        }
        return maxArea;
    }

    public int explore(int[][] grid, boolean[][] visited, int i, int j, int n, int m) {
        int area = 1;
        if (i < n-1 && grid[i+1][j] == 1 && !visited[i+1][j]) {
            visited[i+1][j] = true;
            area += explore(grid, visited, i+1, j, n, m);
        }
        if (j > 0 && grid[i][j-1]==1 && !visited[i][j-1]) {
            visited[i][j-1] = true;
            area += explore(grid, visited, i, j-1, n, m);
        }
        if (i > 0 && grid[i-1][j]==1 && !visited[i-1][j]) {
            visited[i-1][j] = true;
            area += explore(grid, visited, i-1, j, n, m);
        }
        if (j < m-1 && grid[i][j+1]==1 && !visited[i][j+1]) {
            visited[i][j+1] = true;
            area += explore(grid, visited, i, j+1, n, m);
        }
        return area;
    }

}
