import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) throws IOException {
        /* 
        testSolution_0();
        testSolution_1();
        testSolution_2();
        testSolution_3();
        testSolution_4();
        */
        Args arguments = readInput();
        Solution s = new Solution();
        int output = s.playgame(arguments.you, arguments.computer);
        writeOutput(output);

    }

    public static class Args {
        public int[] you;
        public int[] computer;

        public Args(int[] you, int[] computer) {
            this.you = you;
            this.computer = computer;
        }
    }

    public int playgame(int[] you, int[] computer) {
        int n = you.length;
        Arrays.sort(you);
        Arrays.sort(computer);
        int r = n-1;
        int l = 0;
        int saved = 0;
        for (int i = n-1; i >= 0; i--) {
            if (computer[i] >= you[r]) {
                l++;
            } else {
                saved += you[r];
                r--;
            }
        }
        return saved;
    }

    private static Args readInput() throws IOException {
        Args args = null;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] firstLine = readLineNSpaceSeparate(br);
            int n = Integer.parseInt(firstLine[0]);

            String[] youLine = readLineNSpaceSeparate(br);
            if (youLine.length != n) {
                throw new RuntimeException("incorrect input, you array size does not match number of players");
            }
            int[] you = new int[n];
            for (int i = 0; i < n; i++) {
                you[i] = Integer.parseInt(youLine[i]);
            }

            String[] computerLine = readLineNSpaceSeparate(br);
            if (computerLine.length != n) {
                throw new RuntimeException("incorrect input, computer array size does not match number of players");
            }
            int[] computer = new int[n];
            for (int i = 0; i < n; i++) {
                computer[i] = Integer.parseInt(computerLine[i]);
            }
            args = new Args(you, computer);
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
        int[] you = { 5, 15, 100, 1, 5 };
        int[] computer = { 5, 15, 100, 1, 5 };
        Solution s = new Solution();
        int saved = s.playgame(you, computer);
        boolean passed = saved == 120;
        System.out.println("testSolution_0: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution_1() {
        int[] you = {
            1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 
            1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 
            1000, 1000, 1000, 1000};
        int[] computer = {
            1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 
            1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000,
            1000, 1000, 1000, 1000};
        Solution s = new Solution();
        int saved = s.playgame(you, computer);
        boolean passed = saved == 0;
        System.out.println("testSolution_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution_2() {
        int[] you = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int[] computer = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
        Solution s = new Solution();
        int saved = s.playgame(you, computer);
        boolean passed = saved == 99;
        System.out.println("testSolution_2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution_3() {
        int[] you = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        int[] computer = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        Solution s = new Solution();
        int saved = s.playgame(you, computer);
        boolean passed = saved == 65;
        System.out.println("testSolution_3: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution_4() {
        int[] you = {651, 321, 106, 503, 227, 290, 915, 549, 660, 115, 491, 378, 495, 789, 507, 381, 685, 530, 603, 394, 7, 704, 101, 620, 859, 490, 744, 495, 379, 781, 
            550, 356, 950, 628, 177, 373, 132, 740, 946, 609, 29, 329, 57, 636, 132, 843, 860, 594, 718, 849};
        int[] computer = {16, 127, 704, 614, 218, 67, 169, 621, 340, 319, 366, 658, 798, 803, 524, 608, 794, 896, 145, 627, 401, 253, 137, 851, 67, 426, 571, 302, 546, 225, 
            311, 111, 804, 135, 284, 784, 890, 786, 740, 612, 360, 852, 228, 859, 229, 249, 540, 979, 55, 82};
        Solution s = new Solution();
        int saved = s.playgame(you, computer);
        boolean passed = saved == 25084;
        System.out.println("testSolution_4: " + (passed ? "passed" : "failed"));
    }
}

