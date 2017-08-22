package collectionMediumFirstHundred;

/**
 * Created by Amos on 2017/7/26.
 * Reverse Linked List II
 */
public class Sol092 {
    // Just bruteForce
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m==n){return head;}
        if(head == null){return null;}

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

        }else if(n_b_first == null){
            first.next=n_a_last;
            return last;

        }else if(n_a_last == null){
            n_b_first.next=last;
            first.next=null;
            return head;
        }else{
            n_b_first.next=last;
            first.next=n_a_last;
            return head;
        }
    }
}
