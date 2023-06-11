package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SolutionPractice2 {

    private static class Pair {
        public int row, col;
        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<Pair>> acc = new ArrayList<>();
        BT(0, n, new ArrayList<>(), acc);
        List<List<String>> res = new ArrayList<>();
        for (int k = 0; k < acc.size(); k++) {
            List<Pair> pairs = acc.get(k);
            List<String> c = new ArrayList<String>();
            for (int i = 0; i < n; i++) {
                c.add(new String(".".repeat(n)));
            }
            res.add(c);
            for (int p = 0; p < pairs.size(); p++) {
                Pair pair = pairs.get(p);
                String row = c.get(pair.row);
                row = row.substring(0, pair.col) + 'Q' + row.substring(pair.col+1);
                c.set(pair.row, row);
            }
        }
        return res;
    }

    private void BT(int i, int n, ArrayList<Pair> queens, List<List<Pair>> acc) {
        if (i == n) {
            if (queens.size() == n) {
                acc.add(new ArrayList<Pair>(queens));
            }
            return;
        }
        for (int j = 0; j < n; j++) {
            boolean valid = true;
            for (int q = 0; q < queens.size(); q++) {
                Pair queen = queens.get(q);
                if (queen.col == j || (i-j == queen.row-queen.col) || (i+j == queen.row+queen.col)) {
                    valid = false;
                    q = queens.size();
                } 
            }
            if (valid) {
                queens.add(new Pair(i, j));
                BT(i+1, n, queens, acc);
                queens.remove(queens.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        testSolutionPractice2_1();
        testSolutionPractice2_2();
    }

    private static void testSolutionPractice2_1() {
        int n = 4;
        SolutionPractice2 s = new SolutionPractice2();
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
        System.out.println("testSolutionPractice2_1: " + (passed ? "passed" : "failed"));
    }

    private static void testSolutionPractice2_2() {
        int n = 1;
        SolutionPractice2 s = new SolutionPractice2();
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
        System.out.println("testSolutionPractice2_2: " + (passed ? "passed" : "failed"));
    }
}
