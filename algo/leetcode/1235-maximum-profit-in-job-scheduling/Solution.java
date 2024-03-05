import java.util.Arrays;
import java.util.ArrayList;;

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] input = new int[n][3];
        for (int i = 0; i < n; i++) {
            input[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(input, (int[] a1, int[] a2) -> Integer.compare(a1[1], a2[1]));

        // DP contains max profit up to end time t
        // int[0] = end time, int[1] = max profit at end time
        ArrayList<int[]> dp = new ArrayList<>();
        int globalMaxProfit = 0;
        for (int i = 0; i < n; i++) {
            int[] job = input[i];

            int maxProfit = Math.max(
                BS(job[0], dp) + job[2],
                BS(job[1], dp)
            );

            dp.add(new int[] {job[1], maxProfit});

            globalMaxProfit = Math.max(globalMaxProfit, maxProfit);
        }
        return globalMaxProfit;
    }

    private int BS(int endTime, ArrayList<int[]> dp) {
        int bad = -1;
        int good = dp.size();
        while (good - bad > 1) {
            int m = bad + (good - bad) / 2;
            int[] mData = dp.get(m);
            if (mData[0] > endTime) {
                good = m;
            } else {
                bad = m;
            }
        }
        return (bad == -1 || bad ==  dp.size()) ? 0 : dp.get(bad)[1];
    }

    public static void main(String[] args) {
        test3();
        test2();
        test1();
    }

    public static void test1() {
        int[] startTime = {1,2,3,3};
        int[] endTime = {3,4,5,6};
        int[] profit = {50,10,40,70};
        int expOutput = 120;
        Solution sol = new Solution();
        int output = sol.jobScheduling(startTime, endTime, profit);
        boolean passed = output == expOutput;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        int[] startTime = {1,2,3,4,6};
        int[] endTime = {3,5,10,6,9};
        int[] profit = {20,20,100,70,60};
        int expOutput = 150;
        Solution sol = new Solution();
        int output = sol.jobScheduling(startTime, endTime, profit);
        boolean passed = output == expOutput;
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    public static void test3() {
        int[] startTime = {1,1,1};
        int[] endTime = {2,3,4};
        int[] profit = {5,6,4};
        int expOutput = 6;
        Solution sol = new Solution();
        int output = sol.jobScheduling(startTime, endTime, profit);
        boolean passed = output == expOutput;
        System.out.println("test3: " + (passed ? "passed" : "failed"));
    }
}