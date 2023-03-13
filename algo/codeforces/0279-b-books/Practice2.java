import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Practice2 {
    public static void main(String[] args) throws IOException {
        /* 
        test1();
        test2();
        test3();
        test4();
        */
        readInput();
        output = maxBooks(a, sum);
        writeOutput();
    }

    private static int maxBooks(int[] a, int t) {
        int currTime = 0;
        int l = 0;
        int n = a.length;
        int maxBooks = 0;
        for (int r = 0; r < n; r++) {
            currTime += a[r];
            while (currTime > t && l <= r) {
                currTime -= a[l];
                l++;
            }
            maxBooks = Math.max(maxBooks, r-l+1);
        }
        return maxBooks;
    }

    private static int[] a;
    private static int sum;
    private static int output;

    private static void readInput() throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] firstLineStr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
            int n = Integer.parseInt(firstLineStr[0]);
            sum = Integer.parseInt(firstLineStr[1]);
            String[] aStr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
            a = new int[aStr.length];
            for (int i = 0; i < a.length; i++) {
                a[i] = Integer.parseInt(aStr[i]);
            }
        }
    }

    private static void writeOutput() throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String outputStr = String.valueOf(output); 
            bufferedWriter.write(outputStr);
            bufferedWriter.newLine();
        }
    }

    private static void test1() {
        int output = maxBooks(new int[]{3,1,2,1}, 5);
        boolean passed = output == 3;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    private static void test2() {
        int output = maxBooks(new int[]{2,2,3}, 3);
        boolean passed = output == 1;
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    private static void test3() {
        int output = maxBooks(new int[]{5,4,3,2,1}, 1);
        boolean passed = output == 1;
        System.out.println("test3: " + (passed ? "passed" : "failed"));
    }

    private static void test4() {
        int output = maxBooks(new int[]{5}, 3);
        boolean passed = output == 0;
        System.out.println("test4: " + (passed ? "passed" : "failed"));
    }
}
