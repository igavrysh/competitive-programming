import java.util.Arrays;

public class SolutionGreedy {

    public long getSecondsRequired(long N, int F, long[] P) {
        Arrays.sort(P);
        int trainSize = 1;
        long trainHead = P[0];
        long time = 0;
        for (int i = 1; i < P.length; i++) {
            time += P[i]-1 - trainHead;
            trainHead = P[i];
            trainSize++;
        }
        time += N-1 - trainHead;
        time += trainSize;
        return time;
    }

    public static void main(String[] args) {
        test1();
        test2();
    }

    public static void test1() {
        long N = 3;
        int F = 1;
        long[] P = {1L};
        long expectedOutput = 2;
        SolutionGreedy s = new SolutionGreedy();
        long output = s.getSecondsRequired(N, F, P);
        boolean passed = output == expectedOutput;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        long N = 6;
        int F = 3;
        long[] P = {5L, 2L, 4L};
        long expectedOutput = 4;
        SolutionGreedy s = new SolutionGreedy();
        long output = s.getSecondsRequired(N, F, P);
        boolean passed = output == expectedOutput;
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

}
