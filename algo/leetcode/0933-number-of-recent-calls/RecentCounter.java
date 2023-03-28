class RecentCounter {

    private Node head;
    private Node tail;
    private int size = 0;

    class Node {
        public int t;
        public Node next;
        public Node prev;

        public Node(int t, Node next, Node prev) {
            this.t = t;
            this.next = next;
            this.prev = prev;
        }
    }

    public RecentCounter() {
        tail = new Node(-1, null, null);
        head = new Node(-1, tail, null);
        tail.prev = head;
    }
    
    public int ping(int t) {
        Node headNext = head.next;
        head.next = new Node(t, headNext, head);
        headNext.prev = head.next;
        size++;

        Node tailPrev = tail.prev;
        while (t != -1 && t-tailPrev.t > 3_000) {
            Node tailPrevPrev = tailPrev.prev;
            tailPrev.next = null;
            tailPrev.prev = null;
            tailPrevPrev.next = tail;
            tail.prev = tailPrevPrev;
            tailPrev = tailPrevPrev;
            size--;
        }
        return size;
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */