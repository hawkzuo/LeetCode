//61. Rotate List
package companies.microsoft;

public class Solution061 {

	public Solution061() {
		// TODO Auto-generated constructor stub
	}

    public ListNode rotateRight(ListNode head, int k) {

    	int count = 0;
    	if(head == null){	return head;}
    	ListNode begin = head;
    	while(head.next !=null){
    		head = head.next;
    		count++;
    	}
    	int len = count+1;
    	ListNode end = head;    	
    	
    	
    	if(len == 0 || k % len == 0){	return begin;}   
    	if(k > len){
    		//This operation is slow
    		k = k % len;
    	}
    	
    	head = begin;
    	
    	for(int i=0;i<len-k-1;i++){
    		head = head.next;
    	}
    	
    	
    	ListNode nhead = head.next;
    	
    	head.next = null;
    	end.next = begin;
    	return nhead;
    	
    	
    }	
	
/*    
    private int lengthofList(ListNode head){
    	
    	int count = 0;
    	if(head == null){ return count;}
    	while(head != null){
    		head = head.next;
    		count++;
    	}
    	return count;
    	
    }
 */   
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode n1 =new ListNode(1); ListNode n2 =new ListNode(2); ListNode n3 =new ListNode(3); ListNode n4 =new ListNode(4); ListNode n5 =new ListNode(5);
		Solution061 s = new Solution061();	
		n1.next=n2;	n2.next=n3;	n3.next=n4;	n4.next=n5;
		
		System.out.print(s.rotateRight(n1,0));
	}

}
