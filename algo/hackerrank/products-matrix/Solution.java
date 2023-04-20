import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    private static class Args {
        public int n;
        public int k;
        public Args(int n, int k) {
            this.n = n;
            this.k = k;
        }
    }

    public static void main(String[] args) throws IOException {
        
        testSolution_0();
        testSolution_1();
        testSolution_2();
        testSolution_3();
        testSolution_4();
        testSolution_4abc();
        testSolution_4abcd();
    
        //testSolution_5();

        /* 
        Args nkArgs = readInput();
        Solution solution = new Solution();
        int output = solution.kthElement(nkArgs.n, nkArgs.k);
        writeOutput(output);
        */
    }

    public long kthElement(int n, long k) {
        long[] DP = new long[n+1];
        DP[0] = 0; DP[1] = 1;
        int startI = 1;
        for (int j = 2; j <= n; j++) {
            for (int i = 1; i <= j; i++) {
                startI = (int)Math.sqrt((long)i*j);
                if (i*j<=(startI*startI)) {
                    DP[startI]++;
                } else {
                    DP[startI+1]++;
                }
            }
        }

        long[] accDP = new long[n+1];
        accDP[0] = 0;
        for (int i = 1; i < accDP.length; i++) {
            accDP[i] = accDP[i-1] + (2*DP[i]-1);
        }

        
        int bad = 0, good = n+1;
        while (good-bad>1) {
            int m = bad+(good-bad)/2;
            if (accDP[m] >= k) {
                good = m;
            } else {
                bad = m;
            }
        }

        List<Long> arr = new ArrayList<>(); 
        long j = good;
        //long i = good;
        for (long i = good; i <= n; i++) {
        //while (true) {
            
            boolean addeded = false;
            long upperBound = ((long)good)*good;
            long lowerBound = ((long)good-1) *(good-1);

            long i_j = i*j;
            if (i_j <= upperBound && i_j > lowerBound) {
               arr.add(i_j);
               addeded = true;
            }


            long i_j_1 = i*(j-1);
            if (j>1 && i_j_1 <= upperBound && i_j_1 > lowerBound) {
                arr.add(i_j_1);
                j--;
                addeded = true;
            }

            if (!addeded) {
                break;
            }

            //i++;
        }

        arr.sort((i1, i2) -> i1 == i2 ? 0 : (i1 > i2 ? 1 : -1));

        int incrK = (int)(k - accDP[good-1]);

        return arr.get((incrK-1)/2);
    }

    private static Args readInput() throws IOException {
        Args args = null;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] firstLine = readLineNSpaceSeparate(br);
            int n = Integer.parseInt(firstLine[0]);
            int k = Integer.parseInt(firstLine[1]);
            args = new Args(n, k);
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
        int n = 3, k = 7;
        Solution s = new Solution();
        long output = s.kthElement(n, k);
        boolean passed = output == 6;
        System.out.println("testSolution_0: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution_1() {
        int n = 2, k = 4;
        Solution s = new Solution();
        long output = s.kthElement(n, k);
        boolean passed = output == 4;
        System.out.println("testSolution_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution_2() {
        int n = 3, k = 8;
        Solution s = new Solution();
        long output = s.kthElement(n, k);
        boolean passed = output == 6;
        System.out.println("testSolution_2: " + (passed ? "passed" : "failed"));    
    }

    public static void testSolution_3() {
        int n = 1, k = 1;
        Solution s = new Solution();
        long output = s.kthElement(n, k);
        boolean passed = output == 1;
        System.out.println("testSolution_3: " + (passed ? "passed" : "failed"));    
    }

    public static void testSolution_4() {
        int n = 4, k = 4;
        Solution s = new Solution();
        long output = s.kthElement(n, k);
        boolean passed = output == 3;
        System.out.println("testSolution_4: " + (passed ? "passed" : "failed"));    
    }

    public static void testSolution_4abc() {
        int n = 4;
        Solution s = new Solution();
        int[] inputK = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
        long[] output = {1,2,2,3,3,4,4,4,6, 6, 8, 8, 9,12,12,16};
        int passedCasses = 0;
        for (int i = 0; i < inputK.length; i++) {
            long outputI = s.kthElement(n, inputK[i]);
            boolean passed = outputI == output[i];
            if (!passed) {
                System.out.println("testSolution_4abc: k = " + inputK[i] + "; " + (passed ? "passed" : "failed"));
            } else {
                passedCasses++;
            }
        }
        
        boolean passed = passedCasses == output.length;
        System.out.println("testSolution_4abc: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution_4abcd() {
        int n = 6;
        Solution s = new Solution();
        int[] inputK =  {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
        long[] output = {1,2,2,3,3,4,4,4,5, 5, 6, 6, 8, 8, 9,10,10,12,12,15,15,16,20,20,25};
        int passedCasses = 0;
        for (int i = 0; i < inputK.length; i++) {
            long outputI = s.kthElement(n, inputK[i]);
            boolean passed = outputI == output[i];
            if (!passed) {
                System.out.println("testSolution_4abcd: k = " + inputK[i] + "; " + (passed ? "passed" : "failed"));
            } else {
                passedCasses++;
            }
        }
        
        boolean passed = passedCasses == output.length;
        System.out.println("testSolution_4abcdg: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution_5() {
        int n = 100_000, k = 1_000_000_000;
        Solution s = new Solution();
        long output = s.kthElement(n, k);
        boolean passed = output == 3;
        System.out.println("testSolution_5: " + (passed ? "passed" : "failed")); 

    }
}