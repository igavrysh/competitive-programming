import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class SolutionDelta {

    private int[] x;
    private int[] v;
    private double output;

    public double meetingPoint(int[] x, int[] v) {
        double badT = 0;
        double goodT = Math.pow(10, 9);

        double guessT, min, max;
        while (goodT-badT > 0.0000001) {
            guessT = badT + (goodT - badT) / 2;
            min = x[0] - v[0] * guessT;
            max = x[0] + v[0] * guessT;
            for (int i = 1; i < x.length; i++) {
                min = Math.max(min, x[i] - v[i] * guessT);
                max = Math.min(max, x[i] + v[i] * guessT);
                if (min > max) {
                    badT = guessT;
                    break;
                }
            }
            if (min<=max) {
                goodT = guessT;
            }
        }

        return goodT;
    }

    public static void main(String[] args) throws IOException {
        /* 
        test1();
        test2();
        */

        SolutionDelta s = new SolutionDelta();
        s.readInput();
        s.output = s.meetingPoint(s.x, s.v);
        s.writeOutput();
    }

    public static void test2() {
        SolutionDelta s = new SolutionDelta();
        double output = s.meetingPoint(new int[]{ 5, 10, 3, 2 }, new int[]{ 2, 3, 2, 4 });
        double expectedOutput = 1.4;
        boolean passed = Math.abs(output - expectedOutput) / Math.max(1, expectedOutput) < 0.000001;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test1() {
        SolutionDelta s = new SolutionDelta();
        double output = s.meetingPoint(new int[]{ 7, 1, 3 }, new int[]{ 1,2,1 });
        double expectedOutput = 2.0;
        boolean passed = Math.abs(output - expectedOutput) / Math.max(1, expectedOutput) < 0.000001;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    void readInput() throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] firstLineStr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
            int n = Integer.parseInt(firstLineStr[0]);
            x = new int[n];
            v = new int[n];
            String[] xStr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
            for (int i = 0; i < n; i++) {
                x[i] = Integer.valueOf(xStr[i]);
            }
            String[] vStr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
            for (int i = 0; i < n; i++) {
                v[i] = Integer.valueOf(vStr[i]);
            }
        }
    }

    void writeOutput() throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String outputStr = String.valueOf(output); 
            bufferedWriter.write(outputStr);
            bufferedWriter.newLine();
        }
    }
}