package companies.microsoft;

public class Solution021 {

	public Solution021() {
		// TODO Auto-generated constructor stub
	}
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2){
			if(l1 == null) return l2;
			if(l2 == null) return l1;
			if(l1.val < l2.val){
				l1.next = mergeTwoLists(l1.next, l2);
				return l1;
			} else{
				l2.next = mergeTwoLists(l1, l2.next);
				return l2;
			}
	}	
	
    public ListNode mergeTwoListsOld(ListNode l1, ListNode l2) {
        
    	
    	if(l1 == null){ return l2;}
    	if(l2 == null){	return l1;}

    	//Deal with equality
    	ListNode s1 = null;    	
    	ListNode s2 = null;
    	//Save the last merged node
    	ListNode last = null;
    	//Save the new head pointer
    	ListNode nhead = null;
    	//Two pointers about the current operating nodes
    	ListNode n1 = l1;	ListNode n2 = l2;
    	
    	
    	
    	int v1 = n1.val; int v2 = n2.val;
    	if(v1 == v2){
    		s1=n1;
    		s2=n2;
        	while(n1.next != null){   		
        		if(n1.next.val == v1){
        			n1 = n1.next;
        			
        			
        			//DON'T FORGET TO BREAK THE LOOP
        		}else{
        			break;
        		}
        	}  
        	while(n2.next != null){   		
        		if(n2.next.val == v2){
        			n2 = n2.next;
        		}else{
        			break;
        		}   		
        	}
    		
        	nhead = s1;
        	ListNode t1 = n1.next;	ListNode t2 = n2.next;
        	n1.next = s2;
        	n2.next = null;
        	last = n2;
        	
        	n1 = t1;
        	n2 = t2;
    		
    	}else if(v1 < v2){
    		s1=n1;
    		s2=n2;
        	while(n1.next != null){   		
        		if(n1.next.val <= v2){
        			n1 = n1.next;
        		}else{
        			break;
        		}   		
        	}  
        	while(n2.next != null){   		
        		if(n2.next.val == v2){
        			n2 = n2.next;
        		}else{
        			break;
        		}   		
        	}
    		
        	nhead = s1;
        	ListNode t1 = n1.next;	ListNode t2 = n2.next;
        	n1.next = s2;
        	n2.next = null;
        	last = n2;
        	
        	n1 = t1;
        	n2 = t2;    		
    		
    		
    	}else{
    		
    		s1=n1;
    		s2=n2;
        	while(n1.next != null){   		
        		if(n1.next.val == v1){
        			n1 = n1.next;
        		}else{
        			break;
        		}   		
        	}  
        	while(n2.next != null){   		
        		if(n2.next.val <= v1){
        			n2 = n2.next;
        		}else{
        			break;
        		}   		
        	}    		
    		
    		nhead = s2;
        	ListNode t1 = n1.next;	ListNode t2 = n2.next;    		
    		n2.next = s1;
    		n1.next = null;
    		last = n1;
    		n1 = t1;
    		n2 = t2;
    		
    	}    	
    	
    	
    	if(n1 == null && n2 == null){
    		return nhead;
    	}else if(n1 != null && n2 == null){
    		last.next = n1;
    		return nhead;
    	}else if(n1 == null && n2 != null){
    		last.next = n2;
    		return nhead;
    	}
    	
    	
    	
    	//Looping
    	while(n1 != null && n2 != null){
    		v1 = n1.val;	v2 = n2.val;
        	if(v1 == v2){
        		s1=n1;
        		s2=n2;
            	while(n1.next != null){   		
            		if(n1.next.val == v1){
            			n1 = n1.next;
            		}else{
            			break;
            		}   		
            	}  
            	while(n2.next != null){   		
            		if(n2.next.val == v2){
            			n2 = n2.next;
            		}else{
            			break;
            		}   		
            	}
            	ListNode t1 = n1.next;	ListNode t2 = n2.next;
            	
            	last.next = s1;
            	n1.next = s2;
            	n2.next = null;            
            	last = n2;
            	
            	n1 = t1;
            	n2 = t2;
        		
        	}else if(v1 < v2){
        		s1=n1;
        		s2=n2;
            	while(n1.next != null){   		
            		if(n1.next.val <= v2){
            			n1 = n1.next;
            		}else{
            			break;
            		}   		
            	}  
            	while(n2.next != null){   		
            		if(n2.next.val == v2){
            			n2 = n2.next;
            		}else{
            			break;
            		}   		
            	}
            	ListNode t1 = n1.next;	ListNode t2 = n2.next;
            	
            	last.next = s1;
            	n1.next = s2;
            	n2.next = null;
            	last = n2;
            	
            	n1 = t1;
            	n2 = t2;    		
        		
        		
        	}else{
        		
        		s1=n1;
        		s2=n2;
            	while(n1.next != null){   		
            		if(n1.next.val == v1){
            			n1 = n1.next;
            		}else{
            			break;
            		}   		
            	}  
            	while(n2.next != null){   		
            		if(n2.next.val <= v1){
            			n2 = n2.next;
            		}else{
            			break;
            		}   		
            	}    		
            	ListNode t1 = n1.next;	ListNode t2 = n2.next;  
            	
            	last.next = s2;
        		n2.next = s1;
        		n1.next = null;
        		last = n1;
        		
        		n1 = t1;
        		n2 = t2;
        		
        	}     		    		
    		    		
    	}
    	//At least one list runs out.
    	
    	if(n1 == null && n2 == null){
    		return nhead;
    	}else if(n1 != null && n2 == null){
    		last.next = n1;
    		return nhead;
    	}else if(n1 == null && n2 != null){
    		last.next = n2;
    		return nhead;
    	}else{
    		return null;
    	}
    	   	
    	
    }
    
    public static void main(String[] args) {
    	Solution021 s = new Solution021();
    	ListNode n1 =new ListNode(1); ListNode n2 =new ListNode(1); ListNode n3 =new ListNode(2); ListNode n4 =new ListNode(2); ListNode n5 =new ListNode(4);
    	ListNode n11 =new ListNode(1); ListNode n21 =new ListNode(1); ListNode n31 =new ListNode(2); ListNode n41 =new ListNode(2); ListNode n51 =new ListNode(4);
    	n1.next=n2;	n2.next=n3;	n3.next=n4;	n4.next=n5;
    	n11.next=n21;	n21.next=n31;	n31.next=n41;	n41.next=n51;
    	
    	ListNode res = s.mergeTwoLists(n1, n11);
    	System.out.print(res);
    }
    
    
    
}
