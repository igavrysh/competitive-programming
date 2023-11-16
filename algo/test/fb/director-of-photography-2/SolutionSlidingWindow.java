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

        int l, r;
        long wSum;

        int pos1Size = pos[1].size();
        int pos2Size = pos[2].size();
        long[] toR = new long[pos[1].size()];
        l = -1;
        r = 0; // l.incl r exclusive 
        wSum = 0;
        for (int i = 0; i < pos1Size; i++) {
            //  P A B
            while (r < pos2Size && pos[2].get(r) - pos[1].get(i) <= Y) {
                wSum+=1;
                r++;
            }

            while (l == -1 || (l < r && pos[2].get(l) - pos[1].get(i) < X)) {
                if (l!=-1) {
                    wSum-=1;
                }
                l++;
            }
            toR[i] = wSum;
        }

        long[] toL = new long[pos[1].size()];
        l = pos2Size-1; // exclusive
        r = pos2Size; // inclusive
        wSum = 0;
        for (int i = pos1Size-1; i >= 0; i--) {
            while (l >= 0 && pos[1].get(i)-pos[2].get(l) <= Y) {
                wSum++;
                l--;
            }

            while (r == pos2Size || (l < r && pos[1].get(i) - pos[2].get(r) < X)) {
                if (r!=pos2Size) {
                    wSum-=1;
                }
                r--;
            }
            toL[i] = wSum;
        }

        int pos0Size = pos[0].size();

        long[] toR2 = new long[pos0Size];
        l = -1;
        r = 0; // l.incl r exclusive 
        wSum = 0;
        for (int i = 0; i < pos0Size; i++) {
            //  P A B
            while (r < pos1Size && pos[1].get(r) - pos[0].get(i) <= Y) {
                wSum+=toR[r];
                r++;
            }

            while (l == -1 || (l < r && pos[1].get(l) - pos[0].get(i) < X)) {
                if (l!=-1) {
                    wSum-=toR[l];
                }
                l++;
            }
            toR2[i] = wSum;
        }

        long[] toL2 = new long[pos0Size];
        l = pos1Size-1; // exclusive
        r = pos1Size; // inclusive
        wSum = 0;
        for (int i = pos0Size-1; i >= 0; i--) {
            while (l >= 0 && pos[0].get(i)-pos[1].get(l) <= Y) {
                wSum += toL[l];
                l--;
            }

            while (r == pos1Size || (l < r && pos[0].get(i) - pos[1].get(r) < X)) {
                if (r!=pos1Size) {
                    wSum-=toL[r];
                }
                r--;
            }
            toL2[i] = wSum;
        }

        long acc = 0;
        for (int i = 0; i < pos0Size; i++) {
            acc += toR2[i];
            acc += toL2[i];
        }

        return acc;
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

        SolutionSlidingWindow s = new SolutionSlidingWindow();
        long output = s.getArtisticPhotographCount(N, C, X, Y);
        long expectedOutput = 3;
        boolean passed = output == expectedOutput;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        int N = 5;
        String C = "APABA";
        int X = 1, Y = 2;

        SolutionSlidingWindow s = new SolutionSlidingWindow();
        long output = s.getArtisticPhotographCount(N, C, X, Y);
        long expectedOutput = 1;
        boolean passed = output == expectedOutput;
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    public static void test3() {
        int N = 5;
        String C = "APABA";
        int X = 2, Y = 3;

        SolutionSlidingWindow s = new SolutionSlidingWindow();
        long output = s.getArtisticPhotographCount(N, C, X, Y);
        long expectedOutput = 0;
        boolean passed = output == expectedOutput;
        System.out.println("test3: " + (passed ? "passed" : "failed"));
    }
}
