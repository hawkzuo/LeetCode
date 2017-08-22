package collectionMediumFirstHundred;

/**
 * Created by Amos on 2017/7/26.
 * Partition List
 */
public class Sol086 {
    // DOUBLE DUMMY
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null){  return head;}

        ListNode dummy1 = new ListNode(-1); ListNode c1=dummy1;
        ListNode dummy2 = new ListNode(-1); ListNode c2=dummy2;

        ListNode cur = head;
        while(cur!= null){
            if(cur.val < x){
                c1.next = cur;  c1=c1.next;
            }else{
                c2.next = cur;  c2=c2.next;
            }
            cur = cur.next;
        }
        c1.next = null; c2.next = null;
        c1.next = dummy2.next;  dummy2.next = null;
        return dummy1.next;
    }
}
