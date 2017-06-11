package listquestions;

public class Solution206 {

	public Solution206() {
		// TODO Auto-generated constructor stub
	}
	
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode pre=null;
        ListNode now=head;
        while(now.next != null){
            ListNode next=now.next;
            now.next=pre;
            pre=now;
            now=next;
        }
        now.next=pre;
        return now;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
