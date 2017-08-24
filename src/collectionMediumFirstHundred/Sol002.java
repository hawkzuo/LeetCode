package collectionMediumFirstHundred;

import collectionUtils.ListNode;

/**
 * Created by Amos on 2017/7/12.
 * Add Two Numbers
 */
public class Sol002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode p1 = l1;   ListNode p2 = l2;
        ListNode dummy = new ListNode(-1);  ListNode prev = dummy;
        int carry = 0;

        while(p1 != null && p2 != null){
            int currentValue = p1.val + p2.val + carry;
            carry = currentValue / 10;
            ListNode newNode = new ListNode(currentValue %10);
            prev.next = newNode;  prev = newNode;
            p1 = p1.next;   p2 = p2.next;
        }

        if (p1 != null || p2 != null) {
            if(p1 == null){
                while(p2 != null){
                    int val = p2.val+carry;
                    carry = val/10;
                    ListNode newNode = new ListNode(val %10);
                    prev.next = newNode;  prev = newNode;
                    p2 = p2.next;
                }
            }else{
                //p2 == null
                while(p1 != null){
                    int val = p1.val+carry;
                    carry = val/10;
                    ListNode newNode = new ListNode(val %10);
                    prev.next = newNode;  prev = newNode;
                    p1 = p1.next;
                }
            }
        }
        //Finally take care of carry-bit
        if(carry != 0){
            prev.next = new ListNode(carry);
        }
        return dummy.next;
    }
}
