class Solution {

    public int getMaxVisitableWebpages(int N, int[] L) {
        int[] W = new int[N];
        for (int i = 0; i < N; i++) {
            W[i] = -1;
        }

        int maxW = 0;
        for (int i = 0; i < N; i++) {
            if (W[i] == -1) {
                maxW = Math.max(maxW, process(i, N, L, W));
            } else {
                maxW = Math.max(maxW, W[i]);
            }
        }
        return maxW;
    }

    private int process(int i, int N, int[] L, int[] W) {
        // go around until turtoise and hare meet
        int fast = L[L[i]-1]-1, slow = L[i]-1;
        int counter = 1;
        while (fast != slow && W[slow] == -1) {
            counter++;
            slow = L[slow]-1;
            fast = L[L[fast]-1]-1;
        }

        // early termination: found non-empty w in array W
        if (W[slow] != -1) {
            int w = W[slow];
            slow = i;           
            while (W[slow] == -1) {
                 W[slow] = counter + w;
                 counter--;
                 slow = L[slow]-1;
            } 
            return W[i];
        }

        // find the point for cycle start
        fast = i;
        int pathToCycleWeight = 0;
        while (fast != slow) {
            slow = L[slow]-1;
            fast = L[fast]-1;
            pathToCycleWeight++;
        }

        // find the cycle size
        int cycleWeight = 1;
        fast = L[slow]-1;
        while (fast != slow) {
            fast = L[fast]-1;
            cycleWeight++;
        }

        // assign cycle weight in W array
        W[slow] = cycleWeight;
        fast = L[slow]-1;
        while (fast != slow) {
            W[fast] = cycleWeight;
            fast = L[fast]-1;
        }


        // assign path to the cycle in W array
        fast = i;
        counter = 0;
        while (fast != slow) {
            W[fast] = pathToCycleWeight + cycleWeight - counter;
            fast = L[fast]-1;
            counter++;
        }

        return pathToCycleWeight+cycleWeight;
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    public static void test1() {
        int N = 4;
        int[] L = {4,1,2,1};
        int expectedOutput = 4;
        Solution sol = new Solution();
        int output = sol.getMaxVisitableWebpages(N, L);
        boolean passed = output == expectedOutput;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        int N = 5;
        int[] L = {4,3,5,1,2};
        int expectedOutput = 3;
        Solution sol = new Solution();
        int output = sol.getMaxVisitableWebpages(N, L);
        boolean passed = output == expectedOutput;
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    public static void test3() {
        int N = 5;
        int[] L = {2,4,2,2,3};
        int expectedOutput = 4;
        Solution sol = new Solution();
        int output = sol.getMaxVisitableWebpages(N, L);
        boolean passed = output == expectedOutput;
        System.out.println("test3: " + (passed ? "passed" : "failed"));
    }

}