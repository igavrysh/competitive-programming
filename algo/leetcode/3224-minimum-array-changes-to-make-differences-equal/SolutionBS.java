import java.util.Arrays;
import java.util.HashMap;

class SolutionBS {
    public int minChanges(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> delta_fq = new HashMap<>();
        HashMap<Integer,Integer> x_th_fq = new HashMap<>();
        for (int i = 0; i < n/2; i++) {
            int delta = Math.abs(nums[i] - nums[n-1-i]);
            delta_fq.put(delta, delta_fq.getOrDefault(delta,0)+1);
            int maxX = Math.max(
                Math.max(nums[i],nums[n-1-i]),
                k-Math.min(nums[i],nums[n-1-i])
            );
            x_th_fq.put(maxX, x_th_fq.getOrDefault(maxX, 0)+1);
        }
        int[][] cmltv = new int[x_th_fq.keySet().size()][2];
        int idx = 0;
        for (Integer x_th : x_th_fq.keySet()) {
            int fq = x_th_fq.get(x_th);
            cmltv[idx++] = new int[]{x_th, fq};
        }
        Arrays.sort(cmltv, (int[] p1, int[] p2) -> Integer.compare(p1[0],p2[0]));
        int acc = 0;
        for (int i = cmltv.length-1; i >= 0; i--) {
            acc += cmltv[i][1];
            cmltv[i][1] = acc;
        }
        int global_min = n;
        for (int x = 0; x <= k; x++) {
            int exact_deltas = delta_fq.get(x) == null ? 0 : delta_fq.get(x);
            int cmltv_idx = bs(cmltv, x);
            int one_change_deltas = (cmltv_idx != cmltv.length ? cmltv[cmltv_idx][1] : 0)-exact_deltas;
            int two_change_deltas = n/2 - exact_deltas - one_change_deltas;
            int changes_for_x = one_change_deltas + 2*two_change_deltas;
            global_min = Math.min(global_min, changes_for_x);
        }
        return global_min; 
    }
    private int bs(int cmlt[][], int x) {
        int good = cmlt.length;
        int bad = -1;
        while (good-bad>1) {
            int m = bad + (good-bad)/2;
            if (cmlt[m][0] == x) {
                return m;
            }
            if (cmlt[m][0] > x) {
                good = m;
            } else {
                bad = m;
            }
        }
        return good;
    }   
    
    public static void main(String[] args) {
        test3();
        test2();
        test1();
    }

    public static void test1() {
        int[] nums = {0,1,2,3,3,6,5,4};
        int k = 6;
        int expOutput = 2;
        SolutionBS sol = new SolutionBS();
        int output = sol.minChanges(nums, k);
        boolean passed = output == expOutput;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        int[] nums = {1,0,1,2,4,3};
        int k = 4;
        int expOutput = 2;
        SolutionBS sol = new SolutionBS();
        int output = sol.minChanges(nums, k);
        boolean passed = output == expOutput;
        System.out.println("test2: " + (passed ? "passed" : "failed")); 
    }

    public static void test3() {
        int[] nums = {18,10,14,18,17,2,11,5};
        int k = 19;
        int expOutput = 2;
        SolutionBS sol = new SolutionBS();
        int output = sol.minChanges(nums, k);
        boolean passed = output == expOutput;
        System.out.println("test3: " + (passed ? "passed" : "failed")); 
    }
}