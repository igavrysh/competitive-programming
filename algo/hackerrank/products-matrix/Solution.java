import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution {

    private static class Args {
        public int n;
        public long k;
        public Args(int n, long k) {
            this.n = n;
            this.k = k;
        }
    }

    public static void main(String[] args) throws IOException {
        /*
        testSolutionBS_0();
        testSolutionBS_1();
        testSolutionBS_2();
        testSolutionBS_3();
        testSolutionBS_4();
        testSolutionBS_4abc();
        testSolutionBS_4abcd();
        for (int i = 6; i <= 36; i++) {
            testSolutionBS_4_gen(i);
        }
        testSolutionBS_5();
        */
        
        Args nkArgs = readInput();
        Solution solution = new Solution();
        long output = solution.kthElement(nkArgs.n, nkArgs.k);
        writeOutput(output);    
    }

    private boolean isEnough(long val, int n, long k) {
        long accK = 0;
        for (int i = n; i >= 1; i--) {
            accK += Math.min(val/i, n);
            if (accK >= k) { return true; }
        }
        return false;
    }

    public long kthElement(int n, long k) {    
        long bad = 0, good = (long)n*n+1;
        while (good-bad>1) {
            long m = bad+(good-bad)/2;
            if (isEnough(m, n, k)) {
                good = m;
            } else {
                bad = m;
            }
        }
        return good;
    }

    private static Args readInput() throws IOException {
        Args args = null;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] firstLine = readLineNSpaceSeparate(br);
            int n = Integer.parseInt(firstLine[0]);
            long k = Long.parseLong(firstLine[1]);
            args = new Args(n, k);
        }
        return args;
    }

    private static String[] readLineNSpaceSeparate(BufferedReader r) throws IOException {
        return r.readLine().replaceAll("\\s+$", "").split(" ");
    }

    private static void writeOutput(long output) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String outputStr = String.valueOf(output); 
            bufferedWriter.write(outputStr);
            bufferedWriter.newLine();
        }
    }

    public static void testSolutionBS_0() {
        int n = 3, k = 7;
        Solution s = new Solution();
        long output = s.kthElement(n, k);
        boolean passed = output == 6;
        System.out.println("testSolutionBS_0: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionBS_1() {
        int n = 2, k = 4;
        Solution s = new Solution();
        long output = s.kthElement(n, k);
        boolean passed = output == 4;
        System.out.println("testSolutionBS_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionBS_2() {
        int n = 3, k = 8;
        Solution s = new Solution();
        long output = s.kthElement(n, k);
        boolean passed = output == 6;
        System.out.println("testSolutionBS_2: " + (passed ? "passed" : "failed"));    
    }

    public static void testSolutionBS_3() {
        int n = 1, k = 1;
        Solution s = new Solution();
        long output = s.kthElement(n, k);
        boolean passed = output == 1;
        System.out.println("testSolutionBS_3: " + (passed ? "passed" : "failed"));    
    }

    public static void testSolutionBS_4() {
        int n = 4, k = 4;
        Solution s = new Solution();
        long output = s.kthElement(n, k);
        boolean passed = output == 3;
        System.out.println("testSolutionBS_4: " + (passed ? "passed" : "failed"));    
    }

    public static void testSolutionBS_4abc() {
        int n = 4;
        Solution s = new Solution();
        int[] inputK = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
        long[] output = {1,2,2,3,3,4,4,4,6, 6, 8, 8, 9,12,12,16};
        int passedCasses = 0;
        for (int i = 0; i < inputK.length; i++) {
            long outputI = s.kthElement(n, inputK[i]);
            boolean passed = outputI == output[i];
            if (!passed) {
                System.out.println("testSolutionBS_4abc: k = " + inputK[i] + "; " + (passed ? "passed" : "failed"));
            } else {
                passedCasses++;
            }
        }
        
        boolean passed = passedCasses == output.length;
        System.out.println("testSolutionBS_4abc: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionBS_4abcd() {
        int n = 5;
        Solution s = new Solution();
        int[] inputK =  {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
        long[] output = {1,2,2,3,3,4,4,4,5, 5, 6, 6, 8, 8, 9,10,10,12,12,15,15,16,20,20,25};
        int passedCasses = 0;
        for (int i = 0; i < inputK.length; i++) {
            if (inputK[i] == 20) {
                int t = 1;
            }
            long outputI = s.kthElement(n, inputK[i]);
            boolean passed = outputI == output[i];
            if (!passed) {
                System.out.println("testSolution_4abcd: k = " + inputK[i] + "; " + (passed ? "passed" : "failed"));
            } else {
                passedCasses++;
            }
        }
        
        boolean passed = passedCasses == output.length;
        System.out.println("testSolutionBS_4abcdg: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionBS_5() {
        int n = 100_000, k = 1_000_000_000;
        Solution s = new Solution();
        long output = s.kthElement(n, k);
        boolean passed = output == 204535821;
        System.out.println("testSolutionBS_5: " + (passed ? "passed" : "failed")); 
    }

    public static void testSolutionBS_4_gen(int n) {
        Solution s = new Solution();

        int[] inputK = new int[n*n];
        for (int i = 0; i < inputK.length; i++) {
            inputK[i] = i+1;
        }

        long[] output = new long[n*n];
        int idx=0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                output[idx++] = i*j;
            }
        }

        Arrays.sort(output);

        int passedCasses = 0;

        for (int i = 0; i < inputK.length; i++) {
            if (inputK[i] == 15) {
                int t = 1;
            }
            long outputI = s.kthElement(n, inputK[i]);
            boolean passed = outputI == output[i];
            if (!passed) {
                System.out.println("testSolutionBS_4_gen:(" + n + "): " + " k = " + inputK[i] + "; " + (passed ? "passed" : "failed"));
            } else {
                passedCasses++;
            }
        }
        
        boolean passed = passedCasses == output.length;
        System.out.println("testSolutionBS_4_gen (" + n + "): "  + (passed ? "passed" : "failed"));
    }
}