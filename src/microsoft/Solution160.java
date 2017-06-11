package microsoft;

public class Solution160 {

	public Solution160() {
		// TODO Auto-generated constructor stub
	}

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
    	if(headA == null || headB == null){ return null;}
    	
    	ListNode t1 = headA;	ListNode t2 = headB;
    	int lenA = 0;	int lenB = 0;
    	
    	while(t1 != null){
    		lenA++;
    		t1 = t1.next;    		
    	}
    	while(t2 != null){
    		lenB++;
    		t2 = t2.next;
    	}
    	
    	int diff = lenA - lenB;
    	
    	t1 = headA; t2 = headB;
    	
    	if(diff > 0){
    		for(int i=0; i<lenA-lenB ; i++){
    			t1 = t1.next;   		
    		}
    	}
    	else if(diff < 0){
    		for(int i=0; i<-lenA+lenB ; i++){
    			t2 = t2.next;   		
    		}    		    		    		
    	}else{
    		;
    	}
    	
    	while(t1 != null && t2 != null){
    		if(t1 == t2){
    			return t1;
    		}else{
    			t1 = t1.next; 
    			t2 = t2.next;
    		}   		    		
    	}
    	
    	return null;
    }	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution160 s = new Solution160();
		
		ListNode h1 = new ListNode(1);ListNode h2 = new ListNode(10);
		ListNode a2 = new ListNode(2);ListNode b2 = new ListNode(11);
		ListNode a3 = new ListNode(3);ListNode b3 = new ListNode(12);
		
		ListNode c1 = new ListNode(5);ListNode c2 = new ListNode(5);ListNode c3 = new ListNode(5);ListNode c4 = new ListNode(5);
		c1.next = c2; c2.next =c3; c3.next = c4;
		
		//h1.next=a2;	h2.next = b2;
		//a2.next = c1;
		//b2.next =b3; b3.next=c1;
		
		h1.next=c1;
		h2.next = b2; b2.next=b3;b3.next=c1;
		
		System.out.print(s.getIntersectionNode(c1, h2));
		
		
		
	}	
	
	
	
	
	
	
	
	
	
	
}
