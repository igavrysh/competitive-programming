// not working

import java.util.ArrayList;
import java.util.HashMap;

class SolutionBT {

    public long getSecondsRequired(long N, int F, long[] P) {
        HashMap<ArrayList<Long>, Long> lens = new HashMap<>();
        ArrayList<Long> currP = new ArrayList<>();
        for (int i = 0; i < P.length; i++) {
            currP.add(P[i]);
        }
        currP.sort((a, b) -> a.compareTo(b));

        return BT(0, currP, lens, N);
    }

    private long BT(long currLen,  ArrayList<Long> currP, HashMap<ArrayList<Long>, Long> lens, long N) {
        if (lens.get(currP) != null) {
            return lens.get(currP);
        }

        boolean isFinal = true;
        for (int i = 0; i < currP.size(); i++) {
            if (currP.get(i) != N) {
                isFinal = false;
                break;
            }
        }

        if (isFinal) {
            return currLen;
        }

        long minLength = Long.MAX_VALUE;
        for (int i = 0; i < currP.size(); i++) {
            int newI = moveForward(i, currP, N);
            minLength = Math.min(minLength, BT(currLen+1, currP, lens, N));
            moveBackward(newI, currP, N);
        }
        lens.put(currP, minLength);

        return minLength;
    }

    private int moveForward(int i, ArrayList<Long> P, long N) {
        long curr = P.get(i);
        long next = curr+1;
        int j = i+1;
        while (j < P.size() && P.get(j) == next && P.get(j) != N) {
            P.set(j-1, P.get(j));
            next = next+1;
            j = j+1;
        }
        if (j == P.size()) {
            j--;
        }
        P.set(j, next);
        return j;
    }

    private int moveBackward(int i, ArrayList<Long> P, long N) {
        long curr = P.get(i);
        long prev = curr-1;
        int j = i-1;
        while (j >= 0 && P.get(j) >= prev) {
            if (P.get(j) > prev) {
                j = j-1;
                continue;
            }
            P.set(j+1, P.get(j));
            prev = prev-1;
            j = j-1;
        }

        P.set(j+1, prev);
        return j+1;
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
        SolutionBT s = new SolutionBT();
        long output = s.getSecondsRequired(N, F, P);
        boolean passed = output == expectedOutput;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        long N = 6;
        int F = 3;
        long[] P = {5L, 2L, 4L};
        long expectedOutput = 4;
        SolutionBT s = new SolutionBT();
        long output = s.getSecondsRequired(N, F, P);
        boolean passed = output == expectedOutput;
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }
}
