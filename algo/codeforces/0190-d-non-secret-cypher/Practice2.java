import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class Practice2 {
    private static long numberOfSubarraysWithAtLeastKEqualNums(long[] a, int k) {
        int n = a.length;
        HashMap<Long, Integer> FQ = new HashMap<>();
        long output = 0;
        int l = 0;
        for (int r = 0; r < n; r++) {
            long aR = a[r];
            FQ.put(aR, FQ.getOrDefault(aR, 0) + 1);
            while (FQ.get(aR) == k && l <= r) {
                output += n-r;
                long aL = a[l];
                FQ.put(aL, FQ.getOrDefault(aL, 0) - 1);
                l++;
            }
        }
        return output;
    }

    public static void main(String[] args) throws IOException {
        /* 
        test1();
        test2();
        test3();
        test4();
        */

        Practice2 s = new Practice2();
        s.readInput();
        s.output = numberOfSubarraysWithAtLeastKEqualNums(s.a, s.k);
        s.writeOutput();
    }

    private void readInput() throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] firstLineStr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
            int n = Integer.parseInt(firstLineStr[0]);
            k = Integer.parseInt(firstLineStr[1]);
            String[] aStr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
            a = new long[aStr.length];
            for (int i = 0; i < a.length; i++) {
                a[i] = Long.parseLong(aStr[i]);
            }
        }
    }

    private void writeOutput() throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String outputStr = String.valueOf(output); 
            bufferedWriter.write(outputStr);
            bufferedWriter.newLine();
        }
    }

    private long[] a;
    private int k;
    private long n;
    private long output;

    private static void test1() {
        long[] a = new long[]{1,2,1,2};
        int k = 2;
        long output = numberOfSubarraysWithAtLeastKEqualNums(a, k);
        boolean passed = output == 3;
        System.out.println("testSolutionDP3_1: " + (passed ? "passed" : "failed"));
    }

    private static void test2() {
        long[] a = new long[]{1,2,1,1,3};
        int k = 3;
        long output = numberOfSubarraysWithAtLeastKEqualNums(a, k);
        boolean passed = output == 2;
        System.out.println("testSolutionDP3_2: " + (passed ? "passed" : "failed"));
    }

    private static void test3() {
        long[] a = new long[]{1,1,1};
        int k = 1;
        long output = numberOfSubarraysWithAtLeastKEqualNums(a, k);
        boolean passed = output == 6;
        System.out.println("testSolutionDP3_3: " + (passed ? "passed" : "failed"));
    }

    private static void test4() {
        long[] a = new long[]{6,7,2,4,6,8,4,3,10,5,3,5,7,9,1,2,8,1,9,10};
        int k = 2;
        long output = numberOfSubarraysWithAtLeastKEqualNums(a, k);
        boolean passed = output == 131;
        System.out.println("testSolutionDP3_4: " + (passed ? "passed" : "failed"));
    }

}
