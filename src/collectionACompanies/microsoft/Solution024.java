/**
 * 
 */
package collectionACompanies.microsoft;

import collectionUtils.ListNode;

/**
 * @author jiany
 *
 */
public class Solution024 {

	/**
	 * @param args
	 */
    public ListNode swapPairs(ListNode head) {
        
    	
    	if(head == null){ return null;}
    	
    	ListNode pre=head;
    	ListNode now=head;
    	ListNode nhead=null;
    	
    	if(now.next == null){ return head;}
    	else{
    		ListNode n=now.next;
    		pre = now;
    		now = n.next;
    		n.next = pre;
    		nhead = n;
    	}
    	
    	while(now != null){
    		if(now.next == null){
    			pre.next = now;
    			return nhead;
    			
    			
    		}else{
        		ListNode n=now.next;
        		pre.next = n;        		
        		pre = now;
        		now = n.next;
        		n.next = pre;    			    			    			
    		}    		
    	}
    	pre.next = null;
    	return nhead;
    }	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
