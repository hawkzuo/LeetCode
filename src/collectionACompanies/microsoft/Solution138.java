package collectionACompanies.microsoft;

import collectionUtils.RandomListNode;

import java.util.HashMap;
import java.util.Map;

//HashMap<k,V> k doesn't have to be a number
//Time & Space comp O(2n)

public class Solution138 {

	public Solution138() {
		// TODO Auto-generated constructor stub
	}
    public RandomListNode copyRandomList(RandomListNode head) {
    	//Omitted first time
        if(head == null){return null;}
        Map<RandomListNode,RandomListNode> m=new HashMap<RandomListNode,RandomListNode>();
    	
        RandomListNode now=head;
        
        RandomListNode n_head=new RandomListNode(now.label);
        RandomListNode n_now=n_head;
        
        m.put(now, n_now);
        
        
        while(now.next != null){
        	RandomListNode n_next=new RandomListNode(now.next.label);
        	
        	m.put(now.next, n_next);
        	
        	n_now.next=n_next;
        	n_now=n_next;
        	now=now.next;        	        	        	
        }
        
        now=head;
        while(now.next != null){
        	if(now.random != null){
        		m.get(now).random=m.get(now.random);
        	}
        	//Move on
        	now=now.next;
        	
        }
        //now will be the last node
    	if(now.random != null){
    		m.get(now).random=m.get(now.random);
    	}
        
        
    	return n_head;
    	
    	
    }
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
