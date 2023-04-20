import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {

    public static void main(String[] args) throws IOException {
        /*
        testSolution_0();
        testSolution_1();
        testSolution_2();
        testSolution_3();
        */

        Args input = readInput();
        Solution s = new Solution();
        int bobWinCount = s.bobWinCount(input.m, input.n, input.T);
        writeOutput(bobWinCount);
    }

    public static class Args {
        public int m, n;
        public int[] T;
        public Args(int m, int n, int[] T) {
            this.m = m;
            this.n = n;
            this.T = T;
        }
    }

    public int bobWinCount(int m, int n, int[] T) {
        int[] DP = new int[n+1];
        DP[0] = 0;
        int output = 0;
        for (int i = 1; i < DP.length; i++) {
            int dpI = 0;
            for (int j = 0; j < T.length; j++) {
                int stonesLeft = i-T[j];
                if (stonesLeft >= 0 && DP[stonesLeft] == 0) {
                    dpI = 1;
                    break;
                }
            }
            DP[i] = dpI;
            if (i >= m) {
                if (DP[i] == 1) {
                    output++;
                }
            }
        }
        return output;
    }

    private static Args readInput() throws IOException {
        Args args = null;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] firstLine = readLineNSpaceSeparate(br);
            int tCount = Integer.parseInt(firstLine[0]);
            int m = Integer.parseInt(firstLine[1]);
            int n = Integer.parseInt(firstLine[2]);

            String[] nthLine = readLineNSpaceSeparate(br);
            int[] T = new int[tCount];
            for (int i = 0; i < nthLine.length; i++) {
                int tI = Integer.valueOf(nthLine[i]);
                T[i] = tI;
            }
            args = new Args(m, n, T);
        }
        return args;
    }

    private static String[] readLineNSpaceSeparate(BufferedReader r) throws IOException {
        return r.readLine().replaceAll("\\s+$", "").split(" ");
    }

    private static void writeOutput(int output) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String outputStr = String.valueOf(output); 
            bufferedWriter.write(outputStr);
            bufferedWriter.newLine();
        }
    }

    public static void testSolution_0() {
        int m = 1, n = 5;
        int[] T = { 1, 3, 4 };
        Solution s = new Solution();
        int output = s.bobWinCount(m, n, T);
        boolean passed = output == 4;
        System.out.println("testSolution_0: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution_1() {
        int m = 1, n = 100;
        int[] T = { 1 };
        Solution s = new Solution();
        int output = s.bobWinCount(m, n, T);
        boolean passed = output == 50;
        System.out.println("testSolution_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution_2() {
        int m = 1, n = 10;
        int[] T = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        Solution s = new Solution();
        int output = s.bobWinCount(m, n, T);
        boolean passed = output == 10;
        System.out.println("testSolution_2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution_3() {
        int m = 1, n = 8;
        int[] T = { 1, 2, 3 };
        Solution s = new Solution();
        int output = s.bobWinCount(m, n, T);
        boolean passed = output == 6;
        System.out.println("testSolution_3: " + (passed ? "passed" : "failed"));
    }
}
