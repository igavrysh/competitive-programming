class SeatManager {
    int[] heap;
    int length;
    int marker;
    int n;
    
    public SeatManager(int n) {
        heap = new int[n+1];
        marker = 1;
        length = 0;
        this.n = n;
    }

    private void swap(int i, int j, int[] heap) {
        int tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

    private void siftdown(int i, int[] heap) {
        int child1 = i*2;
        int child2 = i*2 + 1;
        if (child1 > length) { return; }
        if (heap[i] > heap[child1] 
            && (
                child2 > length 
                || heap[child1] < heap[child2]
            )
        ) {
            swap(i, child1, heap);
            siftdown(child1, heap);
        } else if (child2 <= length && heap[i] > heap[child2]) {
            swap(i, child2, heap);
            siftdown(child2, heap);
        }
    }

    private void siftup(int i, int[] heap) {
        int parent = i / 2;
        if (heap[i] < heap[parent]) {
            swap(i, parent, heap);
            if (parent != 1) {
                siftup(parent, heap);
            }
        }
    }
    
    public int reserve() {
        if (length == n+1) {
            marker = 1;
            length = 0;
        }
        if (length != 0) {
            int output = heap[1];
            heap[1] = heap[length];
            length--;
            siftdown(1, heap);
            return output;
        }

        int seatNumber = marker;
        marker++;
        return seatNumber;
    }
    
    public void unreserve(int seatNumber) {
        length++;
        heap[length] = seatNumber;
        siftup(length, heap);
    }
}
