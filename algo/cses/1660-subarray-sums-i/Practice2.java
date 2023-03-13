import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Practice2 {

    private static int n;
    private static int sum;
    private static int[] a;
    private static int output = -1;

    public static void main(String[] args) throws IOException {
        readInput();
        output = subarrays(a, sum);
        printOutput();
    }

    private static int subarrays(int[] a, int sum) {
        int n = a.length;
        int counter = 0;
        int currSum = 0;
        int l = 0;
        for (int r  = 0; r < n; r++) {
            currSum += a[r];
            while (currSum > sum && l<r) {
                currSum-=a[l];
                l++;
            }

            if (currSum == sum) {
                counter++;
            }
        }
        return counter;
    }

    private static void readInput() throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] firstLineStr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
            n = Integer.parseInt(firstLineStr[0]);
            sum = Integer.parseInt(firstLineStr[1]);
            String[] aStr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
            a = new int[aStr.length];
            for (int i = 0; i < a.length; i++) {
                a[i] = Integer.parseInt(aStr[i]);
            }
        }
    }

    private static void printOutput() throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String outputStr = String.valueOf(output); 
            bufferedWriter.write(outputStr);
            bufferedWriter.newLine();
        }
    }

    private static void test1() {
        int output = subarrays(new int[]{2,4,1,2,7}, 7);
        boolean passed = output == 3;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }
}
