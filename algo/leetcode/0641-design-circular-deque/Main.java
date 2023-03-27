public class Main {

    public static void main(String[] args) {
        test1();
    }
    
    public static void test1() {
        boolean passed = true;
        MyCircularDeque myCircularDeque = new MyCircularDeque(3);
        passed = passed && myCircularDeque.insertLast(1);  // return True
        passed = passed && myCircularDeque.insertLast(2);  // return True
        passed = passed && myCircularDeque.insertFront(3); // return True
        passed = passed && !myCircularDeque.insertFront(4); // return False, the queue is full.
        passed = passed && myCircularDeque.getRear() == 2;      // return 2
        passed = passed && myCircularDeque.isFull();       // return True
        passed = passed && myCircularDeque.deleteLast();   // return True
        passed = passed && myCircularDeque.insertFront(4); // return True
        passed = passed && myCircularDeque.getFront() == 4;     // return 4
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }
}
