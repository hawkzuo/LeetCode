package collectionMediumFirstHundred;

import collectionUtils.ListNode;

/**
 * Created by Amos on 2017/8/10.
 * Linked List Cycle II
 */
public class Sol142 {
    public ListNode detectCycle(ListNode head) {
        if(head == null)
            return null;
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
//          Detected the circle.
//          Now the current node and head node are about equidistant from the the node where the cycle begins.
            if(slow == fast){
                ListNode newHead = head;
                while(newHead != slow){
                    newHead = newHead.next;
                    slow = slow.next;
                }
                return newHead;
            }
        }
        return null;
    }
}
