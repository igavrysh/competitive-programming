import java.util.HashMap;
import java.util.HashSet;
class Solution {
    public int countPairs(int[] nums) {
        HashMap<Integer, Integer> M = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            add(nums[i], M);
        }
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int fq = M.get(nums[i]);
            int t = 1;
        }
        return 0;
    }
    private void add(int num0, HashMap<Integer, Integer> M) {
        HashSet<Integer> added = new HashSet<>();
        M.put(num0, M.getOrDefault(num0,0)+1);
        added.add(num0);
        int[] digits0 = digits(num0);
        for (int i = 0; i < digits0[7]-1; i++) {
            for (int j = i+1; j < digits0[7]; j++) {
                int tmp0 = digits0[i];
                digits0[i] = digits0[j];
                digits0[j] = tmp0;
                int num1 = num(digits0);
                if (!added.contains(num1)) {
                    M.put(num1, M.getOrDefault(num1,0)+1);
                    added.add(num1);
                    int[] digits1 = digits(num1);
                    for (int i1 = 0; i1 < digits1[7]-1; i1++) {
                        for (int j1 = i1+1; j1 < digits1[7]; j1++) {
                            int tmp1 = digits1[i1];
                            digits1[i1] = digits1[j1];
                            digits1[j1] = tmp1;
                            int num2 = num(digits1);
                            if (!added.contains(num2)) {
                                M.put(num2, M.getOrDefault(num2, 0)+1);
                            }
                            digits1[j1] = digits1[i1];
                            digits1[i1] = tmp1;
                        }
                    }
                }
                digits0[j] = digits0[i];
                digits0[i] = tmp0;
            }
        }
    }
    private int[] digits(int num) {
        int[] digits = new int[8];
        int idx = 0;
        while (num != 0) {
            digits[idx++]=num%10;
            num/=10;
        }
        digits[7] = idx;
        return digits;
    }
    private int num(int[] digits) {
        int num = 0;
        int power = 1;
        for (int i = 0; i < digits[7]; i++) {
            num += power * digits[i];
            power *= 10;
        }
        return num;
    }
    public static void main(String[] args) {
        test1();
    }
    public static void test1() {
        int[] nums = {1023,2310,2130,213};
        int expOutput = 4;
        Solution sol = new Solution();
        int output = sol.countPairs(nums);
        boolean passed = output == expOutput;
        System.out.println("test1:"+ (passed ? "passed" : "failed"));
    }
}