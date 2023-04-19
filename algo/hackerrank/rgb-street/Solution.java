import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {

    public static void main(String[] args) throws IOException {
        int[][] input = readInput();
        Solution s = new Solution();
        int output = s.cost(input);
        writeOutput(output);

        /* 
        test1();
        test2();
        test3();
        test4();
        */
    }

    public int cost(int[][] rgb) {
        int[] DP = new int[] { rgb[0][0], rgb[0][1], rgb[0][2]};
        int[] tmpDP = new int[3];
        for (int i = 1; i < rgb.length; i++) {
            tmpDP[0] = rgb[i][0] + Math.min(DP[1], DP[2]);
            tmpDP[1] = rgb[i][1] + Math.min(DP[0], DP[2]);
            tmpDP[2] = rgb[i][2] + Math.min(DP[0], DP[1]);
            DP[0] = tmpDP[0];
            DP[1] = tmpDP[1];
            DP[2] = tmpDP[2];
        }
        return Math.min(DP[0], Math.min(DP[1], DP[2]));
    }

    private static int[][] readInput() throws IOException {
        int[][] input = null;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] firstLine = readLineNSpaceSeparate(br);
            int n = Integer.parseInt(firstLine[0]);
            input = new int[n][3];
            for (int i = 0; i < n; i++) {
                String[] nthLine = readLineNSpaceSeparate(br);
                int[] nums = new int[3];
                for (int j = 0; j < nums.length; j++) {
                    nums[j] = Integer.parseInt(nthLine[j]);
                }
                input[i] = nums;
            }
        }
        return input;
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

    public static void test1() {
        int[][] cost = {
            { 1, 100, 100 },
            { 100, 1, 100 },
            { 100, 100, 1 }
        };
        Solution s = new Solution();
        int output = s.cost(cost);
        boolean passed = output == 3;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        int[][] cost = {
            { 26, 40, 83 },
            { 49, 60, 57 },
            { 13, 89, 99 }
        };
        Solution s = new Solution();
        int output = s.cost(cost);
        boolean passed = output == 96;
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    public static void test3() {
        int[][] cost = {
            { 30, 19, 5 },
            { 64, 77, 64 },
            { 15, 19, 97 },
            { 4, 71, 57 },
            { 90, 86, 84 },
            { 93, 32, 91 }
        };
        Solution s = new Solution();
        int output = s.cost(cost);
        boolean passed = output == 208;
        System.out.println("test3: " + (passed ? "passed" : "failed"));
    }

    public static void test4() {
        int[][] cost = {
            { 71, 39, 44 },
            { 32, 83, 55 },
            { 51, 37, 63 },
            { 89, 29, 100 },
            { 83, 58, 11 },
            { 65, 13, 15 },
            { 47, 25, 29 },
            { 60, 66, 19 }
        };
        Solution s = new Solution();
        int output = s.cost(cost);
        boolean passed = output == 253;
        System.out.println("test4: " + (passed ? "passed" : "failed"));
    }
}