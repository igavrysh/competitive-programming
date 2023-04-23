class Solution {
    public static void main(String[] args) {
        testSolution_1();
        testSolution_2();
        testSolution_3();
        testSolution_4();
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totalDiff = 0;
        int start = 0;
        int tank = 0;
        for (int i = 0; i < n; i++) {
            int delta = gas[i]-cost[i];
            if (tank + delta < 0) {
                start = (i+1)%n;
                tank = 0;
            } else {
                tank += delta;
            }

            totalDiff += delta;
        }
        return totalDiff < 0 ? -1 : start;
    }

    public static void testSolution_1() {
        int[] gas = {1,2,3,4,5}, cost = {3,4,5,1,2};
        int expOut = 3;
        Solution s = new Solution();
        int output = s.canCompleteCircuit(gas, cost);
        boolean passed = output == expOut;
        System.out.println("testSolution_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution_2() {
        int[] gas = {2,3,4}, cost = {3,4,3};
        int expOut = -1;
        Solution s = new Solution();
        int output = s.canCompleteCircuit(gas, cost);
        boolean passed = output == expOut;
        System.out.println("testSolution_2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution_3() {
        int[] gas = {3,1,1}, cost = {1,2,2};
        int expOut = 0;
        Solution s = new Solution();
        int output = s.canCompleteCircuit(gas, cost);
        boolean passed = output == expOut;
        System.out.println("testSolution_3: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution_4() {
        int[] gas = {7,1,0,11,4}, cost = {5,9,1,2,5};
        int expOut = 3;
        Solution s = new Solution();
        int output = s.canCompleteCircuit(gas, cost);
        boolean passed = output == expOut;
        System.out.println("testSolution_4: " + (passed ? "passed" : "failed"));
    }
}


