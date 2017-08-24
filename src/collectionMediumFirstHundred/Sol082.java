package collectionMediumFirstHundred;

import collectionUtils.ListNode;

/**
 * Created by Amos on 2017/7/26.
 * Remove Duplicates from Sorted List II
 */
public class Sol082 {
//    Given 1->2->3->3->4->4->5, return 1->2->5.
//    Given 1->1->1->2->3, return 2->3.
    // DUMMY NODE
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){  return head;}

        ListNode dummy = new ListNode(-1);
        ListNode currentStepNode = head;  ListNode previousNode = dummy;
        while(currentStepNode != null ){
            if(currentStepNode.next == null){
                // Single node (either originally or only 1 left)
                previousNode.next = currentStepNode;
                previousNode = currentStepNode;
                currentStepNode = null;
                continue;
            }
            int stepVal = currentStepNode.val;
            if(stepVal == currentStepNode.next.val){
                // Don't append currentStepNode and the following nodes with the same value
                // Find the next node with different value
                ListNode nextStep = currentStepNode.next;
                while(nextStep != null && nextStep.val == stepVal){
                    nextStep = nextStep.next;
                }
                //No matter what situation
                currentStepNode = nextStep;
            }else{
                previousNode.next = currentStepNode;
                previousNode = currentStepNode;
                currentStepNode = currentStepNode.next;
            }
        }
        previousNode.next = null;
        return dummy.next;
    }
}
