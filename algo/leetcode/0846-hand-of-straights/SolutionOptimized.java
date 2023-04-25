import java.util.Arrays;
import java.util.HashMap;

public class SolutionOptimized {

    public static void main(String[] args) {
        testSolutionOptimized_1();
        testSolutionOptimized_2();
    }

    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }

        int n = hand.length;
        Arrays.sort(hand);

        HashMap<Integer, Integer> fq = new HashMap<>();
        for (int i = 0; i < n; i++) {
            fq.put(hand[i], fq.getOrDefault(hand[i], 0)+1);
        }

        int acc = 0;
        for (int i = 0; i < n; i++) {
            if (fq.get(hand[i]) == 0) {
                continue;
            }
            for (int j = 0; j < groupSize; j++) {
                Integer jFQ = fq.get(hand[i]+j);
                if (jFQ != null && fq.get(hand[i]+j) > 0) {
                    fq.put(hand[i]+j, jFQ-1);
                } else {
                    return false;
                }
            }
            acc += groupSize;
        }

        return acc == n;
    }

    public static void testSolutionOptimized_1() {
        int[] hand = {1,2,3,6,2,3,4,7,8};
        int groupSize = 3;
        SolutionOptimized s = new SolutionOptimized();
        boolean expOutput = true;
        boolean output = s.isNStraightHand(hand, groupSize);
        boolean passed = expOutput == output;
        System.out.println("testSolutionOptimized_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionOptimized_2() {
        int[] hand = {1,2,3,4,5};
        int groupSize = 4;
        SolutionOptimized s = new SolutionOptimized();
        boolean expOutput = false;
        boolean output = s.isNStraightHand(hand, groupSize);
        boolean passed = expOutput == output;
        System.out.println("testSolutionOptimized_2: " + (passed ? "passed" : "failed"));
    }
}
