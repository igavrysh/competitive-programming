import java.util.HashSet;
import java.util.ArrayList;

class Solution {
    public int distinctPrimeFactors(int[] nums) {
        HashSet<Integer> result = new HashSet<Integer>();
        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = 0; i <= 1000; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int ptr = 0;
            int num = nums[i];
            while (ptr < primes.size() && primes.get(ptr) <= num) {
                if (nums[i] % primes.get(ptr) == 0) {
                    result.add(primes.get(ptr));
                    primes.remove(ptr);
                } else {
                    ptr++;
                }
            }
        }
        return result.size();
    }

    private boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }   
        if (n % 2 == 0) {
            return false;
        }
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        int[] nums = {2,4,3,7,10,6};
        int expOutput = 4;
        Solution sol = new Solution();
        int output = sol.distinctPrimeFactors(nums);
        boolean passed = output == expOutput;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }
}