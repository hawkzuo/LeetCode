package collectionEasyFirstHundred;

import collectionUtils.ListNode;

/**
 * Created by Amos on 2017/8/25.
 * Remove Duplicates from Sorted List
 */
public class Sol083 {
    // Idea: Two-Pointers
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
        prev.next = null;
        return head;
    }
}
