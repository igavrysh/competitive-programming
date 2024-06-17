import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public List<Integer> countOfPeaks(int[] nums, int[][] q) {
        int n = nums.length;
        int[] l = new int[n];
        for (int i = 0; i < n; i++) {
            if ((i-1>=0 && nums[i] > nums[i-1]) 
                && (i+1 < n && nums[i] > nums[i+1])
            ) {
                l[i]++;
            }
        }
        //for (int i = 0; i < l.length; i++) {
        //    System.out.print(l[i] + ",");
        //}
        int[] f_tree = fill(l);
        //System.out.println("");
        //for (int i = 0; i < f_tree.length; i++) {
        //    System.out.print(f_tree[i] + ",");
        //}
        //System.out.println("");

        List<Integer> result = new ArrayList<>();
        for (int iq = 0; iq < q.length; iq++) {
            if (q[iq][0] == 1) {
                int left = Math.min(q[iq][1]+1, n-1);
                int right = Math.max(q[iq][2]-1, 0);
                if (right - left < 0) {
                    result.add(0);
                } else {
                    result.add(prefix_sum(right+1, f_tree) - prefix_sum(left, f_tree));
                }
            } else {
                int i = q[iq][1];
                int new_h = q[iq][2];
                boolean wasAPeak = prefix_sum(i+1, f_tree) - prefix_sum(i, f_tree) > 0;
                boolean wasim1APeak = i-1 >= 0 ? prefix_sum(i, f_tree) - prefix_sum(i-1, f_tree) > 0 : false;
                boolean wasip1APeak = i+1 < n-1 ? prefix_sum(i+2, f_tree) - prefix_sum(i+1, f_tree) > 0 : false;
                nums[i] = new_h;
                boolean isAPeak = i-1 >= 0 && i+1 < n ? nums[i] > nums[i-1] && nums[i] > nums[i+1] : false;
                boolean isim1APeak = i-1 > 0 ? nums[i-1] > nums[i-2] && nums[i-1] > nums[i] : false;
                boolean isip1APeak = i+1 < n-1 ? nums[i+1] > nums[i+2] && nums[i+1] > nums[i] : false;
                //System.out.println("wasAPeak:"+wasAPeak + "; wasim1APeak:" + wasim1APeak + "; wasip1APeak:" + wasip1APeak);
                //System.out.println("isAPeak:"+isAPeak + "; isim1APeak:" + isim1APeak + "; isip1APeak:" + isip1APeak);

                if (!wasAPeak && isAPeak) {
                    change(i+1, 1, f_tree);
                } else if (wasAPeak & !isAPeak) {
                    change(i+1, -1, f_tree);
                }
                if (!wasim1APeak && isim1APeak) {
                    change(i, 1, f_tree);
                } else if (wasim1APeak && !isim1APeak) {
                    change(i, -1, f_tree);
                }
                if (!wasip1APeak && isip1APeak) {
                    change(i+2, 1, f_tree);
                } else if (wasip1APeak && !isip1APeak) {
                    change(i+2, -1, f_tree);
                }
            }
        }
        return result;
    }

    private int parent(int idx) {
        return idx - (idx & (~idx+1));
    }

    private int next(int idx) {
        return idx + (idx & (~idx+1));
    }

    private int prefix_sum(int idx, int[] f_tree) {
        int res = 0;
        while (idx != 0) {
            res += f_tree[idx];
            idx = parent(idx);
        }
        return res;
    }

    private void change(int idx, int delta, int[] f_tree) {
        while (idx < f_tree.length) {
            f_tree[idx] += delta;
            idx = next(idx);
        }
    }

    private int[] fill(int[] values) {
        int n = values.length;
        int[] f_tree = new int[n+1];
        for (int i = 0; i < n; i++) {
            int idx = i+1;
            while (idx < n+1) {
                f_tree[idx] += values[i];
                idx = idx + (idx & (~idx+1));
            }
        }
        return f_tree;
    }

    public static void main(String[] args) {
        test3();
        test1();
        test2();
    }

    public static void test1() {
        int[] nums = {3,1,4,2,5};
        int[][] queries = {{2,3,4},{1,0,4}};
        Solution sol = new Solution();
        List<Integer> output = sol.countOfPeaks(nums, queries);
        List<Integer> expOutput = Arrays.stream(new int[]{0})
            .boxed()
            .collect(Collectors.toList());
        boolean passed = output.equals(expOutput);
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        int[] nums = {4,1,4,2,1,5};
        int[][] queries = {{2,2,4},{1,0,2},{1,0,4}};
        Solution sol = new Solution();
        List<Integer> output = sol.countOfPeaks(nums, queries);
        List<Integer> expOutput = Arrays.stream(new int[]{0,1})
            .boxed()
            .collect(Collectors.toList());
        boolean passed = output.equals(expOutput);
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    public static void test3() {
        int[] nums = {7,10,7};
        int[][] queries = {{1,2,2},{2,0,6},{1,0,2}};
        Solution sol = new Solution();
        List<Integer> output = sol.countOfPeaks(nums, queries);
        List<Integer> expOutput = Arrays.stream(new int[]{0,1})
            .boxed()
            .collect(Collectors.toList());
        boolean passed = output.equals(expOutput);
        System.out.println("test3: " + (passed ? "passed" : "failed"));
    }

}