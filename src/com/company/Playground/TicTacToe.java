package com.company.Playground;

public class TicTacToe {
    int[][] board;
    int n;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.n = n;
        this.board = new int[n][n];
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        this.board[row][col] = player;
        if (hasWon(this.board, row, col)) {
            return player;
        } else {
            return 0;
        }

    }

    public boolean hasWon(int[][] board, int row, int col) {
        int checkItem = board[row][col];
        for(int i=0; i<n; i++) {
            boolean flag = true;
            for(int j=0; j<n; j++) {
                if (board[i][j] != checkItem) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
        }
        for(int j=0; j<n; j++) {
            boolean flag = true;
            for(int i=0; i<n; i++) {
                if (board[j][i] != checkItem) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
        }
        boolean flag = true;
        for(int i=0; i<n; i++) {
            if (board[i][i] != checkItem) {
                flag = false;
                break;
            }
        }
        if (flag) {
            return true;
        }
        flag = true;
        for(int i=0; i<n; i++) {
            if (board[n-i-1][i] != checkItem) {
                flag = false;
                break;
            }
        }
        if (flag) {
            return true;
        }
        return false;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */