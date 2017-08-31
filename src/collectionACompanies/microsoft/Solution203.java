package collectionACompanies.microsoft;

import collectionUtils.ListNode;

public class Solution203 {

	public Solution203() {
		// TODO Auto-generated constructor stub
	}

    public ListNode removeElements(ListNode head, int val) {
        
    	if(head == null ){return null;}
    	
    	ListNode nhead = head;
    	
    	ListNode p = null;
    	ListNode now = head;
    	
    	//Deal with head node
    	while(now != null && now.val == val){
    		now = now.next;
    	}
    	if(now == null){return p;}
    	
    	//Update newhead
    	nhead = now;
    	
    	//Begin finding value
    	while(now != null){
    		
    		if(now.val == val){
    			//Move over the duplicate vals
	    		while( now != null && now.val == val){
	    			now = now.next;
	    		}
	    		if(now == null){
	    			//Reach the end of list
	    			p.next = now;
	    			return nhead;
	    			
	    		}else{
	    			//Just change p's pointer
	    			p.next = now;	    			
	    		}	    		
    		}
    		//Move on to find another same value
    		p = now;
    		now = now.next;
    		
    	}
    	//Reach end of list
    	return nhead;   	
    	
    }	
	
	
}
