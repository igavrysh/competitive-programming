import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {

    static class Args {
        public int[][] S;
        public int[] c;
        public Args(int[][] S, int[] c) { 
            this.S = S;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        /*
        testSolution_0();
        testSolution_1();
        testSolution_2();
        */
        Args input = readInput();
        Solution solution = new Solution();
        int maxRows = solution.maxRows(input.S, input.c);
        writeOutput(maxRows);
    }

    // S[k][0] - num of 0s in k-th str, fq[k][1] - num of 1s k-th str
    // c[0] - initial number of 0s, c[1] - initial numbe r of 1s
    public int maxRows(int[][] S, int[] c) {
        int[][] l = new int[c[0]+1][c[1]+1];
        for (int k = 0; k < S.length; k++) {
            int[][] newL = new int[c[0]+1][c[1]+1];
            for (int i = 0; i < newL.length; i++) {
                for (int j = 0; j < newL[0].length; j++) {
                    if (i == 0 && j == 0) {
                        // cannot take row k with zero 0s and zero 1s in pocket
                        newL[0][0] = 0;
                        continue;
                    }
                    // if kth row is taken, what is max rows output?
                    int rowsIfKthTaken = 0;
                    if (S[k][0] <= i && S[k][1] <= j) {
                        rowsIfKthTaken = 1 + l[i-S[k][0]][j-S[k][1]];
                    }
                    // if kth row is not taken, what is max rows output?
                    int rowsIfKthNotTaken = l[i][j];
                    // record best decision
                    newL[i][j] = Math.max(rowsIfKthTaken, rowsIfKthNotTaken);
                }
            }
            l = newL;
        }
        return l[c[0]][c[1]];
    }

    private static Args readInput() throws IOException {
        Args args = null;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] firstLine = readLineNSpaceSeparate(br);
            int n = Integer.parseInt(firstLine[0]);
            int cZeros = Integer.parseInt(firstLine[1]);
            int cOnes = Integer.parseInt(firstLine[2]);

            int[] c = {cZeros, cOnes };

            int[][] S = new int[n][2];
            for (int i = 0; i < n; i++) {
                String[] nthLine = readLineNSpaceSeparate(br);
                char[] bits = nthLine[0].toCharArray();
                int zeros = 0, ones = 0;
                for (int j = 0; j < bits.length; j++) {
                    if (bits[j] == '0') {
                        zeros++;
                    } else if (bits[j] == '1') {
                        ones++;
                    }
                }
                S[i] = new int[] { zeros, ones };
            }
            args = new Args(S, c);
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
        int[][] S = {{0, 1}, {2, 0}, {2, 1}};
        int[] c = {3, 1};
        Solution solution = new Solution();
        int output = solution.maxRows(S, c);
        boolean passed = output == 2;
        System.out.println("testSolution_0: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution_1() {
        int[][] S = {{2, 0}, {1, 2}, {1, 2}};
        int[] c = {2, 4};
        Solution solution = new Solution();
        int output = solution.maxRows(S, c);
        boolean passed = output == 2;
        System.out.println("testSolution_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution_2() {
        int[][] S = new int[20][50];
        for (int i = 0; i < S.length; i++) {
            S[i] = new int[] { 25, 25 };
        }
        int[] c = {500, 500};
        Solution solution = new Solution();
        int output = solution.maxRows(S, c);
        boolean passed = output == 20;
        System.out.println("testSolution_2: " + (passed ? "passed" : "failed"));
    }
}