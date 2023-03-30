class KthLargest {

    // minheap
    int [] a;
    int size = 0;
    int k = 0;

    private int left(int i) {
        return i*2;
    }

    private int right(int i) {
        return i*2+1;
    }

    private int parent(int i) {
        return i/2;
    }

    private void swap(int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private void siftdown(int i) {
        while (2*i < a.length) {
            int j = i;
            if (a[2*i] < a[j]) {
                j = 2*i;
            }
            if (2*i+1<a.length && a[2*i+1] < a[j]) {
                j = 2*i+1;
            }
            if (i==j) {
                break;
            }
            swap(i, j);
            i=j;
        }
    }

    private void siftup(int i) {
        while (i/2>=1) {
            if (a[i/2] <= a[i]) {
                break;
            }
            swap(i/2, i);
            i = i/2;
        }
    }

    public KthLargest(int k, int[] nums) {
        this.k = k;
        a = new int[k+1];

        int n = nums.length;
        if (k <= n) {
            heapifyPlusInsert(nums);
        } else {
        }
    }

    private void heapifyPlusInsert(int[] nums) {
        size = k;
        for (int i = 0; i < k; i++) {
            a[i+1] = nums[i];
        }

        for (int i = k/2; i>=1; i--) {
            siftdown(i);
        }

        int n = nums.length;
        for (int i = k; i < n; i++) {
            add(nums[i]);
        }
    }
    
    public int add(int val) {
        if (val > a[1]) { 
            a[1] = val; 
            siftdown(1);
        }

        return a[1];
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */