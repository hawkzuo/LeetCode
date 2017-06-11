/**
 * 
 */
package microsoft;

/**
 * @author jiany
 *
 */
public class Solution025 {

	/**
	 * @param args
	 */
    public ListNode reverseKGroup(ListNode head, int k) {
        
    	if(head == null){ return null;}
    	if(k == 1){return head;}
    	

    	ListNode pre = null;
    	ListNode start = head;
    	ListNode end = head;
    	ListNode nstart = null;
    	//For now newhead=head
    	ListNode nhead = head;
    	
    	
    	
    	
    	ListNode pt = head;
    	int count = 1;    	
    	while(count < k){
    		pt = pt.next;
    		if(pt == null){
    			end = start;
    			return nhead;
    		}else{
    			count++;
    		}    		    		    	
    	}
    	end = pt;
    	nstart = end.next;
    	//set original pre + newhead
    	pre = start;
    	nhead = end;
    	//Transform
    	ListNode l = start;
    	ListNode r = start.next;
    	while(r != nstart){
    		ListNode t = r.next;
    		r.next = l;
    		l = r;
    		r = t;
    	}
    	
    	//Begin looping
    	while(nstart != null){
    		start = nstart;
/*Wrong version:
    		pt = nstart.next;
	    	count = 1;
	    	while(count < k){

	    		if(pt == null){
	    			//Not sufficient for a new recursion
	    			pre.next = start;
	    			return nhead;
	    		}else{
		    		pt = pt.next;
	    			count ++;
	    		}    		
	    	}
*/	    	
    		pt = nstart;
	    	count = 1;
	    	while(count < k){
	    		pt = pt.next;
	    		if(pt == null){
	    			//Not sufficient for a new recursion
	    			pre.next = start;
	    			return nhead;
	    		}else{

	    			count ++;
	    		}    		
	    	}
    		end = pt;	    	
	    	//set pre+nstart
	    	nstart = end.next;	
	    	pre.next = end;
	    	pre = start;
	    	//Transform
	    	 l = start;
	    	 r = start.next;
	    	while(r != nstart){
	    		ListNode t = r.next;
	    		r.next = l;
	    		l = r;
	    		r = t;
	    	}	    	
	    	
    	
    	}
    	 	
    	pre.next = null;
    	return nhead;
    }	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ListNode l1=new ListNode(1);
		ListNode l2=new ListNode(2);		
		ListNode l3=new ListNode(3);		
		ListNode l4=new ListNode(4);		
		ListNode l5=new ListNode(5);		
		ListNode l6=new ListNode(6);
		ListNode l7=new ListNode(7);
		ListNode l8=new ListNode(8);
		ListNode l9=new ListNode(9);
		l1.next=l2;l2.next=l3;l3.next=l4;l4.next=l5;l5.next=l6;l6.next=l7;l7.next=l8;l8.next=l9;//l9.next=null;
		Solution025 s = new Solution025();
		//s.reverseKGroup(l1, 4);
		System.out.println(s.reverseKGroup(l1, 4));
	}

}
