import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    private static int d;
    // pairs[i,0] - money of friend i; pairs[i,1] - friendship factor for friend i
    private static int[][] pairs;

    private static long output;

    public static void main(String[] args) throws IOException {
        //test1();
        //test2();
        //test3();
        //test4();
        readInput();
        output = maxFriendshipFactor(pairs, d);
        writeOutput();
    }

    private static void readInput() throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] firstLineStr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
            int n = Integer.parseInt(firstLineStr[0]);
            d = Integer.parseInt(firstLineStr[1]);
            int i = 0;
            pairs = new int[n][];
            while (i<n) {
                pairs[i] = new int[2];
                String[] aStr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
                pairs[i][0] = Integer.valueOf(aStr[0]);
                pairs[i][1] = Integer.valueOf(aStr[1]);
                i++;
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

    private static long maxFriendshipFactor(int[][] pairs, int d) {
        Arrays.sort(pairs, (p1, p2)-> p1[0]-p2[0]);
        int N = pairs.length;
        int l = 0, r = 0;
        long currFactor = pairs[0][1];
        long output = 0;
        while (r < N) {
            if (pairs[r][0]-pairs[l][0]<d || l==r) {
                if (pairs[r][0]-pairs[l][0]<d) {
                    output = Math.max(output, currFactor);
                }
                r++;
                if (r<N) {
                    currFactor += pairs[r][1];
                }
            } else {
                currFactor-= pairs[l][1];
                l++;
            }
        }
        return output;
    }

    private static void test1() {
        int[][] friends = new int[][]{{75,5},{0,100},{150,20},{75,1}};
        int d = 5;
        long output = maxFriendshipFactor(friends, d);
        boolean passed = output == 100;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    private static void test2() {
        int[][] friends = new int[][]{{0,7},{11,32},{99,10},{46,8},{87,54}};
        int d = 100;
        long output = maxFriendshipFactor(friends, d);
        boolean passed = output == 111;
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    private static void test3() {
        int[][] friends = new int[][]{{0,7},{11,32},{99,10},{46,8},{87,54}};
        int d = 2;
        long output = maxFriendshipFactor(friends, d);
        boolean passed = output == 54;
        System.out.println("test3: " + (passed ? "passed" : "failed"));
    }

    private static void test4() {
        int[][] friends = new int[][]{{0,98},{2,1000000000},{8,1000000000},{5,999999999},{3,989898989}};
        int d = 9;
        long output = maxFriendshipFactor(friends, d);
        boolean passed = output == 3989899086l;
        System.out.println("test3: " + (passed ? "passed" : "failed"));
    }
}