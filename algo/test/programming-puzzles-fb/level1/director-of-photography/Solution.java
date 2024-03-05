import java.util.ArrayList;

class Solution {

    public int getArtisticPhotographCount(int N, String C, int X, int Y) {
        ArrayList<Integer>[] pos = new ArrayList[3];
        pos[0] = new ArrayList<>(); pos[1] = new ArrayList<>(); pos[2] = new ArrayList<>();
        for (int i = 0; i < C.length(); i++) {
            if (C.charAt(i) == 'P') {
                pos[0].add(i);
            } else if (C.charAt(i) == 'A') {
                pos[1].add(i);
            } else if (C.charAt(i) == 'B') {
                pos[2].add(i);
            }
        }
        int[] output = {0};
        BT(0, new int[3], output, pos, X, Y);
        return output[0];
    }

    private void BT(int idx, int[] acc, int[] output, ArrayList<Integer>[] pos, int X, int Y) {
        if (idx == 3) {
            output[0]++;
            return;
        }

        for (int i = 0; i < pos[idx].size(); i++) {
            int curPabPos = pos[idx].get(i);
            if (idx == 0) {
                acc[idx] = curPabPos;
                BT(idx+1, acc, output, pos, X, Y);
            } else {
                int prevPabPos = acc[idx-1];
                int delta = curPabPos - prevPabPos;
                if (Math.abs(delta) >= X && Math.abs(delta) <= Y) {
                    if (idx == 1) {
                        acc[idx] = curPabPos;
                        BT(idx+1, acc, output, pos, X, Y);
                    } else {
                        int prevDelta = acc[idx-1] - acc[idx-2];
                        if ((prevDelta < 0 && delta < 0) || (prevDelta > 0 && delta > 0)) {
                            acc[idx] = curPabPos;
                            BT(idx+1, acc, output, pos, X, Y);
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    public static void test1() {
        int N = 5;
        String C = ".PBAAP.B";
        int X = 1, Y = 3;

        Solution s = new Solution();
        int output = s.getArtisticPhotographCount(N, C, X, Y);
        int expectedOutput = 3;
        boolean passed = output == expectedOutput;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        int N = 5;
        String C = "APABA";
        int X = 1, Y = 2;

        Solution s = new Solution();
        int output = s.getArtisticPhotographCount(N, C, X, Y);
        int expectedOutput = 1;
        boolean passed = output == expectedOutput;
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    public static void test3() {
        int N = 5;
        String C = "APABA";
        int X = 2, Y = 3;

        Solution s = new Solution();
        int output = s.getArtisticPhotographCount(N, C, X, Y);
        int expectedOutput = 0;
        boolean passed = output == expectedOutput;
        System.out.println("test3: " + (passed ? "passed" : "failed"));
    }

}
