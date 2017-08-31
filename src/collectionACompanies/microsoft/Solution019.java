//19. Remove Nth Node From End of List
package collectionACompanies.microsoft;

import collectionUtils.ListNode;

public class Solution019 {

	public Solution019() {
		// TODO Auto-generated constructor stub
	}
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
    	int count = 0;
    	if(head == null){	return head;}
    	ListNode begin = head;
    	while(head.next !=null){
    		head = head.next;
    		count++;
    	}
    	int len = count+1;
    	
    	if(n == len){
    		return begin.next;
    	}
    	
    	head = begin;    	   	
    	for(int i=0;i<len-n-1;i++){
    		head = head.next;
    	}
    	head.next = head.next.next;
    	return begin;
    	
    	
    	
    	
    	
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode n1 =new ListNode(1); ListNode n2 =new ListNode(2); ListNode n3 =new ListNode(3); ListNode n4 =new ListNode(4); ListNode n5 =new ListNode(5);
		ListNode n6 = new ListNode(6);
		Solution019 s = new Solution019();	
		n1.next=n2;	n2.next=n3;	n3.next=n4;	n4.next=n5; n5.next = n6;
		System.out.print(s.removeNthFromEnd(n6, 1));
	}

}
