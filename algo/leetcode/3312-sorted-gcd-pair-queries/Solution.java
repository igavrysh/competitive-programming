import java.util.Arrays;
import java.util.ArrayList;
class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int n = nums.length;
        int max_num = nums[0];
        for (int i=0; i<n; i++) {
            max_num = Math.max(nums[i], max_num);
        }
        // store all valid dividers frequencies
        int[] div_fq = new int[max_num+1];
        for (int i=0; i<n; i++) {
            for (int div=1; div<=(int)Math.sqrt(nums[i]); div++) {
                if (nums[i]%div!=0) { continue; }
                div_fq[div]++;
                if (nums[i]/div!=div) {
                    div_fq[nums[i]/div]++;
                }
            }
        }
        int[] div_pairs = new int[max_num+1];
        // div_pairs[i] - number of pairs of numbers that divide by i
        // combinations of take 2 out for div_fq[i] 
        // = div_fq[i]!/[2!(div_fq[i]-2)!]
        for (int i=0; i<div_pairs.length;i++) {
            if (div_fq[i]==0) { continue; }
            div_pairs[i] = div_fq[i]*(div_fq[i]-1)/2;
        }
        // clean pairs off repeating dividers,
        // e.g. if there is 1 pair that has divider of 4 & 3 pair with divider of 2
        // if the both numbers devide by 4 => they also divide by 2
        // so I need to clean pairs of divider of 2 cos out of 3 pairs with divider of 2
        // 1 pair be devider of 2 and divider of 4, therefore only 2 pairs that have gcd=2
        // & 1 pair that has gcd of 4
        for (int i=div_pairs.length-1; i>=1; i--) {
            if (div_pairs[i] == 0) {
                continue;
            }
            for (int div=1; div<=(int)Math.sqrt(i); div++) {
                if (i%div!=0) { continue; } 
                if (div != i) {
                    div_pairs[div]-=div_pairs[i];
                }
                if (i/div!=div && i/div != i) {
                    div_pairs[i/div]-=div_pairs[i];
                }
            }
        }

        // int[], gcd_cumul.get(i)[0] = cumul fq, gcd_cumul.get(i)[1] - gcd value itself
        ArrayList<long[]> gcd_cumul = new ArrayList<>();
        long cumul_fq = 0;
        for (int i=1;i<div_pairs.length;i++) {
            if (div_pairs[i]>0) {
                cumul_fq+=div_pairs[i];
                gcd_cumul.add(new long[]{cumul_fq, i});
            }
        }
        /*
        for (int i=0;i<gcd_cumul.size();i++) {
            long[] t = gcd_cumul.get(i);
            System.out.println(t[0]+":"+t[1]);
        }*/

        int[] output = new int[queries.length];
        for (int q=0; q<queries.length; q++) {
            long target = queries[q]+1;
            int good = gcd_cumul.size();
            int bad = -1;
            while (good-bad>1) {
                int m = bad + (good-bad)/2;
                
                if (gcd_cumul.get(m)[0]>=target) {
                    good = m;
                } else {
                    bad = m;
                }
            }
            output[q] = (int)gcd_cumul.get(good)[1];
        }
        return output;
    }

    public static void main(String[] args) {
        test_1();
        test_custom();
    }

    public static void test_1() {
        int[] nums = {2,3,4};
        long[] queries = {0,2,2};
        int[] exp_output = {1,2,2};
        Solution sol = new Solution();
        int[] output = sol.gcdValues(nums, queries);
        boolean passed = Arrays.equals(output, exp_output);
        System.out.println("test_1: " + (passed ? "passed" : "failed"));
    }

    public static void test_custom() {
        int[] nums = {2,4,7,8};
        long[] queries = {0,2,2};
        int[] exp_output = {1,1,1};
        Solution sol = new Solution();
        int[] output = sol.gcdValues(nums, queries);
        boolean passed = Arrays.equals(output, exp_output);
        System.out.println("test_custom: " + (passed ? "passed" : "failed"));
    }
}