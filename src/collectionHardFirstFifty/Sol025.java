package collectionHardFirstFifty;

import collectionUtils.ListNode;

/*
 * Created by Amos on 10/23/17.
 * Reverse Nodes in k-Group
 * Reference Sol024
 */
public class Sol025 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode cursor = head;
        int length = 0;
        while(cursor != null) {
            length ++;
            cursor = cursor.next;
        }
        int times = length / k;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        cursor = dummy;
        for(int i=0;i<times;i++) {
            cursor = reverseK(cursor, k);
        }
        return dummy.next;
    }

    private ListNode reverseK(ListNode prev, int k) {
        ListNode head = prev.next;
        ListNode cur = prev.next;
        ListNode pre = prev;
        for(int i=0; i<k; i++) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        prev.next = pre;
        head.next = cur;
        return head;
    }

}
