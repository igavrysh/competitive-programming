public class MyCircularDeque {

    private int capacity;
    private int size;

    private Node sentFront;
    private Node sentLast;
    
    public class Node {
        int value;
        Node next;
        Node prev;
        public Node(int value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    public MyCircularDeque(int k) {
        capacity = k;
        sentLast = new Node(-1, null, null);
        sentFront = new Node(-1, sentLast, null);
        sentLast.prev = sentFront;
    }
    
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        Node node = new Node(value, sentFront.next, sentFront);
        node.next.prev = node;
        sentFront.next = node;
        size++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        Node node = new Node(value, sentLast, sentLast.prev);
        sentLast.prev = node;
        node.prev.next = node;
        size++;
        return true;
    }
    
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        Node deleteNode = sentFront.next;
        sentFront.next = deleteNode.next;
        deleteNode.next.prev = sentFront;
        size--;
        return true;
    }
    
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        Node nodeDelete = sentLast.prev;
        nodeDelete.prev.next = sentLast;
        sentLast.prev = nodeDelete.prev;
        size--;
        return true;
    }
    
    public int getFront() {
        return sentFront.next.value;
    }
    
    public int getRear() {
        return sentLast.prev.value;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == capacity;
    }
}