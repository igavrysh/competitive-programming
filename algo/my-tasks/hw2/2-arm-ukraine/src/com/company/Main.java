package com.company;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;

class SolutionBruteForce {
    public int numCombinations(int x, int y, int z, int w) {
        // edge cases, include for exhaustiveness, should be filtered out by problem definition
        if (w <= 0 || x < 0 || y < 0 || z < 0) return 0;
        if (x <= 0 && y == 0 && z == 0) return 0;
        int result = 0;
        for (int nX = 0; nX*x <= w; nX++) {
            for (int nY = 0; nY*y <= (w-nX*x); nY++) {
                for (int nZ = 0; nZ*z <= (w-nX*x-nY*y); nZ++) {
                    if (nX*x + nY*y + nZ*z == w) {
                        result++;
                    }
                }
            }
        }
        return result;
    }

    public int numCombinationsOld(int x, int y, int z, int w) {
        // edge cases, include for exhaustiveness, should be filtered out by problem definition
        if (w <= 0 || x < 0 || y < 0 || z < 0) return 0;
        if (x <= 0 && y == 0 && z == 0) return 0;
        int result = 0;
        for (int nX = 0; nX <= 1000; nX++) {
            for (int nY = 0; nY <= 1000; nY++) {
                for (int nZ = 0; nZ <= 1000; nZ++) {
                    if (nX*x + nY*y + nZ*z == w) {
                        result++;
                    }
                }
            }
        }
        return result;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        testSolutionBruteForce1();
        testSolutionBruteForce2();
        testSolutionBruteForce3();
        testSolutionBruteForce4();
        testSolutionBruteForce5();
        testSolutionBruteForce6();
        testSolutionBruteForce7();
        testSolutionBruteForce8();
        testSolutionBruteForce9();
        
        testAllRanges();
        
        testWithConsoleReadWrite();
    }

    public static void testWithConsoleReadWrite() throws IOException {
        int[] input = readInput();
        int x = input[0];
        int y = input[1];
        int z = input[2];
        int w = input[3];
        SolutionBruteForce s = new SolutionBruteForce();
        int output = s.numCombinations(x, y, z, w);
        writeOutput(output);
    }

    private static int[] readInput() throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputStr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
            if (inputStr.length != 4) {
                throw new RuntimeException("Malformed input");
            }
            int[] input = new int[inputStr.length];
            for (int i = 0; i < inputStr.length; i++) {
                input[i] = Integer.valueOf(inputStr[i]);
            }
            return input;
        }
    }

    private static void writeOutput(int output) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bufferedWriter.write(String.valueOf(output));
            bufferedWriter.newLine();
        }
    }

    public static void testSolutionBruteForce1() {
        SolutionBruteForce s = new SolutionBruteForce();
        int output = s.numCombinations(10, 25, 15, 40);
        boolean passed = output == 3;
        System.out.println("testSolutionBruteForce1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionBruteForce2() {
        SolutionBruteForce s = new SolutionBruteForce();
        int output = s.numCombinations(0, 0, 0, 0);
        boolean passed = output == 0;
        System.out.println("testSolutionBruteForce2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionBruteForce3() {
        SolutionBruteForce s = new SolutionBruteForce();
        int output = s.numCombinations(0, 0, 0, 10);
        boolean passed = output == 0;
        System.out.println("testSolutionBruteForce3: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionBruteForce4() {
        SolutionBruteForce s = new SolutionBruteForce();
        int output = s.numCombinations(1, 2, 3, 10);
        boolean passed = output == 14;
        System.out.println("testSolutionBruteForce4: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionBruteForce5() {
        SolutionBruteForce s = new SolutionBruteForce();
        int output = s.numCombinations(1, 1, 1, 3);
        boolean passed = output == 10;
        System.out.println("testSolutionBruteForce5: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionBruteForce6() {
        SolutionBruteForce s = new SolutionBruteForce();
        int output = s.numCombinations(10, 25, 15, 60);
        boolean passed = output == 5;
        System.out.println("testSolutionBruteForce6: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionBruteForce7() {
        SolutionBruteForce s = new SolutionBruteForce();
        long startTime = System.nanoTime();
        int output = s.numCombinations(1, 1, 1, 1000);
        long stopTime = System.nanoTime();
        DecimalFormat df = new DecimalFormat("#");
        df.setMaximumFractionDigits(8);
        System.out.println("Passed time: " + (stopTime - startTime)/1_000/1_000 + " millis"); 
        boolean passed = output == 501501;
        System.out.println("testSolutionBruteForce7: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionBruteForce8() {
        SolutionBruteForce s = new SolutionBruteForce();
        int output = s.numCombinations(1, 0, 0, 1000);
        boolean passed = output == 1;
        System.out.println("testSolutionBruteForce8: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionBruteForce9() {
        SolutionBruteForce s = new SolutionBruteForce();
        int output = s.numCombinations(100, 13, 17, 1000);
        boolean passed = output == 1;
        System.out.println("testSolutionBruteForce9: " + (passed ? "passed" : "failed"));
    }

    public static void testAllRanges() {
        long maxTime = 0;
        int[] maxArgs = null;
        SolutionBruteForce s = new SolutionBruteForce();
        for (int x = 1; x <= 100; x++) {
            for (int y = 1; y <= 100; y++) {
                for (int z = 1; z <= 100; z++) {
                    //for (int w=1; w<=1000; w++) {
                        int w = 1000;
                        long startTime = System.nanoTime();
                        s.numCombinations(x, y, z, w);
                        long endTime = System.nanoTime();
                        if (maxTime < (endTime- startTime)) {
                            maxTime = endTime- startTime;
                            maxArgs = new int[]{x,y,z,w};
                        }
                    //}
                }
            }
        }
        System.out.print("max time = " + maxTime/1_000/1_000 + "millis args: ");
        for (int i = 0; i < maxArgs.length; i++) {
            System.out.print(maxArgs[i] + " ");
        }
        System.out.println("");
    }
}