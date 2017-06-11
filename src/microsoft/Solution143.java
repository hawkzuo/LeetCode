package microsoft;

import java.util.HashMap;
import java.util.Map;

public class Solution143 {

	public Solution143() {
		// TODO Auto-generated constructor stub
	}
	
    public void reorderList(ListNode head) {
     
    	if(head == null || head.next == null){ return; }  	
    	    	
    	int len = 0;
    	ListNode t = head;
    	
    	
/* Slow Version, but no extra space needed.    	
    	while(t!= null){
    		len++;
    		t=t.next;
    	}
   	
    	t = head;
    	
    	if(len % 2 == 0){
    		//Even
    		//Perform transform
    		for(int i=0; i<len/2-1; i++){
    			ListNode n = t.next;
    			
    			//new next node
    			ListNode nnext = t;
    			for(int j=0;j<len-1-2*i;j++){
    				nnext = nnext.next;    				
    			}
    			//Change two nexts
    			t.next = nnext;
    			nnext.next = n;
    			//Update t
    			t = n;    			
    			
    		}
    		//Last perform
    		t.next.next = null;
    		
    	}else{
    		//Odd
    		for(int i=0; i<len/2; i++){
    			ListNode n = t.next;
    			
    			//new next node
    			ListNode nnext = t;
    			for(int j=0;j<len-1-2*i;j++){
    				nnext = nnext.next;    				
    			}
    			
    			t.next = nnext;
    			nnext.next = n;
    			
    			t = n;    			   			
    		}    		
    		//Last Perform
    		t.next = null;
    	}
*/
/* faster version, but need O(n) space */    	
    	Map<Integer,ListNode> m=new HashMap<Integer,ListNode>();    	
    	
    	while(t!= null){
    		len++;
    		m.put(len, t);   		
    		t=t.next;
    	}    	
    	
    	for(int i=0;i<(len+1)/2-1;i++){    		
    		int k = i+1;
    		m.get(k).next = m.get(len+1-k);  
    		m.get(len+1-k).next = m.get(k+1);
    	}
    	
    	if(len % 2 != 0){
    		//Odd
    		m.get((len+1)/2).next = null;
    		
    		
    	}else{
    		//Even
    		m.get((len+1)/2+1).next = null;
    	}
//Fastest version is using 2 pointers    	
    	
    	
    	
    	
    	
    	
    	
    }
    
    
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution143 s = new Solution143();
		
		ListNode n1 = new ListNode(1); ListNode n2 = new ListNode(2); ListNode n3 = new ListNode(3); ListNode n4 = new ListNode(4); ListNode n5 = new ListNode(5); ListNode n6 = new ListNode(6);
		
		n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5; //n5.next = n6;
		
		s.reorderList(n1);
		System.out.print(n1);
		
		
		
	}

}
