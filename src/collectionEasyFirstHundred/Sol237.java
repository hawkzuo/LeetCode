package collectionEasyFirstHundred;

import collectionUtils.ListNode;

/**
 * Created by Amos on 2017/9/4.
 * Delete Node in a Linked List
 */
public class Sol237 {
    // Idea: Not really delete, but copy value to next node and 'pretend' deleting the nodes
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
