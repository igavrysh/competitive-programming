class Solution {

    private HashMap<Integer, Set<Integer>> adjList;

    public int numIslands(char[][] grid) {
        adjList = new HashMap<>();

        int N = grid.length;
        int M = grid[0].length;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                adj = adjList.get(i * N + j);
                if (adjList == null) {
                    adjList = new HashSet<Integer>();
                }

                if (i - 1 >= 0 && j - 1 >= 0) {
                    if (grid[i - 1][j - 1] == '1') {
                        if (!adj.contains((i - 1) * N + j - 1)) {
                            adj.add((i - 1) * N + j - 1);
                        }
                    }
                }
            }
        }

        for (Map.Entry mapElement : adjList.entrySet()) {
            Integer key = (Integer)mapElement.getKey();
            Integer value = ((Integer)mapElement.getValue());

            System.out.println(key + " : " + value);
        }

        return 0;
    }

}