import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

public class SolutionByLevels {
    static class Pair {
        public TreeNode node;
        public int height;
        public Pair(TreeNode node, int height) {
            this.height = height;
            this.node = node;
        }
    }

    public int[] treeQueries(TreeNode root, int[] queries) {
        int[] result = new int[queries.length];
        HashMap<TreeNode, Integer> node2Lev = new HashMap<>();
        HashMap<Integer, TreeNode> id2Node = new HashMap<>();
        ArrayList<Pair[]> levels = new ArrayList<>();
        levels.add(new Pair[2]);
        dfs(root, 0, levels, node2Lev, id2Node);
        for (int i = 0; i < queries.length; i++) {
            int idNode = queries[i];
            TreeNode node = id2Node.get(idNode);
            int l = node2Lev.get(node);
            Pair[] level = levels.get(l);
            int maxHeightOfOtherNodes = -1;
            for (int j = 0; j < level.length; j++) {
                Pair p = level[j];
                if (p != null && p.node != node) {
                    maxHeightOfOtherNodes = Math.max(maxHeightOfOtherNodes, p.height);
                }
            }
            result[i] = maxHeightOfOtherNodes == -1 ? l-1 : l+maxHeightOfOtherNodes;
        }
        return result;
    }

    public int dfs(TreeNode node, int l, ArrayList<Pair[]> levels, 
        HashMap<TreeNode, Integer> node2Lev, HashMap<Integer, TreeNode> id2Node
    ) {
        node2Lev.put(node, l);
        id2Node.put(node.val, node);
        if (node.left == null && node.right == null) {
            Pair[] level = levels.get(l);
            Pair p = new Pair(node, 0);
            if (level[0] == null) {
                level[0] = p;
            } else if (level[1] == null) {
                level[1] = p;
            }
            return 1;
        }

        if (levels.size()-1 < l+1) {
            levels.add(new Pair[2]);
        }
        int lheight = 0;
        int rheight = 0;
        if (node.left != null) {
            lheight = dfs(node.left, l+1, levels, node2Lev, id2Node);
        } 
        if (node.right != null) {
            rheight = dfs(node.right, l+1, levels, node2Lev, id2Node);
        }
        Pair[] level = levels.get(l);
        Pair p = new Pair(node, Math.max(lheight, rheight));
        if (level[0] == null) {
            level[0] = p;
        } else {
            if (level[0].height <= p.height) {
                level[1] = level[0];
                level[0] = p;
            } else if (level[1] == null) {
                level[1] = p;
            } else if (level[1].height < p.height) {
                level[1] = p;
            }
        }
        return 1 + Math.max(lheight, rheight);
    }

    public static void main(String[] args) {
        test2();

        test1();
        test3();
    }

    public static void test1() {
        TreeNode root = new TreeNode(
            1,
            new TreeNode(
                3,
                new TreeNode(2),
                null),
            new TreeNode(
                4,
                new TreeNode(6),
                new TreeNode(
                    5,
                    null,
                    new TreeNode(7)
                ))
        );
        int[] queries = {4};
        int[] expOutput = {2};
        SolutionByLevels sol = new SolutionByLevels();
        int[] output = sol.treeQueries(root, queries);
        boolean passed = Arrays.equals(output, expOutput);
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        TreeNode root = new TreeNode(
            5,
            new TreeNode(
                8,
                new TreeNode(
                    2,
                    new TreeNode(4),
                    new TreeNode(6)),
                new TreeNode(1)),
            new TreeNode(
                9,
                new TreeNode(3),
                new TreeNode(7))
        );
        int[] queries = {3,2,4,8};
        int[] expOutput = {3,2,3,2};
        SolutionByLevels sol = new SolutionByLevels();
        int[] output = sol.treeQueries(root, queries);
        boolean passed = Arrays.equals(output, expOutput);
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    public static void test3() {
        TreeNode root = new TreeNode(
            1,
            null,
            new TreeNode(
            5,
                new TreeNode(
                    3,
                    new TreeNode(2),
                    new TreeNode(4)),
                null)
        );
        int[] queries = {3,5,4,2,4};
        int[] expOutput = {1,0,3,3,3};
        SolutionByLevels sol = new SolutionByLevels();
        int[] output = sol.treeQueries(root, queries);
        boolean passed = Arrays.equals(output, expOutput);
        System.out.println("test3: " + (passed ? "passed" : "failed"));
    }
}
