package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SolutionPractice3 {

    List<List<String>> acc = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        int[][] board = new int[n][n];
        int[][] queens = new int[n][2];
        for (int i = 0; i < queens.length; i++) {
            board[i] = new int[n];
            queens[i] = new int[2];
        }
        BT(0, n, board, queens, 0);
        return acc;
    }

    // queens, 0 - empty, 1 - queen
    private void BT(int i, int n, int[][] board, int[][] queens, int nQueens) {
        if (i == n) {
            if (nQueens == n) {
                acc.add(toString(board));
            }
            return;
        }
        for (int j = 0; j < n; j++) {
            boolean valid = true;
            for (int q = 0; q < nQueens; q++) {
                int[] queen = queens[q];
                if (queen[1] == j || (i-j == queen[0]-queen[1]) || (i+j == queen[0]+queen[1])) {
                    valid = false;
                    q = queens.length;
                } 
            }
            if (valid) {
                queens[nQueens] = new int[] {i,j};
                board[i][j] = 1;
                BT(i+1, n, board, queens, nQueens+1);
                board[i][j] = 0;
            }
        }
    }

    private List<String> toString(int[][] board) {
        List<String> output = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            output.add(sb.toString());
        }
        return output;
    }
    
    public static void main(String[] args) {
        testSolutionPractice3_1();
        testSolutionPractice3_2();
    }

    private static void testSolutionPractice3_1() {
        int n = 4;
        SolutionPractice3 s = new SolutionPractice3();
        List<List<String>> outputL = s.solveNQueens(n);
        HashSet<String> expOutput = new HashSet<>() {{ add(".Q.."+"...Q"+"Q..."+"..Q."); add("..Q."+"Q..."+"...Q"+".Q.."); }};
        HashSet<String> output = new HashSet<>();
        for (int i = 0; i < outputL.size(); i++) {
            List<String> l = outputL.get(i);
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < l.size(); j++) {
                sb.append(l.get(j));
            }
            output.add(sb.toString());
        }
        boolean passed = expOutput.equals(output);
        System.out.println("testSolutionPractice3_1: " + (passed ? "passed" : "failed"));
    }

    private static void testSolutionPractice3_2() {
        int n = 1;
        SolutionPractice3 s = new SolutionPractice3();
        List<List<String>> outputL = s.solveNQueens(n);
        HashSet<String> expOutput = new HashSet<>() {{ add("Q"); }};
        HashSet<String> output = new HashSet<>();
        for (int i = 0; i < outputL.size(); i++) {
            List<String> l = outputL.get(i);
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < l.size(); j++) {
                sb.append(l.get(j));
            }
            output.add(sb.toString());
        }
        boolean passed = expOutput.equals(output);
        System.out.println("testSolutionPractice3_2: " + (passed ? "passed" : "failed"));
    }
}
