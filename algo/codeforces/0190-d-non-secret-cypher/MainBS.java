import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;

public class MainBS {
    private long[] a;
    private int k;
    private long n;
    private long output;

    public static void main(String[] args) throws IOException {
        //testSolutionBS1();
        //testSolutionBS2();
        MainBS main = new MainBS();
        main.readInput();
        main.output = main.numberOfSubarraysWithAtLeastKEqualNums(main.a, main.k);
        main.writeOutput();
    }

    private long numberOfSubarraysWithAtLeastKEqualNums(long[] a, int k) {
        int low = k-1;
        int high = a.length;
        while (high-low>1) {
            int m = low+(high-low)/2;
            long subsqs = numberOfSubarraysWithLen(m, a, k);
            if (subsqs > 0) {
                high = m;
            } else {
                low = m;
            }
        }
        long output = 0;
        for (int i = high; i <= a.length; i++) {
            output += numberOfSubarraysWithLen(i, a, k);
        }
        return output;
    }

    private long numberOfSubarraysWithLen(int length, long[] a, int k) {
        HashMap<Long, Integer> M = new HashMap<>();
        HashSet<Long> kOrMoreFq = new HashSet<>();
        long output = 0;
        for (int end = 0; end < a.length; end++) {
            M.put(a[end], M.getOrDefault(a[end], 0) + 1);
            if (end-length>=0) {
                M.put(a[end-length], M.get(a[end-length]) - 1);
            }

            if (M.get(a[end]) >= k) {
                kOrMoreFq.add(a[end]);
            }
            if (end-length>=0 && M.get(a[end-length]) < k) {
                kOrMoreFq.remove(a[end-length]);
            }

            if (end+1-length>=0 && kOrMoreFq.size() > 0) {
                output++;
            }
        }
        return output;
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

    private static void testSolutionBS1() {
        long[] a = new long[]{1,2,1,2};
        int k = 2;
        MainBS s = new MainBS();
        long output = s.numberOfSubarraysWithAtLeastKEqualNums(a, k);
        boolean passed = output == 3;
        System.out.println("testSolutionBS1: " + (passed ? "passed" : "failed"));
    }

    private static void testSolutionBS2() {
        long[] a = new long[]{1,2,1,1,3};
        int k = 3;
        MainBS s = new MainBS();
        long output = s.numberOfSubarraysWithAtLeastKEqualNums(a, k);
        boolean passed = output == 2;
        System.out.println("testSolutionBS2: " + (passed ? "passed" : "failed"));
    }
}
