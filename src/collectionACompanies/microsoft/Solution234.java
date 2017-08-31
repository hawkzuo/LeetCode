package collectionACompanies.microsoft;

import collectionUtils.ListNode;

public class Solution234 {

	public Solution234() {
		// TODO Auto-generated constructor stub
	}

    public boolean isPalindrome(ListNode head) {
        
    	if(head == null || head.next == null){return true;}
    	
    	ListNode mid = findMid(head);
    	
    	ListNode nhead = reverse(mid.next);
    	
    	
    	ListNode n1 = head;	ListNode n2 = nhead;
    	//This line should be n2 not n2.next
    	while(n2 != null){
    		if(n1.val == n2.val){
    			n1=n1.next;
    			n2=n2.next;
    		}else{
    			reverse(nhead);
    			return false;
    		}    		    		    		
    	}
    	
    	reverse(nhead);
    	return true;
    	
    	
    }	
	
    public boolean isPalindrome2(ListNode head) {
        return true;
    }		
	
	
    
    
    
    //Q 142
    private ListNode findMid(ListNode head){
    	
    	ListNode fast = head.next;
    	ListNode slow = head;
    	
    	while(fast.next != null && fast.next.next != null){
    		fast = fast.next.next;
    		slow = slow.next ;    		    		
    	}
    	return slow;    	    	    	
    }    
        
    
	//Q 204
    private ListNode reverse(ListNode head){
    	ListNode prev = null;
    	ListNode now = head;
    	
    	while(now != null){
    		ListNode temp = now.next;
    		now.next = prev;
    		prev = now;
    		now = temp;
       	}
    	
    	return prev;    	    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution234 s = new Solution234();
		
		ListNode n1 = new ListNode(1); ListNode n2 = new ListNode(2); ListNode n3 = new ListNode(3); ListNode n4 = new ListNode(3); ListNode n5 = new ListNode(2); ListNode n6 = new ListNode(1);
		
		n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5; n5.next = n6;
		
		System.out.print(s.isPalindrome(n1));
		
		
	}
    
	
}
