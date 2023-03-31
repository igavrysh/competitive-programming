import java.sql.Blob;

public class Main {
    public static void main(String[] args) {
        testKthLargest1();
        testKthLargest2();
        testKthLargest3();
    }

    public static void testKthLargest1() {
        boolean passed = true;
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        passed = passed && (kthLargest.add(3) == 4);   // return 4
        passed = passed && (kthLargest.add(5) == 5);   // return 5
        passed = passed && (kthLargest.add(10) == 5);  // return 5
        passed = passed && (kthLargest.add(9) == 8);   // return 8
        passed = passed && (kthLargest.add(4) == 8);   // return 8
        System.out.println("testKthLargest1: " + (passed ? "passed" : "failed"));
    }
    
    public static void testKthLargest2() {
        boolean passed = true;
        KthLargest kthLargest = new KthLargest(1, new int[]{});
        passed = passed && (kthLargest.add(-3) == -3);
        passed = passed && (kthLargest.add(-2) == -2);
        passed = passed && (kthLargest.add(-4) == -2);
        passed = passed && (kthLargest.add(0) == 0);
        passed = passed && (kthLargest.add(-4) == 0);
        System.out.println("testKthLargest2: " + (passed ? "passed" : "failed"));
    }

    public static void testKthLargest3() {
        boolean passed = true;
        KthLargest kthLargest = new KthLargest(3, new int[]{ 5, -1 });
        passed = passed && (kthLargest.add(2) == -1);
        passed = passed && (kthLargest.add(1) == 1);
        passed = passed && (kthLargest.add(-1) == 1);
        passed = passed && (kthLargest.add(3) == 2);
        passed = passed && (kthLargest.add(4) == 3);
        System.out.println("testKthLargest3: " + (passed ? "passed" : "failed"));
    }
}
