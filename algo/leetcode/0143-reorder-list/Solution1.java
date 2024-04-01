import java.util.ArrayList;

public class Solution1 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public void reorderList(ListNode head) {    
        ListNode curr = head;
        ArrayList<ListNode> a = new ArrayList<>();
        while (curr != null) {
            a.add(curr);
            curr = curr.next;
        }
        curr = head;
        int aptr = a.size()-1;
        while (curr != null) {
            ListNode node_aptr = a.get(aptr);
            a.get(aptr-1).next = null;

            ListNode curr_next = curr.next;

            node_aptr.next = curr_next;
            curr.next = node_aptr;

            curr = curr_next;
            aptr--;
        }
    }

    public static void test1() {
        ListNode l = new ListNode(
            1,
            new ListNode(
                2,
                new ListNode(
                    3,
                    new ListNode(4)
                )
            )
        );
        
        Solution1 sol = new Solution1();
        sol.reorderList(l);
        ListNode curr = l;
        ArrayList<Integer> outputA = new ArrayList<>();
        while (curr != null) {
            outputA.add(curr.val);
            curr = curr.next;
        }
        ArrayList<Integer> expOutputA = new ArrayList<>() {{
            int[] a = {1,4,2,3};
            for (int i = 0; i < a.length; i++) {
                add(a[i]);
            }
        }};
        boolean passed = outputA.size() == expOutputA.size();
        if (passed) {
            for (int i = 0; i < outputA.size(); i++) {
                passed = passed && outputA.get(i)
                    .equals(expOutputA.get(i));
            }
        }
        System.out.println("test1: " + (passed ? "passed" : "failed"));
        
    }

    public static void main(String[] args) {
        test1();
    }
    
}
