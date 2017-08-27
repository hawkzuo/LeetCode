package collectionEasyFirstHundred;

import collectionUtils.ListNode;

/**
 * Created by Amos on 2017/8/27.
 * Intersection of Two Linked Lists
 */
public class Sol160 {
    // Legacy Idea: Use length of A,B to determine the joint point
    // Seems hard to improve efficiency or elegance
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if(headA == null || headB == null){ return null;}

        ListNode t1 = headA;	ListNode t2 = headB;
        int lenA = 0;	int lenB = 0;

        while(t1 != null){
            lenA++;
            t1 = t1.next;
        }
        while(t2 != null){
            lenB++;
            t2 = t2.next;
        }

        int diff = lenA - lenB;

        t1 = headA; t2 = headB;

        if(diff > 0){
            for(int i=0; i<lenA-lenB ; i++){
                t1 = t1.next;
            }
        }
        else if(diff < 0){
            for(int i=0; i<-lenA+lenB ; i++){
                t2 = t2.next;
            }
        }

        while(t1 != null && t2 != null){
            if(t1 == t2){
                return t1;
            }else{
                t1 = t1.next;
                t2 = t2.next;
            }
        }
        return null;
    }
}
