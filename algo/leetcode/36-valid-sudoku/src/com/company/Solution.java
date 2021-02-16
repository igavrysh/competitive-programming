package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int size = board.length;

        List<Set<Integer>> sq = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            sq.add(new HashSet<>());
        }

        for (int i = 0; i < size; i++) {
            Set<Integer> occx = new HashSet<>();
            Set<Integer> occy = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (board[i][j] != '.') {
                    int valy = Character.getNumericValue(board[i][j]);
                    if (occy.contains(valy)) {
                        return  false;
                    }
                    occy.add(valy);

                    int sqIdx = i/3*3 + j/3;
                    Set<Integer> square = sq.get(sqIdx);
                    if (square.contains(valy)) {
                        return false;
                    }
                    square.add(valy);
                }
                if (board[j][i] != '.') {
                    int valx = Character.getNumericValue(board[j][i]);
                    if (occx.contains(valx)) {
                        return  false;
                    }
                    occx.add(valx);
                }
            }
        }
        return true;
    }
}
