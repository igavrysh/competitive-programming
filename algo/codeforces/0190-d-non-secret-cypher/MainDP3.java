import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class MainDP3 {
    private long[] a;
    private int k;
    private long n;
    private long output;
    
    public static void main(String[] args) throws IOException {
        /* 
        testSolutionDP3_1();
        testSolutionDP3_2();
        testSolutionDP3_3();
        testSolutionDP3_4();
        */
    
        MainDP3 mainDP = new MainDP3();
        mainDP.readInput();
        mainDP.output = mainDP.numberOfSubarraysWithAtLeastKEqualNums(mainDP.a, mainDP.k);
        mainDP.writeOutput();
    }

    private long numberOfSubarraysWithAtLeastKEqualNums(long[] a, int k) {
        long output = 0;
        HashMap<Long, Integer> FQ = new HashMap<>();
        int prevR = 0;
        Integer maxFQ = 0;
        for (int l = 0; l < a.length; l++) {
            for (int r = Math.max(l, prevR); r < a.length; r++) {
                int newFQ = FQ.getOrDefault(a[r], 0) + 1;
                maxFQ = Math.max(maxFQ, newFQ);
                FQ.put(a[r], newFQ);
                if (maxFQ == k) {
                    output+=a.length-r;
                    FQ.put(a[l], FQ.get(a[l])-1);
                    // process case for k = 1: if k=1, then without condition below fq for diagonal elem will be decreased twice, and invariant 
                    // for hashmap carriover will be invalidated
                    if (l!=r) { FQ.put(a[r], FQ.get(a[r])-1); }
                    maxFQ = FQ.get(a[r]);
                    prevR = r; // with ++ in for cycle l=r on next iteration
                    r = a.length;
                } else if (r==a.length-1) {
                    l=a.length;
                }
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

    private static void testSolutionDP3_1() {
        long[] a = new long[]{1,2,1,2};
        int k = 2;
        MainDP3 s = new MainDP3();
        long output = s.numberOfSubarraysWithAtLeastKEqualNums(a, k);
        boolean passed = output == 3;
        System.out.println("testSolutionDP3_1: " + (passed ? "passed" : "failed"));
    }

    private static void testSolutionDP3_2() {
        long[] a = new long[]{1,2,1,1,3};
        int k = 3;
        MainDP3 s = new MainDP3();
        long output = s.numberOfSubarraysWithAtLeastKEqualNums(a, k);
        boolean passed = output == 2;
        System.out.println("testSolutionDP3_2: " + (passed ? "passed" : "failed"));
    }

    private static void testSolutionDP3_3() {
        long[] a = new long[]{1,1,1};
        int k = 1;
        MainDP3 s = new MainDP3();
        long output = s.numberOfSubarraysWithAtLeastKEqualNums(a, k);
        boolean passed = output == 6;
        System.out.println("testSolutionDP3_3: " + (passed ? "passed" : "failed"));
    }

    private static void testSolutionDP3_4() {
        long[] a = new long[]{6,7,2,4,6,8,4,3,10,5,3,5,7,9,1,2,8,1,9,10};
        int k = 2;
        MainDP3 s = new MainDP3();
        long output = s.numberOfSubarraysWithAtLeastKEqualNums(a, k);
        boolean passed = output == 131;
        System.out.println("testSolutionDP3_4: " + (passed ? "passed" : "failed"));
    }
}
