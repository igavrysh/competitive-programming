import java.util.Arrays;
import java.util.PriorityQueue;
class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        if (multiplier==1){
            return nums;
        }
        long mod = (long) Math.pow(10, 9) + 7;
        PriorityQueue<long[]> pq = new PriorityQueue<>((long[] p1, long[] p2) -> {
            if (p1[0] == p2[0]) {
                return Long.compare(p1[1], p2[1]);
            }
            return Long.compare(p1[0], p2[0]);
        });
        long max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            pq.offer(new long[] { nums[i], i });
            max = Math.max(max, nums[i]);
        }
        long i = 0;
        for (; i < k; i++) {
            if (pq.peek()[0] * multiplier > max) {
                break;
            }
            long[] p = pq.poll();
            p[0] = (p[0] * multiplier) % mod;
            pq.offer(p);
        }
        long num_full_cycles = (k - i) / nums.length;
        long rem_turns = (k - i) % nums.length;
        // System.out.println("num_full_cycles:"+num_full_cycles +
        // ";rem_turns:"+rem_turns);
        long counter = 0;
        while (!pq.isEmpty()) {
            long[] p = pq.poll();
            p[0] = (p[0] * power(multiplier, num_full_cycles+(counter < rem_turns ? 1 : 0), mod)) % mod;
            counter++;
            nums[(int) p[1]] = (int) p[0];
        }
        return nums;
    }
    public long power(long a, long b, long m) {// a^b % m
        long res = 1;
        a %= m;
        while (b > 0) {
            if ((b & 1) != 0) {
                res = (res * a) % m;
                b--;
            } else {
                b >>= 1;
                a = (a * a) % m;
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    private static void test1() {
        int[] nums = { 689009555, 813837455, 240010825, 967305450 };
        int k = 804709161;
        int multiplier = 601392;
        int[] expOutput = { 158205367, 862774837, 475528263, 828321106 };
        Solution sol = new Solution();
        int[] output = sol.getFinalState(nums, k, multiplier);
        boolean passed = Arrays.equals(output, expOutput);
        System.out.println("test1:" + (passed ? "passed" : "failed"));
    }

    private static void test2() {
        int[] nums = { 894928320, 29649137, 226546466, 560741913, 806595553 };
        int k = 861330088;
        int multiplier = 536777;
        int[] expOutput = { 435376653, 668690335, 582152199, 79058424, 133733128 };
        Solution sol = new Solution();
        int[] output = sol.getFinalState(nums, k, multiplier);
        boolean passed = Arrays.equals(output, expOutput);
        System.out.println("test2:" + (passed ? "passed" : "failed"));
    }

    private static void test3() {
        int[] nums = { 1 };
        int k = 1000000000;
        int multiplier = 1;
        int[] expOutput = { 1 };
        Solution sol = new Solution();
        int[] output = sol.getFinalState(nums, k, multiplier);
        boolean passed = Arrays.equals(output, expOutput);
        System.out.println("test3:" + (passed ? "passed" : "failed"));
    }

}