import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {

    private int[][] c;
    private int[] m;
    private int n;

    int[][] output;

    private int[][] findFlavours(int[][] c, int[]m) {
        int[][] output = new int[c.length][2];
        for (int i = 0; i < c.length; i++) {
            HashMap<Integer, Integer> M = new HashMap<>();
            int[] cost = c[i];
            for (int j = 0; j < cost.length; j++) {
                int delta = m[i]-cost[j];
                if (M.get(delta) != null) {
                    output[i] = new int[]{M.get(delta)+1, j+1};
                    j = cost.length;   
                } else {
                    M.put(cost[j], j);
                }
            }
        }
        return output;
    }

    public static void main(String[] args) throws IOException {
        //testSolution1();
        Solution s = new Solution();
        s.readInput();
        s.output = s.findFlavours(s.c, s.m);
        s.writeOutput();
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }

    private void readInput() throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] firstLineStr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
            n = Integer.parseInt(firstLineStr[0]);
            c = new int[n][];
            m = new int[n];
            for (int i = 0; i < n; i++) {
                m[i] = Integer.parseInt(bufferedReader.readLine());
                int currLenth = Integer.parseInt(bufferedReader.readLine());
                c[i] = new int[currLenth];
                String[] cStr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
                for (int j = 0; j < currLenth; j++) {
                    c[i][j] = Integer.parseInt(cStr[j]);
                }
            }
        }
    }

    private void writeOutput() throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            for (int i = 0; i < output.length; i++) {
                String outputStr = String.valueOf(output[i][0]) + " " + String.valueOf(output[i][1]);
                bufferedWriter.write(outputStr);
                bufferedWriter.newLine();
            }
        }
    }

    private static void testSolution1() {
        int[][] c = new int[][]{{1,4,5,3,2},{2,2,4,3}};
        int[] m = new int[]{4,4};
        Solution s = new Solution();
        int[][] output = s.findFlavours(c, m);
        boolean passed = Arrays.equals(output[0], new int[]{1,4}) && Arrays.equals(output[1], new int[]{1,2});
        System.out.println("testSolution1: " + (passed ? "passed" : "failed"));
    }


}