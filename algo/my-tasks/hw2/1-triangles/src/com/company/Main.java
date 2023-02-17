package com.company;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) throws IOException {
        int[][] points = readPoints();
        SolutionON3 s = new SolutionON3();
        double perimeter = s.longestPerimeter(points);
        printResult(perimeter);
    }

    private static int[][] readPoints() throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(bufferedReader.readLine().trim());
            int[][] points = new int[N][2];
            int i = 0;
            while (i < N) {
                String[] pointsStr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
                if (pointsStr.length != 2) {
                    throw new RuntimeException("L "+(i+1)+ " : point should have exactly 2 coordinates");
                }
                points[i] = new int[] {Integer.valueOf(pointsStr[0]), Integer.valueOf(pointsStr[1])};
                i++;
            }
            return points;
        }
    }

    private static void printResult(double result) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String resultStr = BigDecimal.valueOf(result).toPlainString();
            StringBuilder sb = new StringBuilder();
            char[] r = resultStr.toCharArray();
            int counter = 0;
            for (int i = 0; i < r.length; i++) {
                if (counter < 15) {
                    sb.append(r[i]);
                }
                if (r[i] != '.') {
                    counter++;
                }
            }
            bufferedWriter.write(sb.toString());
            bufferedWriter.newLine();
        }
    }
}

