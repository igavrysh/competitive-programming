import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class MainDP2 {

    private long[] a;
    private int k;
    private long n;
    private long output;
    
    public static void main(String[] args) throws IOException {
        
        //testSolutionDP2_1();
        //testSolutionDP2_2();
        //testSolutionDP2_3();
        
        MainDP2 mainDP = new MainDP2();
        mainDP.readInput();
        mainDP.output = mainDP.numberOfSubarraysWithAtLeastKEqualNums(mainDP.a, mainDP.k);
        mainDP.writeOutput();
    }

    private long numberOfSubarraysWithAtLeastKEqualNums(long[] a, int k) {
        long output = 0;
        for (int l = 0; l < a.length; l++) {
            HashMap<Long, Integer> FQ = new HashMap<>();
            Integer maxFQ = 0;
            for (int r = l; r < a.length; r++) {
                int newFQ = FQ.getOrDefault(a[r], 0) + 1;
                maxFQ = Math.max(maxFQ, newFQ);
                FQ.put(a[r], newFQ);
                if (maxFQ == k) {
                    output+=a.length-r;
                    r = a.length;
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

    private static void testSolutionDP2_1() {
        long[] a = new long[]{1,2,1,2};
        int k = 2;
        MainDP2 s = new MainDP2();
        long output = s.numberOfSubarraysWithAtLeastKEqualNums(a, k);
        boolean passed = output == 3;
        System.out.println("testSolutionDP2_1: " + (passed ? "passed" : "failed"));
    }

    private static void testSolutionDP2_2() {
        long[] a = new long[]{1,2,1,1,3};
        int k = 3;
        MainDP2 s = new MainDP2();
        long output = s.numberOfSubarraysWithAtLeastKEqualNums(a, k);
        boolean passed = output == 2;
        System.out.println("testSolutionDP2_2: " + (passed ? "passed" : "failed"));
    }

    private static void testSolutionDP2_3() {
        long[] a = new long[]{1,1,1};
        int k = 1;
        MainDP2 s = new MainDP2();
        long output = s.numberOfSubarraysWithAtLeastKEqualNums(a, k);
        boolean passed = output == 6;
        System.out.println("testSolutionDP2_3: " + (passed ? "passed" : "failed"));
    }
}

/* 
1212
l:0r:0 "1"

l:0r:1 "12"

l:1r:1 "2"   l:0r:2 "121"

l:1r:2 "21"  l:1:r:2: "21"
*/

