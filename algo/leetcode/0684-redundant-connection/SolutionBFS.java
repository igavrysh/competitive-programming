import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class SolutionBFS {
 
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] depend = new int[n+1];
        HashSet<Integer>[] adj = new HashSet[n+1];
        for(int i = 0; i <= n; i++) adj[i] = new HashSet<>();
        for(int[] edge: edges) {
            int first = edge[0];
            int second = edge[1];
            depend[first]++;
            depend[second]++;
            adj[second].add(first);
            adj[first].add(second);
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int j = 0; j <= n; j++) {
            if(depend[j] == 1) queue.add(j);
        }
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            depend[cur]--;
            for(int k: adj[cur]) {
                depend[k]--;
                adj[k].remove(cur);
                if(depend[k] == 1) queue.add(k);
            }
        }
        for(int m = n-1 ; m >= 0; m--) {
            if(depend[edges[m][0]] != 0 && depend[edges[m][1]] != 0) return edges[m];
        }
        return edges[0];
    }

    public static void main(String[] args) {
        testSolutionBFS_1();      
    }

    public static void testSolutionBFS_1() {
        int[][] edges = {{2,1},{3,4},{1,4},{2,3}};
        SolutionBFS s = new SolutionBFS();
        int[] output = s.findRedundantConnection(edges);
        int[] expOutput = new int[]{2,3};
        boolean passed = output[0] == expOutput[0] && output[1] == expOutput[1];
        System.out.println("testSolutionBFS_1: " + (passed ? "passed" : "failed"));
    }
}
