package scatter;

import collectionUtils.ListNode;

public class Solution002 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;   ListNode p2 = l2;   
        ListNode dummy = new ListNode(-1);  ListNode prev = dummy;       
        int carry = 0;
        while(p1 != null && p2 != null){
            int cVal = p1.val + p2.val + carry;
            carry = cVal / 10;
            ListNode nnode = new ListNode(cVal %10);
            prev.next = nnode;  prev = nnode;
            p1 = p1.next;   p2 = p2.next;
        }        
        if(p1 == null && p2 == null){
            ;
        }else if(p1 == null){
            while(p2 != null){
                int val = p2.val+carry;
                carry = val/10;
                ListNode nnode = new ListNode(val %10);
                prev.next = nnode;  prev = nnode;
                p2 = p2.next;
            }
        }else{
            //p2 == null
            while(p1 != null){
                int val = p1.val+carry;
                carry = val/10;
                ListNode nnode = new ListNode(val %10);
                prev.next = nnode;  prev = nnode;
                p1 = p1.next;
            }            
        }               
        //Finally take care of carry-bit
        if(carry == 0){ return dummy.next;  }
        ListNode fin = new ListNode(carry);    prev.next = fin;
        return dummy.next;        
    }

}
