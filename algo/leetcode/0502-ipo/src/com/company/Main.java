package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        testSolutionBruteForce1();
        testSolutionBruteForce2();

        testSolutionOptimized2_1();
        testSolutionOptimized2_2();
    }

    public static void testSolutionBruteForce1() {
        int k = 2, w = 0;
        int[] profits = new int[]{1,2,3}, capital = new int[]{0,1,1};
        SolutionOptimized s = new SolutionOptimized();
        int output = s.findMaximizedCapital(k, w, profits, capital);
        boolean passed = output == 4;
        System.out.println("testSolutionBruteForce1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionBruteForce2() {
        int k = 3, w = 0;
        int[] profits = new int[]{1,2,3}, capital = new int[]{0,1,2};
        SolutionOptimized s = new SolutionOptimized();
        int output = s.findMaximizedCapital(k, w, profits, capital);
        boolean passed = output == 6;
        System.out.println("testSolutionBruteForce2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionOptimized2_1() {
        int k = 1, w = 0;
        int[] profits = new int[]{1,2,3}, capital = new int[]{1,1,2};
        SolutionOptimized2 s = new SolutionOptimized2();
        int output = s.findMaximizedCapital(k, w, profits, capital);
        boolean passed = output == 0;
        System.out.println("testSolutionOptimized2_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionOptimized2_2() throws FileNotFoundException, IOException {
        File f = new File("/Users/new/Developer/competitive-programming/algo/leetcode/0502-ipo/input.txt");
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("/Users/new/Developer/competitive-programming/algo/leetcode/0502-ipo/input.txt")))) {
            int k = Integer.parseInt(bufferedReader.readLine());
            int w = Integer.parseInt(bufferedReader.readLine());
            String[] profitsStr = bufferedReader.readLine().replaceAll(",\\s*$", "").split(",");
            int[] profits = new int[profitsStr.length];
            for (int i = 0; i < profitsStr.length; i++) {
                profits[i] = Integer.parseInt(profitsStr[i]);
            }

            String[] capitalStr = bufferedReader.readLine().replaceAll(",\\s*$", "").split(",");
            int[] capital = new int[profitsStr.length];
            for (int i = 0; i < capitalStr.length; i++) {
                capital[i] = Integer.parseInt(capitalStr[i]);
            }

            SolutionOptimized2 s = new SolutionOptimized2();
            int output = s.findMaximizedCapital(k, w, profits, capital);
            boolean passed = output == 595057;
            System.out.println("testSolutionOptimized2_2: " + (passed ? "passed" : "failed"));
        }
    }
}