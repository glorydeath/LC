package com.company.Playground;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameOfChecker {
    // Assume we are 'O'
    public List<List<List<Integer>>> nextMove(char[][] board, boolean turn) {
        List<List<List<Integer>>> results = new ArrayList<List<List<Integer>>>();
        int n = board.length;
        if (n == 0) {
            return results;
        }
        List<List<Integer>> directions = new ArrayList<List<Integer>>();
        directions.add(Arrays.asList(1,1));
        directions.add(Arrays.asList(-1,-1));
        directions.add(Arrays.asList(1,-1));
        directions.add(Arrays.asList(-1,1));
        int m = board[0].length;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if (board[i][j] == 'O') {
                    // go in 4 directions
                    // a[i][j] -> a[i-1][j-1] -> a[i+1][j+1] -> a[i-1][j+1] -> a[i+1][j-1]
                    int step = 0;
                    for(int k = 0; k < 4; k++) {
                        int newI = i + directions.get(k).get(0);
                        int newJ = j + directions.get(k).get(1);
                        while (canGo(board, newI, newJ)) {
                            List<List<Integer>> result = new ArrayList<List<Integer>>();
                            result.add(Arrays.asList(i, j));
                            result.add(Arrays.asList(newI, newJ));
                            results.add(result);
                            newI = newI + directions.get(k).get(0);
                            newJ = newJ + directions.get(k).get(1);
                        }
                    }

                }
            }
        }
        return results;

    }

    boolean canGo(char[][] board, int newI, int newJ) {
        int n = board.length;
        int m = board[0].length;
        if (newI < 0 || newI >= n || newJ < 0 || newJ >= m) {
            return false;
        }
        if (board[newI][newJ] != '.') {
            return false;
        }
        return true;
    }
}
