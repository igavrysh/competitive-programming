import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

// ! NOT passing few last tests due to error (stack overflow etc)
class SolutionMem {

    private int N, M;
    private int[] C;
    private HashMap<String, Long> mem;

    public long getMinCodeEntryTime(int N, int M, int[] C) {
        this.N = N;
        this.M = M;
        this.C = C;
        mem = new HashMap<>();

        long output = BT(0, new int[]{1,1});
        return output;
    }

    private String key(int[] state, int idx) {
        StringBuilder sb = new StringBuilder();
        if (state[0] < state[1]) {
            sb.append(String.valueOf(state[0]));
            sb.append("_");
            sb.append(String.valueOf(state[1])); 
        } else {
            sb.append(String.valueOf(state[1]));
            sb.append("_");
            sb.append(String.valueOf(state[0])); 
        }

        sb.append("_");
        sb.append(String.valueOf(idx));;
        return sb.toString();
    }

    private long BT(int idx, int[] state) {
        if (idx == M) {
            return 0;
        }

        if (C[idx] == state[0] || C[idx] == state[1]) {
            return BT(idx+1, state);
        }

        String key = key(state, idx);
        if (mem.get(key) != null) {
            return mem.get(key);
        }

        long t1 = 0, t2 = 0;

        if (C[idx] > state[0]) {
            t1 = Math.min(C[idx] - state[0], state[0] + N - C[idx]) + BT(idx+1, new int[]{C[idx], state[1]});
        } else if (C[idx] < state[0]) {
            t1 = Math.min(state[0] - C[idx], C[idx] + N - state[0]) + BT(idx+1, new int[]{C[idx], state[1]});
        }

        if (C[idx] > state[1]) {
            t2 = Math.min(C[idx] - state[1], state[1] + N- C[idx]) + BT(idx+1, new int[]{state[0], C[idx]});
        } else if (C[idx] < state[1]) {
            t2 = Math.min(state[1] - C[idx], C[idx] + N-state[1]) + BT(idx+1, new int[]{state[0], C[idx]});
        }

        long res = Math.min(t1, t2);
        mem.put(key, res);

        return res;
    }

    public static void main(String[] args) {
        test3();
        testRandom2();
        testRandom();
        test1();
        test2();
    }

    public static void test3() {
        int N = 10;
        int M = 5;
        int[] C = {2,5,8,5,4};
        long expectedOutput = 8;
        SolutionMem sol = new SolutionMem();
        long output = sol.getMinCodeEntryTime(N, M, C);
        boolean passed = output == expectedOutput;
        System.out.println("test3: " + (passed ? "passed" : "failed"));
    }

    public static void test1() {
        int N = 3;
        int M = 3;
        int[] C = {1,2,3};
        long expectedOutput = 2;
        SolutionMem sol = new SolutionMem();
        long output = sol.getMinCodeEntryTime(N, M, C);
        boolean passed = output == expectedOutput;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        int N = 10;
        int M = 4;
        int[] C = {9,4,4,8};
        long expectedOutput = 6;
        SolutionMem sol = new SolutionMem();
        long output = sol.getMinCodeEntryTime(N, M, C);
        boolean passed = output == expectedOutput;
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    public static void testRandom() {
        int N = 1000000000;
        int M = 3000;
        int[] C = new int[M];
        for (int i = 0; i < M; i++) {
            C[i] = ThreadLocalRandom.current().nextInt(1, N + 1);
        }
        SolutionMem s = new SolutionMem();
        long output = s.getMinCodeEntryTime(N, M, C);
        System.out.println("testRandom, output = " + String.valueOf(output));
    }

    public static void testRandom2() {
        int N = 10;
        int M = 5;
        int[] C = new int[M];
        for (int i = 0; i < M; i++) {
            C[i] = ThreadLocalRandom.current().nextInt(1, N + 1);
        }
        SolutionMem s = new SolutionMem();
        long output = s.getMinCodeEntryTime(N, M, C);
        System.out.println("testRandom, output = " + String.valueOf(output));
    }
}
