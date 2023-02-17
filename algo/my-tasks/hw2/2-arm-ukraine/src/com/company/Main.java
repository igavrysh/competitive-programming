package com.company;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class SolutionBruteForce {
    public int numCombinations(int x, int y, int z, int w) {
        int result = 0;
        for (int nX = 0; nX <= 100; nX++) {
            for (int nY = 0; nY <= 100; nY++) {
                for (int nZ = 0; nZ <= 100; nZ++) {
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
}