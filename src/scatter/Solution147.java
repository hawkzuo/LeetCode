package scatter;

import java.util.PriorityQueue;

public class Solution147 {

    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null){	return head;}    
        
        ListNode dummy = new ListNode(-1);  ListNode tail = head;   dummy.next = head;
        
        ListNode cur = head.next;
        
        while(cur != null){
            if(cur.val >= tail.val){    
                tail = cur;
                cur = cur.next;
            }
                
            else{
                ListNode next = cur.next;
                tail.next = next;
                
                ListNode cursor = dummy;
                while(cur.val > cursor.next.val){
                    cursor = cursor.next;
                }
                
                cur.next = cursor.next;
                cursor.next = cur;
                
                cur = next;
            }
            
            
        }
      
        return dummy.next;
    }

}
