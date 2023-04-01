class SolutionInplace {
    // child(i) = (i+1)*2-1, (i+1)*2 
    // parent(i) = (i-1)/2
    private void siftdown(int i, int length, int[] a) {
        while ((i+1)*2-1<length && (i+1)*2-1>=0) {
            int j = i;
            if (a[(i+1)*2-1] > a[j]) {
                j = (i+1)*2-1;
            }

            if ((i+1)*2<length && a[(i+1)*2] > a[j]) {
                j = (i+1)*2;
            }

            if (i==j) {
                break;
            }

            swap(i, j, a);

            i = j;
        }
    }

    private void swap(int i, int j, int[] a) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private void heapify(int[] a) {
        int n = a.length;
        for (int i = n/2-1; i>=0; i--) {
            siftdown(i, n, a);
        }
    }

    public int lastStoneWeight(int[] stones) {
        heapify(stones);
        int length = stones.length;
        while (length > 1) {
            int stone1 = stones[0];
            length--;
            stones[0] = stones[length];
            siftdown(0, length, stones);
            int stone2 = stones[0];

            if (stone1 != stone2) {
                stones[0] = stone1-stone2;
                siftdown(0, length, stones);
            } else {
                length--;
                stones[0] = stones[length];
                siftdown(0, length, stones);
            }
        }
        return length == 0 ? 0 : stones[0];
    }
}
