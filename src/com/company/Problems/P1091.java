package com.company.Problems;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1091. Shortest Path in Binary Matrix
 *
 * In an N by N square grid, each cell is either empty (0) or blocked (1).
 *
 * A clear path from top-left to bottom-right has length k if and only if it is composed of cells C_1, C_2, ..., C_k such that:
 *
 * Adjacent cells C_i and C_{i+1} are connected 8-directionally (ie., they are different and share an edge or corner)
 * C_1 is at location (0, 0) (ie. has value grid[0][0])
 * C_k is at location (N-1, N-1) (ie. has value grid[N-1][N-1])
 * If C_i is located at (r, c), then grid[r][c] is empty (ie. grid[r][c] == 0).
 * Return the length of the shortest such clear path from top-left to bottom-right.  If such a path does not exist, return -1.
 *
 * 1 <= grid.length == grid[0].length <= 100
 * grid[r][c] is 0 or 1
 */
public class P1091 {

    class QueueEle{
        int position;
        int step;

        public QueueEle(int position, int step) {
            this.position = position;
            this.step = step;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int[] steps = {-1, 0, 1};
        int n = grid.length;
        if (n == 0) {
            return -1;
        }
        int m = grid[0].length;
        if (grid[0][0] == 1) {
            return -1;
        }
        int[][] visited = new int[n][m];
        // num representation is: a[i] * m + a[j]
        int destination = n * m - 1;
        Queue<QueueEle> queue = new LinkedList<QueueEle>();
        queue.offer(new QueueEle(0, 1));
        visited[0][0] = 1;
        while(!queue.isEmpty()) {
            QueueEle queueEle = queue.poll();
            int position = queueEle.position;
            int step = queueEle.step;
            if (position == destination) {
                return step;
            }
            int i = position / m;
            int j = position % m;
            for (int k = 0; k < 3; k++) {
                for (int l = 0; l < 3; l++) {
                    if (k==1 && l==1) {
                        continue;
                    }
                    int newI = i + steps[k];
                    int newJ = j + steps[l];
                    if (newI >= 0 && newI < n && newJ >= 0 && newJ < m && grid[newI][newJ]==0 && visited[newI][newJ]==0) {
                        queue.offer(new QueueEle(newI * m + newJ, step + 1));
                        visited[newI][newJ] = 1;
                    }
                }
            }

        }
        return -1;
    }
}
