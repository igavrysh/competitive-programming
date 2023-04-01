class SolutionInplace {

    private void siftdown(int i, int length, int[] a) {
        while (2*i-1<length && 2*i-1>=0) {
            int j = i;
            if (a[2*i-1] > a[j]) {
                j = 2*i-1;
            }

            if (2*i<length && a[2*i] > a[j]) {
                j = 2*i;
            }

            if (i==j) {
                break;
            }

            swap(i, j, a);

            i = j;
        }
    }

    private void siftup(int i, int[] a) {
        while (i/2-1>=0 && a[i/2-1]<a[i]) {
            swap(i/2-1, i, a);
            i = i/2-1;
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
            int stone2 = stones[1];

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
