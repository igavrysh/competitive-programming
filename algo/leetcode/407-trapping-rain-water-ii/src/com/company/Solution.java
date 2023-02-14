package com.company;

import java.util.PriorityQueue;

class Solution {
    private int[][] dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}}; 

    public int trapRainWater(int[][] heightMap) {
        if (heightMap.length == 0) { return -1; }
        boolean[][] visited = new boolean[heightMap.length][heightMap[0].length];
        PriorityQueue<Integer[]> Q = new PriorityQueue<>((Integer[] a, Integer[] b) -> { return a[2] - b[2]; });
        int iN = heightMap.length, jN = heightMap[0].length;
        for (int i = 0; i < iN; i++) {
            Q.add(new Integer[]{i, 0, heightMap[i][0]});
            visited[i][0] = true;
            Q.add(new Integer[]{i, jN-1, heightMap[i][jN-1]});
            visited[i][jN-1] = true;
        }
        for (int j = 0; j < jN; j++) {
            Q.add(new Integer[]{0, j, heightMap[0][j]});
            visited[0][j] = true;
            Q.add(new Integer[]{iN-1, j, heightMap[iN-1][j]});
            visited[iN-1][j] = true;
        }

        int output = 0;
        while (!Q.isEmpty()) {
            Integer[] cell = Q.poll();
            for (int d = 0; d < dirs.length; d++) {
                int nxtI = cell[0]+dirs[d][0];
                int nxtJ = cell[1]+dirs[d][1];
                if (nxtI >= 0 && nxtI < iN && nxtJ >= 0 && nxtJ < jN && !visited[nxtI][nxtJ]) {
                    visited[nxtI][nxtJ] = true;
                    if (heightMap[nxtI][nxtJ] < cell[2]) {
                        output += cell[2]-heightMap[nxtI][nxtJ];
                        Q.offer(new Integer[]{nxtI, nxtJ, cell[2]});
                    } else {
                        Q.offer(new Integer[]{nxtI, nxtJ, heightMap[nxtI][nxtJ]});
                    }
                }
            }
        }
        
        return output;
    }
}