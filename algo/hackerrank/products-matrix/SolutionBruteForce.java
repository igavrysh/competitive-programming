import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionBruteForce {

    private static class Args {
        public int n;
        public long k;
        public Args(int n, long k) {
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
        for (int i = 6; i <= 36; i++) {
            testSolution_4_gen(i);
        }
        //testSolution_5();
        
        /* 
        Args nkArgs = readInput();
        Solution solution = new Solution();
        long output = solution.kthElement(nkArgs.n, nkArgs.k);
        writeOutput(output);
        */
    }

    public long kthElement(int n, long k) {
        long[] DP = new long[n+1];
        DP[0] = 0; DP[1] = 1;
        for (int j = 2; j <= n; j++) {
            for (int i = 1; i <= j; i++) {
                long val = ((long)i) * j;
                long valSqrt = (long) Math.sqrt(val);
                int bucket = (int)valSqrt + (valSqrt * valSqrt == val ? 0 : 1);
                DP[bucket]++;
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
        long i = good;
        long upperBound = ((long)good)*good;
        long lowerBound = ((long)good-1)*(good-1);
        boolean movePossible = true;
        arr.add(i*i);
        i--;
        while (movePossible && i>0) {
            movePossible = false;
            long maxJ = Math.min((long)upperBound/i, n);
            for (long j = (long)lowerBound/i; j <= maxJ ; j++) {
                long ij = i * j;
                if (ij > lowerBound && ij <= upperBound) {
                    arr.add(ij);
                    movePossible = true;
                }
            }
            i--;
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

    public static void testSolution_0() {
        int n = 3, k = 7;
        SolutionBruteForce s = new SolutionBruteForce();
        long output = s.kthElement(n, k);
        boolean passed = output == 6;
        System.out.println("testSolution_0: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution_1() {
        int n = 2, k = 4;
        SolutionBruteForce s = new SolutionBruteForce();
        long output = s.kthElement(n, k);
        boolean passed = output == 4;
        System.out.println("testSolution_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution_2() {
        int n = 3, k = 8;
        SolutionBruteForce s = new SolutionBruteForce();
        long output = s.kthElement(n, k);
        boolean passed = output == 6;
        System.out.println("testSolution_2: " + (passed ? "passed" : "failed"));    
    }

    public static void testSolution_3() {
        int n = 1, k = 1;
        SolutionBruteForce s = new SolutionBruteForce();
        long output = s.kthElement(n, k);
        boolean passed = output == 1;
        System.out.println("testSolution_3: " + (passed ? "passed" : "failed"));    
    }

    public static void testSolution_4() {
        int n = 4, k = 4;
        SolutionBruteForce s = new SolutionBruteForce();
        long output = s.kthElement(n, k);
        boolean passed = output == 3;
        System.out.println("testSolution_4: " + (passed ? "passed" : "failed"));    
    }

    public static void testSolution_4abc() {
        int n = 4;
        SolutionBruteForce s = new SolutionBruteForce();
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
        int n = 5;
        SolutionBruteForce s = new SolutionBruteForce();
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
        System.out.println("testSolution_4abcdg: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution_5() {
        int n = 100_000, k = 1_000_000_000;
        SolutionBruteForce s = new SolutionBruteForce();
        long output = s.kthElement(n, k);
        boolean passed = output == 204535821;
        System.out.println("testSolution_5: " + (passed ? "passed" : "failed")); 
    }

    public static void testSolution_4_gen(int n) {
        SolutionBruteForce s = new SolutionBruteForce();

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
                System.out.println("testSolution_4_gen:(" + n + "): " + " k = " + inputK[i] + "; " + (passed ? "passed" : "failed"));
            } else {
                passedCasses++;
            }
        }
        
        boolean passed = passedCasses == output.length;
        System.out.println("testSolution_4_gen (" + n + "): "  + (passed ? "passed" : "failed"));
    }
}