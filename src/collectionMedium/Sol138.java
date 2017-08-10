package collectionMedium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Amos on 2017/8/10.
 * Copy List with Random Pointer
 */
public class Sol138 {
    public RandomListNode copyRandomList(RandomListNode head) {
        // Idea: Establish connections between copied and old list via direct structure
        if(head == null) return null;
        // Step1: double list
        RandomListNode cursor = head;
        while(cursor != null) {
            RandomListNode copied = new RandomListNode(cursor.label);
            RandomListNode realNext = cursor.next;
            // Modify structure
            cursor.next = copied;   copied.next = realNext;
            cursor = realNext;
        }
        // Step2: copy Random
        cursor = head;
        while(cursor != null) {
            RandomListNode realRandom = cursor.random;
            if(realRandom == null) {
                cursor = cursor.next.next;
            }else {
                RandomListNode copiedCursor = cursor.next;
                RandomListNode realNext = cursor.next.next;

                copiedCursor.random = cursor.random.next;
                cursor = realNext;
            }
        }
        // Step3: break connection
        cursor = head;
        RandomListNode newHead = head.next;
        while(cursor != null) {
            RandomListNode copiedCursor = cursor.next;
            RandomListNode realNext = cursor.next.next;
            // Modify structure
            cursor.next = realNext;
            if(realNext == null) {
                copiedCursor.next = null;
            }else {
                copiedCursor.next = realNext.next;
            }
            cursor = realNext;
        }
        return newHead;
    }

    public RandomListNode copyRandomListMap(RandomListNode head) {
        // Idea: Establish connections between copied and old list via HashMap
        if(head == null){return null;}
        Map<RandomListNode,RandomListNode> m=new HashMap<>();

        RandomListNode now=head;
        RandomListNode n_head=new RandomListNode(now.label);
        RandomListNode n_now=n_head;
        m.put(now, n_now);
        while(now.next != null){
            RandomListNode n_next=new RandomListNode(now.next.label);
            m.put(now.next, n_next);
            n_now.next=n_next;
            n_now=n_next;
            now=now.next;
        }

        now=head;
        while(now.next != null){
            if(now.random != null){
                m.get(now).random=m.get(now.random);
            }
            //Move on
            now=now.next;
        }
        //now will be the last node <- Take care of leftovers
        if(now.random != null){
            m.get(now).random=m.get(now.random);
        }
        return n_head;
    }

}
