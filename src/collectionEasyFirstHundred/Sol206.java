package collectionEasyFirstHundred;

import collectionUtils.ListNode;

/**
 * Created by Amos on 2017/9/1.
 * Reverse Linked List
 */
public class Sol206 {
    public ListNode reverseList(ListNode head) {
        // if(head == null) {  return null;}

        ListNode prev = null;
        ListNode cur = head;

        while(cur != null) {
            ListNode next = cur.next;
            cur.next = prev;

            prev = cur;
            cur = next;
        }

        return prev;
    }
}
