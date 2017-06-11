package scatter;

public class Solution328 {

    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null){    return head;}
        
        ListNode dm1 = new ListNode(-1);
        ListNode dm2 = new ListNode(-1);
        dm1.next = head;    dm2.next = head.next;
        ListNode c1=head;   ListNode c2=head.next;
        
        ListNode cur = head.next.next;
        while(cur != null && cur.next != null){
            c2.next = cur.next; c2 = c2.next;
            c1.next = cur;      c1=c1.next;
            cur = cur.next.next;
        }
        
        if(cur == null){
            c1.next = null;
            c2.next = null;
        }else{
            c1.next = cur;  c1=c1.next;
            c2.next = null;
        }
        
        c1.next = dm2.next; dm2.next=null;
        return dm1.next;
        
    }

}
