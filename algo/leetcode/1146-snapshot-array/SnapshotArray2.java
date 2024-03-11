import java.util.TreeMap;

class SnapshotArray2 {

    TreeMap<Integer, Integer>[] map;
    int snap_id;

    public SnapshotArray2(int length) {
        map = new TreeMap[length];
        snap_id = 0;
    }

    public void set(int index, int val) {
        if (map[index] == null) {
            map[index] = new TreeMap<>();
        }
        map[index].put(snap_id, val);
    }

    public int snap() {
        return snap_id++;
    }

    public int get(int index, int snap_id) {
        if (map[index] == null)
            return 0;

        var entry = map[index].floorEntry(snap_id);

        return entry == null ? 0 : entry.getValue();
    }

    public static void main(String[] args) {
        test4();
        test3();
        test2();
        test1();
    }

    public static void test1() {
        SnapshotArray2 sa = new SnapshotArray2(3);
        boolean passed = true;
        sa.set(0, 5);
        passed = passed && (sa.snap() == 0);
        sa.set(0, 6);
        passed = passed && (sa.get(0, 0) == 5);
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        boolean passed = true;
        SnapshotArray2 sa = new SnapshotArray2(4);
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
        SnapshotArray2 sa = new SnapshotArray2(1);
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
