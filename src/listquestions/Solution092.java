package listquestions;

public class Solution092 {

	public Solution092() {
		// TODO Auto-generated constructor stub
	}
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m==n){return head;}
        if(head == null){return null;}
        ListNode r_head=head;

        
        ListNode pre=null;
        ListNode now=head;
        
        for(int i=0;i<m-1;i++){
            pre=now;
            now=now.next;
        }
        
        ListNode first=now;
        ListNode n_b_first=pre;
        
        pre=now;
        now=now.next;
        
        for(int i=0;i<n-m;i++){
            ListNode next=now.next;
            now.next=pre;
            pre=now;
            now=next;
        }
        
        ListNode last=pre;
        ListNode n_a_last=now;
        
        if(n_b_first == null && n_a_last == null){
            first.next=null;
            return last;
            
        }else if(n_b_first == null && n_a_last != null){
            first.next=n_a_last;
            return last;
            
        }else if(n_b_first != null && n_a_last == null){
            n_b_first.next=last;
            first.next=null;
            return r_head;
        }else{
            n_b_first.next=last;
            first.next=n_a_last;
            return r_head;            
        }     
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
