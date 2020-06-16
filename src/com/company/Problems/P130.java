package com.company.Problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 130. Surrounded Regions
 *
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 *
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 * Example:
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * Explanation:
 *
 * Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'.
 * Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'.
 * Two cells are connected if they are adjacent cells connected horizontally or vertically.
 */
public class P130 {
    public static void solve(char[][] board) {
        int n = board.length;
        if (n == 0) {
            return;
        }
        int m = board[0].length;
        if (m == 0) {
            return;
        }
        for(int i=0; i<n; i++) {
            if (board[i][0] == 'O') {
                fill(board, i, 0);
            }
            if (board[i][m-1] == 'O') {
                fill(board, i, m-1);
            }
        }
        for (int j=0; j<m; j++) {
            if (board[0][j] == 'O') {
                fill(board, 0, j);
            }
            if (board[n-1][j] == 'O') {
                fill(board, n-1, j);
            }
        }
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public static void fill(char[][] board, int row, int col) {
        int n = board.length;
        int m = board[0].length;
        Queue<Integer> queue = new LinkedList<Integer>();
        board[row][col] = '#';
        queue.offer(row * m + col);
        while(!queue.isEmpty()) {
            int code = queue.poll();
            int i = code / m;
            int j = code % m;
            if (i > 0 && board[i-1][j] == 'O') {
                board[i-1][j] = '#';
                queue.offer((i-1) * m + j);
            }
            if (j > 0 && board[i][j-1] == 'O') {
                board[i][j-1] = '#';
                queue.offer(i * m + (j-1));
            }
            if (i < n-1 && board[i+1][j] == 'O') {
                board[i+1][j] = '#';
                queue.offer((i+1) * m + j);
            }
            if (j < m-1 && board[i][j+1] == 'O') {
                board[i][j+1] = '#';
                queue.offer(i * m + (j+1));
            }
        }
    }
}
