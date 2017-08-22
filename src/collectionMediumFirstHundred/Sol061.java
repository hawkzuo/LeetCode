package collectionMediumFirstHundred;

/**
 * Created by Amos on 2017/7/23.
 * Rotate List
 */
public class Sol061 {
    public ListNode rotateRight(ListNode head, int k) {

        // Find the joint point as 'newHead' and update pointers
        int count = 0;
        if(head == null){	return null;}
        ListNode begin = head;
        while(head.next !=null){
            head = head.next;
            count++;
        }
        int len = count+1;
        ListNode end = head;

        if(len == 0 || k % len == 0){	return begin;}
        if(k > len){
            k = k % len;
        }

        head = begin;
        for(int i=0;i<len-k-1;i++){
            head = head.next;
        }
        ListNode newHead = head.next;

        head.next = null;
        end.next = begin;
        return newHead;
    }
}
