public class Solution4Greedy2 {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length; 
        if (n < 3) {
            return false;
        }

        int minLeft = nums[0];
        int maxRight = nums[n-1];

        int j = n-2;
        for (int i = 1; i < n; i++) {
            if (i > j) {
                return false;
            }
            if (minLeft < nums[i]) {
                for (; j >= 1; j--) {
                    if (nums[j] < maxRight) {
                        if (i == j) {
                            return true;
                        } else if (i < j) {
                            j = j-1;
                            break;
                        } else {
                            return false;
                        }
                    } else {
                        maxRight = nums[j];
                    }
                }
            } else {
                minLeft = nums[i];
            }
        }
        return false;
    }

/*

 int c1 = INT_MAX, c2 = INT_MAX;
    for (int x : nums) {
        if (x <= c1) {
            c1 = x;           // c1 is min seen so far (it's a candidate for 1st element)
        } else if (x <= c2) { // here when x > c1, i.e. x might be either c2 or c3
            c2 = x;           // x is better than the current c2, store it
        } else {              // here when we have/had c1 < c2 already and x > c2
            return true;      // the increasing subsequence of 3 elements exists
        }
    }
    return false;




0              5
20,100,10,12,5,13
     i       j
0: x = 20, c1 = 20, c2 = Info
1: x = 100, c1 = 20



2,1,5,0,4,6
    i   j 

    */

    public static void main(String[] args) {
        testSolution4Greedy2_1();
        testSolution4Greedy2_2();
        testSolution4Greedy2_3();
        testSolution4Greedy2_4();
        testSolution4Greedy2_5();
    }

    public static void testSolution4Greedy2_1() {
        int[] nums = {1,2,3,4,5};
        Solution4Greedy2 s = new Solution4Greedy2();
        boolean output = s.increasingTriplet(nums);
        boolean expected = true;
        boolean passed = output == expected;
        System.out.println("testSolution4Greedy2_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution4Greedy2_2() {
        int[] nums = {5,4,3,2,1};
        Solution4Greedy2 s = new Solution4Greedy2();
        boolean output = s.increasingTriplet(nums);
        boolean expected = false;
        boolean passed = output == expected;
        System.out.println("testSolution4Greedy2_2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution4Greedy2_3() {
        int[] nums = {2,1,5,0,4,6};
        Solution4Greedy2 s = new Solution4Greedy2();
        boolean output = s.increasingTriplet(nums);
        boolean expected = true;
        boolean passed = output == expected;
        System.out.println("testSolution4Greedy2_3: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution4Greedy2_4() {
        int[] nums = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        Solution4Greedy2 s = new Solution4Greedy2();
        boolean output = s.increasingTriplet(nums);
        boolean expected = false;
        boolean passed = output == expected;
        System.out.println("testSolution4Greedy2_4: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution4Greedy2_5() {
        int[] nums = {20,100,10,12,5,13};
        Solution4Greedy2 s = new Solution4Greedy2();
        boolean output = s.increasingTriplet(nums);
        boolean expected = true;
        boolean passed = output == expected;
        System.out.println("testSolution4Greedy2_5: " + (passed ? "passed" : "failed"));
    }
}