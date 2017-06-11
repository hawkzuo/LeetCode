package scatter;

import java.util.Arrays;

public class Solution148 {

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){	return head;}
    	int len=1;	ListNode cur = head;
    	while(cur.next !=null){
    		len++;	cur = cur.next;
    	}
    	return sort(head,len);
    }

    private ListNode sort(ListNode head, int Len){
    	if(Len <=2){
    		if(Len == 1){	head.next=null;	return head;}
    		ListNode n2 = head.next;
    		if(head.val <= n2.val){	n2.next=null;	return head;}
    		n2.next=head;	head.next=null;	return n2;
    	}
    	//Divide and Conquer
    	int lhalf = -1;	int rhalf = -1;
    	if(Len %2 == 0){	lhalf = Len /2; rhalf = Len/2;	}
    	else{	lhalf = Len /2; rhalf = Len /2+1;	}    	
    	ListNode tmp = head;
    	for(int i=0;i<lhalf;i++){	tmp = tmp.next;	}
    	ListNode lhead = sort(head,lhalf);
    	ListNode rhead = sort(tmp,rhalf);
    	ListNode nhead = merge(lhead,rhead);
    	return nhead;
    }
    
    private ListNode merge(ListNode h1, ListNode h2){
    	ListNode dummy = new ListNode(-1);	ListNode cur = dummy;
    	while(h1 != null && h2 != null){
    		if(h1.val <= h2.val){
    			cur.next=h1;	h1=h1.next;    			
    		}else{
    			cur.next=h2;	h2=h2.next;    			
    		}
    		cur = cur.next;
    	}
    	
    	if(h1 != null && h2 == null){
    		while(h1 !=null){
    			cur.next=h1;	h1=h1.next;
    			cur = cur.next;
    		}
    	}else if(h2 != null && h1 == null){
    		while(h2 !=null){
				cur.next=h2;	h2=h2.next;
				cur = cur.next; 
    		}
    	}    	
    	return dummy.next;
    }
    
    
    
    public ListNode sortListDummy(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        int count = 0;
        ListNode node = head;
        while (node != null) {
            count++;
            node = node.next;
        }
        
        int[] a = new int[count];
        node = head;
        for (int i = 0; i < count; i++) {
            a[i] = node.val;
            node = node.next;
        }
        
        Arrays.sort(a);
        node = head;
        for (int i = 0; i < count; i++) {
            node.val = a[i];
            node = node.next;
        }
        
        return head;
    }   
    
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
