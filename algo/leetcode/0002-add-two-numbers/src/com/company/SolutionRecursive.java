package com.company;

public class SolutionRecursive {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2!=null){
            l1.val+=l2.val;
        }
        if(l1.val>=10){
            if(l1.next!=null){
                l1.next.val++;
            }else{
                l1.next=new ListNode(1);
            }
            l1.val-=10;
        }
        if(l2!=null){
            l1.next=addTwoNumbers(l1.next,l2.next);
        }else{
            l1.next=addTwoNumbers(l1.next,null);
        }
        return l1;
    }
}
