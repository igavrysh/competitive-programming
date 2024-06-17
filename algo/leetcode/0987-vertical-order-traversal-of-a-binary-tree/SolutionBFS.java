import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;
public class SolutionBFS {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        HashMap<Integer, ArrayList<Integer>> acc = new HashMap<>();
        HashMap<Integer, HashMap<Integer, Integer>> sizeMap = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        Queue<int[]> meta = new LinkedList<>();
        q.offer(root);
        meta.offer(new int[]{0,0});
        int minOffset = 1;
        int maxOffset = -1;
        while (!q.isEmpty()) {
            int lsize = q.size();
            for (int l = 0; l < lsize; l++) {
                TreeNode node = q.poll();
                int[] mt = meta.poll();
                if (node == null) {
                    continue;
                }
                int level = mt[0];
                int offset = mt[1];
                maxOffset = Math.max(maxOffset, offset);
                minOffset = Math.min(minOffset, offset);
                ArrayList<Integer> a = acc.getOrDefault(offset, new ArrayList<Integer>());
                HashMap<Integer, Integer> offsetMap = sizeMap.getOrDefault(level, new HashMap<>());
                int sz = offsetMap.getOrDefault(offset, 0);
                int ptr = a.size()-1;
                int insertIdx = a.size();
                while(ptr >= a.size()-sz && node.val < a.get(ptr)) {
                    insertIdx = ptr;
                    ptr--;
                }
                a.add(insertIdx, node.val);
                sz++;
                offsetMap.put(offset, sz);
                sizeMap.put(level, offsetMap);
                acc.put(offset, a);
                
                q.offer(node.left);
                meta.offer(new int[]{level+1, offset-1});

                q.offer(node.right);
                meta.offer(new int[]{level+1, offset+1});
            }
        }
        List<List<Integer>> output = new ArrayList<>();
        for (int i = minOffset; i <= maxOffset; i++) {
            output.add(acc.get(i));
        }
        return output;
    }

    public static void main(String[] args) {
        test4();
    }

    public static void test4() {
        TreeNode root = new TreeNode(
            0,
            new TreeNode(8),
            new TreeNode(
                1,
                new TreeNode(
                    3,
                    null,
                    new TreeNode(
                        4,
                        null,
                        new TreeNode(7)
                    )
                ),
                new TreeNode(
                    2,
                    new TreeNode(
                        5,
                        new TreeNode(6),
                        null
                    ),
                    null
                )
            )
        );
        SolutionBFS sol = new SolutionBFS();
        Integer[][] expOutputA = {{8},{0,3,6},{1,4,5},{2,7}};
        List<List<Integer>> expOutput = new ArrayList<>();
        for (Integer[] a : expOutputA) {
            ArrayList<Integer> ia = new ArrayList<Integer>(Arrays.asList(a));
            expOutput.add(ia);
        }
        List<List<Integer>> output = sol.verticalTraversal(root);
        boolean passed = true;
        passed = passed && output.size() == expOutput.size();
        if (passed) {
            for (int i = 0; i < output.size(); i++) {
                List<Integer> eo = expOutput.get(i);
                List<Integer> o = output.get(i);
                passed = passed && o.size() == eo.size();
                if (passed) {
                    for (int j = 0; j < o.size(); j++) {
                        passed = passed && o.get(j).equals(eo.get(j));
                    }
                }
            }
        }
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }
}
