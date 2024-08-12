import java.util.HashSet;
import java.util.HashMap;

class Solution {
    public int countGoodNodes(int[][] edges) {
        HashMap<Integer, HashSet<Integer>> G = new HashMap<>();
        for (int[] e : edges) {
            HashSet<Integer> set = G.getOrDefault(e[0], new HashSet<>());
            set.add(e[1]);
            G.put(e[0], set);
            HashSet<Integer> set2 = G.getOrDefault(e[1], new HashSet<>());
            set2.add(e[0]);
            G.put(e[1], set2);
        }
        int[] acc = {0};
        helper(0, G, null, acc);
        return acc[0];
    }
    private int helper(Integer node, HashMap<Integer, HashSet<Integer>> G, Integer parent, int[] acc) {
        int size = 0;
        int first_size = 0;
        boolean all_same = true;
        HashSet<Integer> chs = G.get(node);
        if (chs != null) {
            for (Integer ch : chs) {
                if (ch == parent) {
                    continue;
                }
                int ch_size = helper(ch, G, node, acc);
                if (first_size == 0) {
                    first_size = ch_size;
                } else if (first_size != ch_size) {
                    all_same = false;
                }
                size += ch_size;
            }
        }
        if (all_same) {
            acc[0]++;
        }
        size++;
        return size;
    }

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        int[][] edges = {
            {0,1},{0,2},{1,3},{1,4},{2,5},{2,6}
        };
        Solution sol = new Solution();
        int output = sol.countGoodNodes(edges);
        int t = 1;
    }
}