package collectionMediumFirstHundred;

import collectionUtils.ListNode;

/**
 * Created by Amos on 2017/7/13.
 * Remove Nth Node From End of List
 */
public class Sol019 {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        int count = 0;
        if(head == null){	return null;}
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
}
