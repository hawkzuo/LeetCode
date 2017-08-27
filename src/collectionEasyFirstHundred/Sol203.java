package collectionEasyFirstHundred;

import collectionUtils.ListNode;

/**
 * Created by Amos on 2017/8/27.
 * Remove Linked List Elements
 */
public class Sol203 {
    // Idea: Brute-force visiting and with the help of dummy node
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = head;    ListNode prev = dummy;
        while(cur != null) {
            if(cur.val == val) {
                cur = cur.next;
            } else {
                prev.next = cur;
                prev = cur;
                cur = cur.next;
            }
        }
        // Final take care
        prev.next = null;

        return dummy.next;
    }
}
