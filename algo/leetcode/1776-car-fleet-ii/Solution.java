import java.util.Stack;
class Solution {
    public double[] getCollisionTimes(int[][] cars) {
        int n = cars.length;
        double[] t = new double[n];
        t[n-1] = -1;
        Stack<double[]> stack = new Stack<>();
        stack.push(new double[]{cars[n-1][0],cars[n-1][1],-1.0});
        for (int i = n-2; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek()[1] >= cars[i][1]) {
                stack.pop();
            }

            while (!stack.isEmpty()
                && (cars[i][0]-stack.peek()[0])/(stack.peek()[1]-cars[i][1])>stack.peek()[2]
                && stack.peek()[2] != -1.0
            ) {
                stack.pop();
            }

            if (stack.size() == 0) {
                t[i] = -1;
            } else {
                double[] carAhead = stack.peek();
                t[i] = (cars[i][0] - carAhead[0]) / (carAhead[1] - cars[i][1]);
            }
            stack.push(new double[]{cars[i][0],cars[i][1],t[i]});
        }
        for (int i = 0; i < n; i++) {
            if (t[i] == 0) {
                t[i] = -1;
            }
        }
        return t; 
    }

    public static void test1() {
        int[][] cars = {{1,2},{2,1},{4,3},{7,2}};
        double[] expOutput = {1.00000,-1.00000,3.00000,-1.00000};
        Solution sol = new Solution();
        double[] output = sol.getCollisionTimes(cars);
        boolean passed = expOutput.length == output.length;
        if (passed) {
            for (int i = 0; i < output.length; i++) {
                passed = passed && (Math.abs(output[i]-expOutput[i]) < 0.00001);
            }
        }
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        int[][] cars = {{3,4},{5,4},{6,3},{9,1}};
        double[] expOutput = {2.00000,1.00000,1.50000,-1.00000};
        Solution sol = new Solution();
        double[] output = sol.getCollisionTimes(cars);
        boolean passed = expOutput.length == output.length;
        if (passed) {
            for (int i = 0; i < output.length; i++) {
                passed = passed && (Math.abs(output[i]-expOutput[i]) < 0.00001);
            }
        }
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    public static void main(String[] args) {
        test2();
        test1();
    }
}