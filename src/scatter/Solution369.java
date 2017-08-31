package scatter;

import collectionUtils.ListNode;

public class Solution369 {

    public ListNode plusOne(ListNode head) {
        if(head == null ){  return new ListNode(1);}
        if(head.val == 0){  head.val = 1;   return head;}
        
        ListNode prev = head;   ListNode cursor = head.next;       
        while(cursor != null){
            ListNode tmp = cursor.next;
            cursor.next = prev; prev = cursor;	cursor = tmp;   
        }
        head.next = null;   int carry = 1;        
        cursor = prev; prev = null;
        while(cursor != null){
            if(carry == 1){
                if(carry + cursor.val == 10){
                    cursor.val = 0;
                }else{
                    carry =0;
                    cursor.val += 1;
                }
            }
            ListNode tmp = cursor.next;
            cursor.next = prev; prev = cursor;	cursor = tmp;              
        }
        if(carry == 1){
            ListNode nhead = new ListNode(1);
            nhead.next = prev;  
            return nhead;
        }else{	return prev;	}
    }

}
