import java.util.ArrayList;

class SnapshotArray {

    public static class Pair {
        public int val;
        public int snapId;
        public Pair(int val, int snapId) {
            this.val = val;
            this.snapId = snapId;
        }
    }

    int globalSnapId = 0;
    ArrayList<Pair>[] data;

    @SuppressWarnings("unchecked")
    public SnapshotArray(int length) {
        data = new ArrayList[length];
        for (int i = 0; i < length; i++) {
            data[i] = new ArrayList<>() {{ add(new Pair(0, -1)); }};
        }
    }
    
    public void set(int index, int val) {
        int sz = data[index].size();
        if (sz > 0) {
            Pair pair = data[index].get(sz-1);
            if (pair.snapId != globalSnapId) {
                data[index].add(new Pair(val, globalSnapId));
            } else {
                pair.val = val;
            }
        } else {
            data[index].add(new Pair(val, globalSnapId));
        }
    }
    
    public int snap() {
        int output = globalSnapId;
        globalSnapId++;
        return output;
    }
    
    public int get(int index, int snap_id) {
        // good = right part, e.g. pairs with snap id > given snap id (all values in right part are not valid for answer)
        // bad = left part, e.g. pairs with snap id <= given snap id (all values in left part are valid for answer, 
        // take the highest snap id value to return result)
        ArrayList<Pair> a = data[index];
        int l = -1;
        int r = a.size();
        while (r - l > 1) {
            int m = l + (r-l)/2;
            Pair mPair = a.get(m);
            if (snap_id < mPair.snapId) {
                r = m;
            } else if (snap_id >= mPair.snapId) {
                l = m;
            }
        }
        return a.get(l).val;
    }

    public static void main(String[] args) {
        test4();
        test3();
        test2();
        test1();
    }

    public static void test1() {
        SnapshotArray sa = new SnapshotArray(3);
        boolean passed = true;
        sa.set(0, 5);
        passed = passed && (sa.snap() == 0);
        sa.set(0, 6);
        passed = passed && (sa.get(0, 0) == 5);
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        boolean passed = true;
        SnapshotArray sa = new SnapshotArray(4);
        passed = passed && (sa.snap() == 0);
        passed = passed && (sa.snap() == 1);
        passed = passed && (sa.get(3, 1) == 0);
        sa.set(2, 4);
        passed = passed && (sa.snap() == 2);
        sa.set(1, 4);
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    public static void test3() {
        boolean passed = true;
        SnapshotArray sa = new SnapshotArray(2);
        passed = passed && (sa.snap() == 0);
        passed = passed && (sa.get(1, 0) == 0);
        passed = passed && (sa.get(0, 0) == 0);
        sa.set(1, 8);
        passed = passed && (sa.get(1, 0) == 0);
        sa.set(0, 20);
        passed = passed && (sa.get(0, 0) == 0);
        sa.set(0, 7);
        System.out.println("test3: " + (passed ? "passed" : "failed"));
    }

    public static void test4() {
        /*
["SnapshotArray",   "snap", "snap", "set",  "snap", "get",  "set",  "get",  "snap", "get"]
[[1],               [],     [],     [0,4],  [],     [0,1],  [0,12], [0,1],  [],     [0,3]]
        */
        boolean passed = true;
        SnapshotArray sa = new SnapshotArray(1);
        passed = passed && (sa.snap() == 0); // after sa.snap() => globalSnapId = 1
        passed = passed && (sa.snap() == 1); // after => globalSnapId = 2
        sa.set(0, 4);  // index = 0, val = 4, snapid = 2
        passed = passed && (sa.snap() == 2);
        passed = passed && (sa.get(0, 1) == 0);
        sa.set(0, 12);
        passed = passed && (sa.get(0, 1) == 0);
        passed = passed && (sa.snap() == 3);
        System.out.println("test4: " + (passed ? "passed" : "failed"));
    }

}