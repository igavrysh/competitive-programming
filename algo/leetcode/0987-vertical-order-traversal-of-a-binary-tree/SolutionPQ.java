import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class SolutionPQ {

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        Map<Integer, Queue<Element>> colMap = new HashMap<>();
        Queue<Element> queue = new LinkedList<>();
        queue.add(new Element(0, 0, root));
        int minCol = Integer.MAX_VALUE;
        int maxCol = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            var el = queue.remove();

            var mapQueue = colMap.get(el.col);
            if (mapQueue == null) {
                mapQueue = new PriorityQueue<>();
            }
            mapQueue.add(el);
            colMap.put(el.col, mapQueue);

            if (el.treeNode.left != null) {
                queue.add(new Element(el.row + 1, el.col - 1, el.treeNode.left));
            }
            if (el.treeNode.right != null) {
                queue.add(new Element(el.row + 1, el.col + 1, el.treeNode.right));
            }
            minCol = Math.min(minCol, el.col);
            maxCol = Math.max(maxCol, el.col);

        }
        var result = new ArrayList<List<Integer>>();
        for (int i = minCol; i <= maxCol; i++) {
            var tList = new ArrayList<Integer>();
            var q = colMap.get(i);
            while (!q.isEmpty()) {
                tList.add(q.remove().treeNode.val);
            }
            result.add(tList);
        }

        return result;
    }

    private class Element implements Comparable<Element>{
        int row;
        int col;
        TreeNode treeNode;

        public Element(int row, int col, TreeNode treeNode) {
            this.row = row;
            this.col = col;
            this.treeNode = treeNode;
        }

        @Override
        public int compareTo(Element o) {
            int rowDiff = this.row - o.row;
            if (rowDiff == 0) {
                return this.treeNode.val - o.treeNode.val;
            }
            return rowDiff;
        }
    }
}
