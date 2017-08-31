package listquestions;

import collectionUtils.ListNode;

import java.util.HashMap;

public class Solution142 {

	public Solution142() {
		// TODO Auto-generated constructor stub
	}
    public ListNode detectCycle(ListNode head) {
        if(head == null)
            return null;
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
//          Detect the circle. 
//          Now the current node and head node are about equidistant from the the node where the cycle begins.
            if(slow == fast){
                while(head != slow){
                    head = head.next;
                    slow = slow.next;
                }
                return head;
            }
        }
        return null;
        
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
