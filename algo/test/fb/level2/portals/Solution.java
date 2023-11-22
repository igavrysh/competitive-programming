import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public int getSecondsRequired(int R, int C, char[][] G) {
        int[] start = {-1,-1};
        HashMap<Integer, HashSet<Integer>> portals = new HashMap<>();
        HashSet<Integer>[] refPortal = new HashSet[('z'-'a'+1)];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int idx = G[i][j]-'a';

                if (G[i][j]-'a'>=0 && G[i][j]-'z'<=0) {
                    if (refPortal[idx] == null) {
                        refPortal[idx] = new HashSet<>();
                    }
                    refPortal[idx].add(i*C+j);
                }

                if (G[i][j] == 'S') {
                    start = new int[]{i,j};
                }
            }
        }
        for (int i = 0; i < refPortal.length; i++) {
            if (refPortal[i] == null) {
                continue;
            }
            for (Integer val : refPortal[i]) {
                portals.put(val, refPortal[i]);
            }
        }

        return bfs(start, R, C, G, portals);
    }

    private int bfs(int[] start, int R, int C, char[][]G, HashMap<Integer, HashSet<Integer>> portals) {
        int[][] dirs = {{0,-1},{0,1},{-1,0},{1,0}};
        Queue<int[]> q = new LinkedList<>();
        int time = 0;
        q.offer(start);
        while (!q.isEmpty()) {
            int level = q.size();
            for (int l = 0; l < level; l++) {
                int[] curr = q.poll();
                int i = curr[0];
                int j = curr[1];

                char currGChar = G[i][j];

                if (currGChar-'a'>=0 && currGChar-'z'<=0) {
                    int idxFrom = i*C+j;
                    HashSet<Integer> ptls = portals.get(idxFrom);
                    for (Integer idxTo : ptls) {
                        int iPortalTo = idxTo / C;
                        int jPortalTo = idxTo % C;
                        if (G[iPortalTo][jPortalTo] != 'V') {
                            q.offer(new int[]{iPortalTo,jPortalTo});
                        }
                    }
                    
                }

                for (int d = 0; d < dirs.length; d++) {
                    int nextI = i + dirs[d][0];
                    int nextJ = j + dirs[d][1];
                    if (!(nextI >= 0 && nextI < R && nextJ >= 0 && nextJ < C)) {
                        continue;
                    }
                    char nextGChar = G[nextI][nextJ]; 
                    if (nextGChar == 'E') {
                        time++;
                        return time;
                    } else if (nextGChar== '.') {
                        q.offer(new int[]{nextI,nextJ});
                    } else if (nextGChar-'a'>=0 && nextGChar-'z'<=0) {
                        q.offer(new int[]{nextI,nextJ});
                    }    
                }

                G[i][j] = 'V';
            }
            time++;
        }
        return -1;
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    public static void test1() {
        int R = 3;
        int C = 3;
        char[][] G = {
            {'.', 'E', '.'},
            {'.', '#', 'E'},
            {'.', 'S', '#'},
        };
        int expectedOutput = 4;
        Solution sol = new Solution();
        int output = sol.getSecondsRequired(R, C, G);
        boolean passed = output == expectedOutput;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        int R = 3;
        int C = 4;
        char[][] G = {
            {'a', '.', 'S', 'a'},
            {'#', '#', '#', '#'},
            {'E', 'b', '.', 'b'},
        };
        int expectedOutput = -1;
        Solution sol = new Solution();
        int output = sol.getSecondsRequired(R, C, G);
        boolean passed = output == expectedOutput;
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    public static void test3() {
        int R = 3;
        int C = 4;
        char[][] G = {
            {'a', 'S', '.', 'b'},
            {'#', '#', '#', '#'},
            {'E', 'b', '.', 'a'},
        };
        int expectedOutput = 4;
        Solution sol = new Solution();
        int output = sol.getSecondsRequired(R, C, G);
        boolean passed = output == expectedOutput;
        System.out.println("test3: " + (passed ? "passed" : "failed"));
    }

    public static void test4() {
        int R = 1;
        int C = 9;
        char[][] G = {
            {'x', 'S', '.', '.', 'x', '.', '.', 'E', 'x'},
        };
        int expectedOutput = 3;
        Solution sol = new Solution();
        int output = sol.getSecondsRequired(R, C, G);
        boolean passed = output == expectedOutput;
        System.out.println("test4: " + (passed ? "passed" : "failed"));
    }

}