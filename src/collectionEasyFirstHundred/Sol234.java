package collectionEasyFirstHundred;

import collectionUtils.ListNode;

/**
 * Created by Amos on 2017/9/2.
 * Palindrome Linked List
 */
public class Sol234 {
    // Idea: Use Array/ List and checking => O(n) space O(n) time
    // Another way: Get length[or mid point], and reverse first half of list and reverse back => O(1) space O(n) time
    public boolean isPalindrome(ListNode head) {

        if(head == null || head.next == null){return true;}

        ListNode mid = findMid(head);

        ListNode newHead = reverse(mid.next);

        ListNode n1 = head;	ListNode n2 = newHead;
        while(n2 != null){
            if(n1.val == n2.val){
                n1=n1.next;
                n2=n2.next;
            }else{
                //reverse(newHead);
                return false;
            }
        }

        //reverse(newHead);
        return true;
    }

    //Q 142
    private ListNode findMid(ListNode head){

        ListNode fast = head.next;
        ListNode slow = head;

        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next ;
        }
        return slow;
    }

    //Q 204
    private ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode now = head;

        while(now != null){
            ListNode temp = now.next;
            now.next = prev;
            prev = now;
            now = temp;
        }

        return prev;
    }
}
