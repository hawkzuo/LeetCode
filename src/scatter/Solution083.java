package scatter;

import collectionUtils.ListNode;

public class Solution083 {

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){  return head;}        
        ListNode cur = head.next;    ListNode prev = head;       
        while(cur != null){
            if(cur.val == prev.val){
                cur = cur.next;
            }else{
                //Update
                prev.next = cur;    prev = cur;
                cur = cur.next;
            }
        }
        prev.next = cur;
        return head;
    }
}
