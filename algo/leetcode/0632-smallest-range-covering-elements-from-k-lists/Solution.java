import java.util.Queue;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;;
class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] p1, int[] p2) -> {
            return Integer.compare(
                nums.get(p1[0]).get(p1[1]), nums.get(p2[0]).get(p2[1])
            );
        });
        for (int i=0; i<nums.size(); i++) {
            pq.offer(new int[]{i,0});
        }
        int min_len = Integer.MAX_VALUE;
        int[] min_range_bounds = {-1,-1};
        int[] fq = new int[nums.size()];
        int curr_set_size = 0;
        int full_set_size = nums.size();
        Queue<int[]> curr_window = new LinkedList<>();
        while (!pq.isEmpty()) {
            int[] r_pair = pq.poll();
            fq[r_pair[0]]++;
            if (fq[r_pair[0]] == 1) {
                curr_set_size++;
            }
            curr_window.offer(r_pair);
            while (curr_set_size == full_set_size) {
                int[] l_pair = curr_window.poll();
                int l_bound = nums.get(l_pair[0]).get(l_pair[1]);
                int r_bound = nums.get(r_pair[0]).get(r_pair[1]);
                if (min_len > r_bound-l_bound) {
                    min_len = r_bound-l_bound;
                    min_range_bounds = new int[]{l_bound,r_bound};
                }
                fq[l_pair[0]]--;
                if (fq[l_pair[0]] == 0) {
                    curr_set_size--;
                }
            }
            if (r_pair[1]+1 < nums.get(r_pair[0]).size()) {
                pq.offer(new int[]{r_pair[0], r_pair[1]+1});
            }
        }
        return min_range_bounds;
    }

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        int[][] nums_in = {{4,10,15,24,26},{0,9,12,20},{5,18,22,30}};
        List<List<Integer>> nums = new ArrayList<>();
        for (int i=0; i<nums_in.length; i++) {
            List<Integer> a = new ArrayList<>();
            for (int j=0; j<nums_in[i].length; j++) {
                a.add(nums_in[i][j]);
            }
            nums.add(a);
        }
        int[] exp_output = {20,24};
        Solution sol = new Solution();
        int[] output = sol.smallestRange(nums);
        boolean passed = Arrays.equals(output, exp_output);
        System.out.println("test1:"+(passed ? "passed" : "failed"));
    }
}