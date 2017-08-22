package collectionMediumFirstHundred;

/**
 * Created by Amos on 2017/8/10.
 * Sort List
 */
public class Sol148 {
    public ListNode sortList(ListNode head) {
        // Idea: Merge-Sort
        // Sort half by half
        // T(n) = 2T(n/2) + O(n)    => T(n) = O(nlgn)

        if(head == null || head.next == null){	return head;}
        int len=1;	ListNode cur = head;
        while(cur.next !=null){
            len++;	cur = cur.next;
        }
        return sort(head,len);
    }

    private ListNode sort(ListNode head, int Len){
        if(Len <=2){
            if(Len == 1){	head.next=null;	    return head;}
            ListNode n2 = head.next;
            if(head.val <= n2.val){	n2.next=null;	return head;}
            n2.next=head;	head.next=null;	    return n2;
        }

        int lHalf;	int rHalf;
        if(Len %2 == 0){
            lHalf = Len /2; rHalf = Len/2;
        }else{
            lHalf = Len /2; rHalf = Len /2+1;
        }

        ListNode tmp = head;
        for(int i=0;i<lHalf;i++){
            tmp = tmp.next;
        }
        ListNode lHead = sort(head, lHalf);
        ListNode rHead = sort(tmp, rHalf);
        return merge(lHead, rHead);
    }

    private ListNode merge(ListNode h1, ListNode h2){
        // Good use of 'dummy' node
        ListNode dummy = new ListNode(-1);	ListNode cur = dummy;
        while(h1 != null && h2 != null){
            if(h1.val <= h2.val){
                cur.next=h1;
                h1=h1.next;
                cur = cur.next;
            }else{
                cur.next=h2;
                h2=h2.next;
                cur = cur.next;
            }
        }

        if(h1 != null){
            while(h1 !=null){
                cur.next=h1;
                h1=h1.next;
                cur = cur.next;
            }
        }else if(h2 != null){
            while(h2 !=null){
                cur.next=h2;	h2=h2.next;
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
