import java.util.ArrayList;

public class SolutionSlidingWindow {
    public long getArtisticPhotographCount(int N, String C, int X, int Y) {

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

        long[] toRightPartialSum = new long[pos[1].size()];
        long[] toLeftPartialSum = new long[pos[1].size()];
        int wdwToRightL = -1, wdwToRightR = -1;
        int wdwToLeftL = pos[2].size(), wdwToLeftR = pos[2].size();

        for (int i = 0; i < pos[1].size(); i++) {
            //  P A B
            while (wdwToRightR+1 < pos[2].size() && pos[2].get(wdwToRightR+1) - pos[1].get(i) <= Y) {
                wdwToRightR++;
            }
            while (wdwToRightL+1 <= wdwToRightR && pos[2].get(wdwToRightL+1) - pos[1].get(i) < X) {
                wdwToRightL++;
            }
            toRightPartialSum[i] = wdwToRightR - wdwToRightL + 1;

            //  B A P
            int size = pos[1].size();
            while (wdwToLeftL-1 >= 0 && pos[1].get(size-1-i) - pos[2].get(wdwToLeftL-1) <= Y) {
                wdwToLeftL--;
            }
            while (wdwToLeftL <= wdwToLeftR-1 && pos[1].get(size-1-i) - pos[2].get(wdwToLeftR-1) < X) {
               wdwToLeftR--;
            }
            toLeftPartialSum[size-1-i] = wdwToLeftR-wdwToLeftL+1;
        }


        long[] toRightPartialSum2 = new long[pos[0].size()];
        long[] toLeftPartialSum2 = new long[pos[0].size()];
        wdwToRightL = -1; wdwToRightR = -1;
        long wdwToRightSz = 0;
        wdwToLeftL = pos[1].size(); wdwToLeftR = pos[1].size();
        long wdwToLeftSz = 0;
        for (int i = 0; i < pos[0].size(); i++) {
            //  P A B
            while (wdwToRightR+1 < pos[1].size() && pos[1].get(wdwToRightR+1) - pos[0].get(i) <= Y) {
                wdwToRightR++;
                wdwToRightSz += toRightPartialSum[wdwToRightR];
            }
            while (wdwToRightL+1 <= wdwToRightR && pos[1].get(wdwToRightL+1) - pos[0].get(i) < X) {
                if (wdwToRightL >= 0) {
                    wdwToRightSz -= toRightPartialSum[wdwToRightL];
                }
                wdwToRightL++;
            }
            toRightPartialSum[i] = wdwToRightSz;

            //  B A P
            int size = pos[0].size();
            while (wdwToLeftL-1 >= 0 && pos[0].get(size-1-i) - pos[1].get(wdwToLeftL-1) <= Y) {
                wdwToLeftL--;
                wdwToLeftSz += toLeftPartialSum[wdwToLeftL];
            }
            while (wdwToLeftL <= wdwToLeftR-1 && pos[1].get(size-1-i) - pos[2].get(wdwToLeftR-1) < X) {
                if (wdwToLeftR < toLeftPartialSum.length) {
                    wdwToLeftSz -= toLeftPartialSum[wdwToLeftR];
                }
                wdwToLeftR--;
            }
            toLeftPartialSum2[size-1-i] = wdwToLeftSz;
        }

        long acc = 0;
        for (int i = 0; i < toRightPartialSum2.length; i++) {
            acc += toRightPartialSum2[i];
            acc += toLeftPartialSum2[i];
        }

        return acc;
    }

    public static void main(String[] args) {
        test1();
    }


    public static void test1() {
        int N = 5;
        String C = ".PBAAP.B";
        int X = 1, Y = 3;

        SolutionSlidingWindow s = new SolutionSlidingWindow();
        long output = s.getArtisticPhotographCount(N, C, X, Y);
        long expectedOutput = 3;
        boolean passed = output == expectedOutput;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }



     

}
