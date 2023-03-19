import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

class Solution {

    public static class Input {
        public int[] C;
        public int[][] Q;
    }

    public static void main(String[] args) throws IOException {
        test1();
        test2();
        test3();

        Input input = Solution.readInput();
        Solution lvivstar = new Solution(input.C);
        List<Long> output = lvivstar.process(input.Q);
        Solution.writeOutput(output);
    }

    private int[] C;
    private int[][] Q;
    private int n;

    private long[] segsum;
    private int nSeg;
    private int segLen;

    public Solution(int[] C) {
        n = C.length;
        segLen = (int)Math.sqrt(n);
        nSeg = segLen + (segLen*segLen==n ? 0 : 1);
        this.C = new int[n];
        this.segsum = new long[nSeg];
        for (int i = 0; i < n; i++) {
            this.C[i] = C[i];
            this.segsum[i/segLen] += C[i];
        }
    }

    private long getSum(int l, int r) {
        int segsumL = l/segLen + (l%segLen == 0 ? 0 : 1);
        int segsumR = r/segLen + ((r+1)%segLen == 0 ? 0 : -1);
        long acc = 0;
        for (int i = segsumL; i <= segsumR; i++) {
            acc += segsum[i];
        }
        if (segsumL<=segsumR) {
            for (int i = l; i < segsumL*segLen; i++) {
                acc += C[i];
            }
            for (int i = (segsumR+1)*segLen; i <= r; i++) {
                acc += C[i];
            }
        } else {
            for (int i = l; i <= r; i++) {
                acc += C[i];
            }
        }

        return acc;
    }

    private void increment(int i) {
        C[i]++;
        segsum[i/segLen] = segsum[i/segLen]+1;
    }

    private void decrement(int i) {
        if (C[i] < 0) { return; }
        C[i]--;
        segsum[i/segLen] = segsum[i/segLen]-1;
    }

    public static final int COUNT = 1;
    public static final int ENTER = 2;
    public static final int LEAVE = 3;

    public List<Long> process(int[][] Q) {
        List<Long> output = new ArrayList<>();
        for (int i = 0; i < Q.length; i++) {
            if (Q[i][0] == ENTER) {
                this.increment(Q[i][1]-1);
            }
            if (Q[i][0] == LEAVE) {
                this.decrement(Q[i][1]-1);
            }
            if (Q[i][0] == COUNT) {
                output.add(this.getSum(Q[i][1]-1, Q[i][2]-1));
            }
        }
        return output;
    }

    private static String[] readLineNSpaceSeparate(BufferedReader r) throws IOException {
        return r.readLine().replaceAll("\\s+$", "").split(" ");
    }

    private static Input readInput() throws IOException {
        Input input = new Input();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] firstLineStr = readLineNSpaceSeparate(bufferedReader);
            int n = Integer.parseInt(firstLineStr[0]);
            input.C = new int[n];

            String[] secondLineStr = readLineNSpaceSeparate(bufferedReader);
            for (int i = 0; i < secondLineStr.length; i++) {
                input.C[i] = Integer.parseInt(secondLineStr[i]);
            }

            String[] thirdLineStr = readLineNSpaceSeparate(bufferedReader);
            int qLen = Integer.parseInt(thirdLineStr[0]);
            input.Q = new int[qLen][];

            for (int i = 0; i < qLen; i++) {
                String[] nLineStr = readLineNSpaceSeparate(bufferedReader);
                if (nLineStr[0].equals("COUNT")) {
                    int l = Integer.parseInt(nLineStr[1]);
                    int r = Integer.parseInt(nLineStr[2]);
                    input.Q[i] = new int[] {COUNT, l, r};
                } else if (nLineStr[0].equals("ENTER")) {
                    int indx = Integer.parseInt(nLineStr[1]);
                    input.Q[i] = new int[] {ENTER, indx};
                } else if (nLineStr[0].equals("LEAVE")) {
                    int indx = Integer.parseInt(nLineStr[1]);
                    input.Q[i] = new int[] {LEAVE, indx};
                }
            }
        }
        return input;
    }

    private static void writeOutput(List<Long> output) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            for (int i = 0; i < output.size(); i++) {
                String outputStr = String.valueOf(output.get(i)); 
                bufferedWriter.write(outputStr);
                bufferedWriter.newLine();
            }
        }
    }

    private static void test1() {
        int[] C = new int[] {2, 0, 2, 3, 1};
        int[][] Q = {
            { COUNT, 2, 4 }, 
            { ENTER, 2 }, 
            { LEAVE, 1 }, 
            { COUNT, 2, 4 },
            { LEAVE, 5 },
            { COUNT, 4, 5 },
            { COUNT, 1, 2 },
            { ENTER, 2 }, 
            { COUNT, 1, 2 }
        };

        Long [] expectedOutput = {
            5l,
            6l,
            3l,
            2l,
            3l
        };

        Solution lvivstar = new Solution(C);
        List<Long> output = lvivstar.process(Q);
        boolean passed = Arrays.deepEquals(output.toArray(), expectedOutput);
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    private static void test2() {
        int[] C = new int[] {
            1, 1, 1, 1, 1, 
            1, 1, 1, 1, 1,  
            1, 1, 1, 1, 1, 
            1, 1, 1, 1, 1, 
            1, 1, 1, 1, 1, 
            1, 1
        };

        int[][] Q = {
            { COUNT, 2, 4 }, 
            { COUNT, 10, 25 },
            { COUNT, 13, 25 },
            { COUNT, 1, 27 },
            { COUNT, 13, 23 }
        };

        Long[] expectedOutput = new Long[] {
            3l,
            16l,
            13l, 
            27l,
            11l
        };

        Solution lvivstar = new Solution(C);
        boolean passed = true;
        List<Long> output = lvivstar.process(Q);
        for (int i = 0; i < expectedOutput.length; i++) {
            if (output.get(i).compareTo(new Long(expectedOutput[i])) != 0) {
                passed = false;
                break;
            }
        }
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    public static void test3() {
        int maxGenCVal = 1_000_000;
        int genN = 1_000;
        int iterations = 10;
        Random random = new Random();
        boolean testsPassed = true;
        for (int iter = 0; iter < iterations; iter++) {
            int[] genC = new int[genN];
            for (int s = 0; s < genC.length; s++) {
                genC[s] = random.nextInt(maxGenCVal);
            }

            for (int l = 0; l < genN-1; l++) {
                for (int r = l+1; r < genN; r++) {
                    long expctedAcc = 0;
                    for (int i = l; i <= r; i++) {
                        expctedAcc += genC[i];
                    }
                    Solution lv = new Solution(genC);
                    List<Long> output = lv.process(new int[][]{{COUNT, l+1, r+1}});
                    boolean passed = output.get(0) == expctedAcc;
                    if (!passed) {
                        testsPassed = false;
                    }
                }
            }
        }
        System.out.println("test3: " + (testsPassed ? "passed" : "failed"));
    }
}