import java.util.ArrayList;
import java.util.Arrays;

class Solution {
  
    public long getArtisticPhotographCount(int N, String C, int X, int Y) {
        ArrayList<Integer>[] pos = new ArrayList[3];
        pos[0] = new ArrayList<>(); 
        pos[1] = new ArrayList<>(); 
        pos[2] = new ArrayList<>();
        for (int i = 0; i < C.length(); i++) {
            if (C.charAt(i) == 'P') {
                pos[0].add(i);
            } else if (C.charAt(i) == 'A') {
                pos[1].add(i);
            } else if (C.charAt(i) == 'B') {
                pos[2].add(i);
            }
        }
        long[] output = {0};
        BT(0, new int[3], output, pos, X, Y);
        return output[0];
    }

    private void BT(int idx, int[] acc, long[] output, ArrayList<Integer>[] pos, int X, int Y) {
        if (idx == 3) {
            output[0] += 1;
            return;
        }

        ArrayList<Integer> aPos = pos[idx];

        if (idx == 0) {
            for (int i = 0; i < aPos.size(); i++) {
                acc[0] = aPos.get(i);
                BT(1, acc, output, pos, X, Y);
            }
        }

        if (idx == 1 || idx == 2) {
            if (idx == 1 || (idx == 2 && acc[1]-acc[0] > 0)) {
                int nextR = bs_to_right(aPos, acc[idx-1]);
                for (int i = nextR; i < aPos.size(); i++) {
                    int delta = aPos.get(i) - acc[idx-1];
                    if (delta < X || delta > Y) {
                        break;
                    }
                    acc[idx] = aPos.get(i);
                    BT(idx+1, acc, output, pos, X, Y);
                }
            }
            
            if (idx == 1 || (idx == 2 && acc[1]-acc[0] < 0)) {
                int nextL = bs_to_left(aPos, acc[idx-1]);
                for (int i = nextL; i >= 0; i--) {
                    int delta = acc[idx-1] - aPos.get(i);
                    if (delta < X || delta > Y) {
                        break;
                    }
                    acc[idx] = aPos.get(i);
                    BT(idx+1, acc, output, pos, X, Y);
                }
            }
        }
    }

    private int bs_to_right(ArrayList<Integer> pos, int val) {
        int bad = -1, good = pos.size();
        while (good-bad > 1) {
            int m = bad + (good-bad)/2;
            if (pos.get(m) > val) {
                good = m;
            } else {
                bad = m;
            }
        }
        return good;
    }

    private int bs_to_left(ArrayList<Integer> pos, int val) {
        int bad = -1, good = pos.size();
        while (good-bad > 1) {
            int m = bad + (good-bad)/2;
            if (pos.get(m) >= val) {
                good = m;
            } else {
                bad = m;
            }
        }
        return bad;
    }

    private int bs(ArrayList<Integer> pos, boolean incrPos, int val) {
        int bad = -1, good = pos.size();
        while (good-bad > 1) {
            int m = bad + (good-bad)/2;
            if ((pos.get(m) > val && incrPos) || (pos.get(m) >= val && !incrPos)) {
                good = m;
            } else {
                bad = m;
            }
        }
        return incrPos ? good : good-1;
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        testBsToLeft();
    }

    public static void testBsToLeft() {
        int[] a = new int[]{2,7,11,12,15,32,34,56,78,86,99,101,145,203,291};
        ArrayList<Integer> pos = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            pos.add(a[i]);
        }
        int val = 147;
        Solution s = new Solution();
        int output = s.bs_to_left(pos, val);
        int expectedOutput = 12;
        boolean passed = output == expectedOutput;
        System.out.println("testBsToLeft: " + (passed ? "passed" : "failed"));
    }

    public static void test1() {
        int N = 5;
        String C = ".PBAAP.B";
        int X = 1, Y = 3;

        Solution s = new Solution();
        long output = s.getArtisticPhotographCount(N, C, X, Y);
        long expectedOutput = 3;
        boolean passed = output == expectedOutput;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        int N = 5;
        String C = "APABA";
        int X = 1, Y = 2;

        Solution s = new Solution();
        long output = s.getArtisticPhotographCount(N, C, X, Y);
        long expectedOutput = 1;
        boolean passed = output == expectedOutput;
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    public static void test3() {
        int N = 5;
        String C = "APABA";
        int X = 2, Y = 3;

        Solution s = new Solution();
        long output = s.getArtisticPhotographCount(N, C, X, Y);
        long expectedOutput = 0;
        boolean passed = output == expectedOutput;
        System.out.println("test3: " + (passed ? "passed" : "failed"));
    }
}