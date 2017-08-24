package collectionMediumFirstHundred;

import collectionUtils.ListNode;

/**
 * Created by Amos on 2017/7/13.
 * Swap Nodes in Pairs
 */
public class Sol024 {
    public ListNode swapPairs(ListNode head) {
        if(head == null){ return null;}

        ListNode pre=head;
        ListNode now=head;
        ListNode nhead=null;

        if(now.next == null){ return head;}
        else{
            ListNode n=now.next;
            pre = now;
            now = n.next;
            n.next = pre;
            nhead = n;
        }

        while(now != null){
            if(now.next == null){
                pre.next = now;
                return nhead;

            }else{
                ListNode n=now.next;
                pre.next = n;
                pre = now;
                now = n.next;
                n.next = pre;
            }
        }
        pre.next = null;
        return nhead;
    }
}
