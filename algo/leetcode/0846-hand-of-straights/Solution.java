import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class Solution {

    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;

        if (n%groupSize != 0) {
            return false;
        }

        Arrays.sort(hand);

        HashMap<Integer, ArrayList<ArrayList<Integer>>> m = new HashMap<>();
        for (int i = 0; i < n; i++) {
            ArrayList<ArrayList<Integer>> a = m.get(hand[i]);
            if (a == null) {
                a = new ArrayList<>();
            }
            ArrayList<Integer> internalA = null;
            if (a.size() != 0) {
                for (int j = 0; j < a.size(); j++) {
                    if (a.get(j).size() < groupSize) {
                        internalA = a.remove(j);
                        if (a.size() == 0) {
                            m.remove(hand[i]);
                        }
                        break;
                    }
                }
            }
            
            if (internalA == null) {
                internalA = new ArrayList<>();
            }

            internalA.add(hand[i]);

            ArrayList<ArrayList<Integer>> newA = m.get(hand[i]+1);
            if (newA == null) {
                newA = new ArrayList<>();
                m.put(hand[i]+1, newA);
            } 
            newA.add(internalA);
        }
    
        int acc = 0;
        for (Integer k : m.keySet()) {
            for (ArrayList<Integer> internalA : m.get(k)) {
                if (internalA.size() != groupSize) {
                    return false;
                }
                acc += internalA.size();
            }
        }

        return acc == hand.length;
    }

    public static void main(String[] args) {
        testSolution_1();
        testSolution_2();
    }

    public static void testSolution_1() {
        int[] hand = {1,2,3,6,2,3,4,7,8};
        int groupSize = 3;
        Solution s = new Solution();
        boolean expOutput = true;
        boolean output = s.isNStraightHand(hand, groupSize);
        boolean passed = expOutput == output;
        System.out.println("testSolution_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution_2() {
        int[] hand = {1,2,3,4,5};
        int groupSize = 4;
        Solution s = new Solution();
        boolean expOutput = false;
        boolean output = s.isNStraightHand(hand, groupSize);
        boolean passed = expOutput == output;
        System.out.println("testSolution_2: " + (passed ? "passed" : "failed"));
    }

}
