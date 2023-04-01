package com.company;

public class SolutionHeap {

    private int[][] p;

    private double distnaceSq(int i) {
        return Math.pow(p[i][0], 2.0) + Math.pow(p[i][1], 2.0);
    }

    // child(i) = (i+1)*2-1, (i+1)*2 
    // parent(i) = (i-1)/2
    private void siftdown(int i, int length) {
        while ((i+1)*2-1<length && (i+1)*2-1>=0) {
            int j = i;
            if (distnaceSq((i+1)*2-1) < distnaceSq(j)) {
                j = (i+1)*2-1;
            }

            if ((i+1)*2<length && distnaceSq((i+1)*2) < distnaceSq(j)) {
                j = (i+1)*2;
            }

            if (i==j) {
                break;
            }

            swap(i, j);

            i = j;
        }
    }

    private void swap(int i, int j) {
        int[] tmp = p[i];
        p[i] = p[j];
        p[j] = tmp;
    }

    private void heapify() {
        int n = p.length;
        for (int i = n/2-1; i>=0; i--) {
            siftdown(i, n);
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        this.p = points;

        heapify();
        int length = points.length;
        int[][] output = new int[k][2];
        int i = 0;
        while (i<k) {
            output[i] = p[0];
            length--;
            p[0] = p[length];
            siftdown(0, length);
            i++;
        }

        return output;
    }
}
