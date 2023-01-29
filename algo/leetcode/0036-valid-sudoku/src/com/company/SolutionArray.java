package com.company;

public class SolutionArray {
    public boolean isValidSudoku(char[][] board) {
        if (board.length != board[0].length) {
            return false;
        }
        int N = board.length;
        for (int i = 0; i < N; i++) {
            boolean[] used = new boolean[N];
            for (int j = 0; j < N; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (used[board[i][j] - '1']) {
                    return false;
                } else {
                    used[board[i][j] - '1'] = true;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            boolean[] used = new boolean[N];
            for (int j = 0; j < N; j++) {
                if (board[j][i] == '.') {
                    continue;
                }
                if (used[board[j][i] - '1']) {
                    return false;
                } else {
                    used[board[j][i] - '1'] = true;
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boolean[] used = new boolean[N];
                for (int s = 0; s < 9; s++) {
                    int indI = i*3 + (s / 3);
                    int indJ = j*3 + (s % 3);
                    if (board[indI][indJ] == '.') {
                        continue;
                    }
                    if (used[board[indI][indJ] - '1']) {
                        return false;
                    } else {
                        used[board[indI][indJ] - '1'] = true;
                    }
                }
            }
        }

        return true;
    }
}
