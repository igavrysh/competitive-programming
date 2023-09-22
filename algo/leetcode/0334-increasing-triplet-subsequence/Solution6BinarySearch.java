public class Solution6BinarySearch {

    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        
        // create sketch array that will include all inc sequences
        // but overwriting each other, e.g. the number that arrive later and should be say 3rd 
        // in sequence will overwrite the 3rd element from other sequence that has higher value and 
        // that arrived earlier
        int[] sketchArray = new int[2];

        int size = 0;
        int l = -1;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int idx = bs(num, l, l+size+1, sketchArray);
            if (idx == l+size+1 && (size == 0 || sketchArray[l+size] != num)) {
                size++;
                if (size == 3) {
                    return true;
                }
            }
            // in any way, idx is order number, and we overwrite higher elements from other seq that arrived 
            // earlier with lower elem fron seq that arriver later (the # in seq is the same)
            sketchArray[idx] = num;
        }
        return false;
    }

    private int bs(int value, int bad, int good, int[] a) {
        while (good - bad > 1) {
            int m = bad + (good-bad)/2;
            if (value <= a[m]) {
                good = m;
            } else {
                bad = m;
            }
        }
        return good;
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }
    
    public static void test1() {
        int[] nums = {1,2,3,4,5};
        Solution6BinarySearch s = new Solution6BinarySearch();
        boolean output = s.increasingTriplet(nums);
        boolean expected = true;
        boolean passed = output == expected;
        System.out.println("testBs1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        int[] nums = {5,4,3,2,1};
        Solution6BinarySearch s = new Solution6BinarySearch();
        boolean output = s.increasingTriplet(nums);
        boolean expected = false;
        boolean passed = output == expected;
        System.out.println("testBs2: " + (passed ? "passed" : "failed"));
    }

    public static void test3() {
        int[] nums = {2,1,5,0,4,6};
        Solution6BinarySearch s = new Solution6BinarySearch();
        boolean output = s.increasingTriplet(nums);
        boolean expected = true;
        boolean passed = output == expected;
        System.out.println("testBs3: " + (passed ? "passed" : "failed"));
    }

    public static void test4() {
        int[] nums = {20,100,10,12,5,13};
        Solution6BinarySearch s = new Solution6BinarySearch();
        boolean output = s.increasingTriplet(nums);
        boolean expected = true;
        boolean passed = output == expected;
        System.out.println("testBs4: " + (passed ? "passed" : "failed"));
    }
}
