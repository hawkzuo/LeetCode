package collectionMedium;

/**
 * Created by Amos on 2017/8/10.
 * Reorder List
 */
public class Sol143 {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) {   return;}

        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // In this case, odd/even doesn't matter    [   isOdd = fast.next == null   ]
        // 012345  012 543  051423
        // 01234   01  432  04132

        ListNode prev = null;
        ListNode cursor = slow.next;
        slow.next = null;
        ListNode anotherHead = null;
        while(cursor != null) {
            ListNode next = cursor.next;
            if(next == null){
                anotherHead = cursor;
            }
            cursor.next = prev;
            prev = cursor;
            cursor = next;
        }
        // Combine
        ListNode c1 = head;
        ListNode c2 = anotherHead;
        while(c2 != null) {
            ListNode c1Next = c1.next;
            ListNode c2Next = c2.next;
            c1.next = c2;
            c2.next = c1Next;
            c1 = c1Next;
            c2 = c2Next;
        }
    }
}
