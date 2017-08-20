package companies.microsoft;



//in place method fast as 2ms

public class Solution138Fast {

	public Solution138Fast() {
		// TODO Auto-generated constructor stub
	}
	public RandomListNode copyRandomList(RandomListNode head) {
	    if(head == null) return null;
	    RandomListNode h = head;
	    while(h != null) {
	        RandomListNode copy = new RandomListNode(h.label);
	        RandomListNode next = h.next;
	        h.next = copy;
	        copy.next = next;
	        h = next;
	    }
	    h = head;
	    while(h != null) {
	        if(h.random != null)
	            h.next.random = h.random.next;
	        h = h.next.next;
	    }
	    
	    h = head;
	    RandomListNode newHead = h.next;
	    while(h != null) {
	        RandomListNode copy = h.next;
	        h.next = copy.next;
	        h = h.next;
	        copy.next = h != null ? h.next : null;
	    }
	    
	    return newHead;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
