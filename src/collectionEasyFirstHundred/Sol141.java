package collectionEasyFirstHundred;

import collectionUtils.ListNode;

/**
 * Created by Amos on 2017/8/25.
 * Linked List Cycle
 */
public class Sol141 {
    // Idea: Fast & slow pointers

    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
//          Detect the circle.
//          Now the current node and head node are about equidistant from the the node where the cycle begins.
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}
