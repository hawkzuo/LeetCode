package listquestions;

public class Solution141 {

	public Solution141() {
		// TODO Auto-generated constructor stub
	}
    public boolean hasCycle(ListNode head) {
        if(head == null)
            return false;
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
