import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class One101001K1 {

    private int N;
    private int[] K;
    private int[] output;

    public static void main(String[] args) throws IOException {
        /* 
        testOne101001K1_2();
        testOne101001K1_1();
        */
        One101001K1 one = new One101001K1();
        one.readInput();
        one.output = one.bitAt(one.N, one.K);
        one.writeOutput();
    }

    private int[] bitAt(int N, int[] K) {
        int[] output = new int[N];
        for (int i = 0; i < N; i++) {
            long k = K[i];
            double pD = (-1+Math.sqrt((double)1+(8*k-1)))/2;
            long p = (long)pD;
            if ((p*(1+p))/2+1 == k) {
                output[i] = 1;
            }
        }
        return output;
    }

    private static void testOne101001K1_2() {
        One101001K1 one = new One101001K1();
        int[] K = new int[]{7};
        int[] output = one.bitAt(K.length, K);
        boolean passed = Arrays.equals(output, new int[]{1});
        System.out.println("testOne101001K1_2: " + (passed ? "passed" : "failed"));
    }

    private static void testOne101001K1_1() {
        One101001K1 one = new One101001K1();
        int[] K = new int[]{3,14,7,6};
        int[] output = one.bitAt(K.length, K);
        boolean passed = Arrays.equals(output, new int[]{0,0,1,0});
        System.out.println("testOne101001K1_1: " + (passed ? "passed" : "failed"));
    }

    private void readInput() throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] firstLineStr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
            N = Integer.parseInt(firstLineStr[0]);
            K = new int[N];
            for (int i=0;i<N;i++) {
                String[] linStr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
                K[i] = Integer.parseInt(linStr[0]);
            }
            
        }
    }

    private void writeOutput() throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            for (int i=0;i<N;i++) {
                bufferedWriter.write(String.valueOf(output[i]));
                if (i<N-1) {
                    bufferedWriter.write(" ");
                }
            }
            bufferedWriter.newLine();
        }
    }
}